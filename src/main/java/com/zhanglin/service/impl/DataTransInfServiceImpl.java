package com.zhanglin.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import com.zhanglin.pojo.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhanglin.Constant;
import com.zhanglin.bean.Data;
import com.zhanglin.bean.Detail;
import com.zhanglin.bean.FileName;
import com.zhanglin.bean.Trade;
import com.zhanglin.cache.CacheManager;
import com.zhanglin.cache.DataManager;
import com.zhanglin.service.IDataTransInfService;
import com.zhanglin.service.IDescomService;
import com.zhanglin.service.IMarketService;
import com.zhanglin.service.IRequestService;
import com.zhanglin.tools.CustomizedPropertyConfigurer;
import com.zhanglin.tools.FileTools;

@Transactional
@Service("dataTransInfService")
public class DataTransInfServiceImpl implements IDataTransInfService {
	private static Logger logger = Logger.getLogger(DataTransInfServiceImpl.class); 
	@Resource
	IDescomService service;
	@Resource
	IRequestService reqService;
	@Resource
	IMarketService marketService;
    private String tempPath = CustomizedPropertyConfigurer.getStringContextProperty("tempPath");
    private String orderFilePath = CustomizedPropertyConfigurer.getStringContextProperty("orderFilePath");
//    private boolean initholdingflag = CustomizedPropertyConfigurer.getBooleanContextProperty("initholdingflag");
	
	public void reciveData(Data data) throws Exception{
		reqService.insertRequest(data,Constant.REQUEST_STATUS_PENDING);
		DataManager.getInstance().addData(data);
	}
	public void dataTransInfo(Data data) throws Exception{
		long now = System.currentTimeMillis();
		logger.info("开始处理数据,requestid:"+data.getRequestId().intValue()+",data:"+data);
		if(reqService.getRequest(data)==null){
			handleData(data,true);
		}else{
			reqService.updateRequest(data,Constant.REQUEST_STATUS_IGNOER);
			logger.info("重复请求,requestid:"+data.getRequestId().intValue()+",data:"+data);
		}
		logger.info("数据处理完成,耗时:"+(System.currentTimeMillis()-now)+",requestid:"+data.getRequestId().intValue()+",data:"+data);
	}
	/**
	 * @param data 数据
	 * @param isFromInterface 是否为接口数据
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Exception.class)
	public void handleData(Data data,boolean isFromInterface) throws Exception {
		List<Descom> descoms = CacheManager.getInstance().getDescom(data.getId());
		try{
			for (int i = 0; i < descoms.size(); i++) {
				Descom descom =  descoms.get(i);
				if(descom!=null&&descom.getIstrue().compareTo(BigDecimal.ONE)==0){

					boolean initholdingflag = (descom.getTstatus().intValue()==1);
					//初始化操作只能操作initholdingflag状态组合
					if(!isFromInterface&&!initholdingflag){
						return;
					}
					//清除指令文件，避免脏数据
					String filename = getFileName(descom, data);
					FileTools.delete(filename, tempPath);
					for (Iterator<Detail> iterator = data.getDetails().iterator(); iterator.hasNext();) {
						Detail detail = iterator.next();
						if(checkRisk(detail) ){
							AllClose allClose = CacheManager.getInstance().getAllClose().get(generateWindCode(detail.getCode()));
							//生成真实价格
							generateRelaPrice(detail,allClose);
							//该股票是否为初始化持仓中的股票
							boolean isInitHolding = false;
							//接口数据并且需要处理初始化持仓，判断股票是否在初始化持仓中
							if(isFromInterface&&initholdingflag){
								isInitHolding = isInitHolding(detail,descom.getNewid());
							}
							logger.info("isInitHolding="+isInitHolding);
							BigDecimal changePosition = generatePosition(descom,detail,data.getNetvalue(),isInitHolding);
							if(changePosition.compareTo(BigDecimal.ZERO)==1){
								//数据来自接口或者系统不需要处理初始化持仓数据
								if(isFromInterface||!initholdingflag){
									generateRecord(descom,detail,changePosition,data,isInitHolding,filename);
								}else{
									//如果是处理初始化持仓中，需要减去本日卖出的数量，卖出持仓本身就为负数
									logger.info(detail.getCode()+"本日卖出数量为："+descom.getInitHoldCodeAccount(detail.getCode()));
									BigDecimal realPosition =  changePosition.add(descom.getInitHoldCodeAccount(detail.getCode()));
									if(realPosition.compareTo(BigDecimal.ZERO)>0){
										generateRecord(descom,detail,realPosition,data,isInitHolding,filename);
									}else{
										logger.info("实际需交易数量为0，不做处理,detail:"+detail);
									}
								}
							}else{
								logger.info("需交易数量为0，不做处理,detail:"+detail);
							}
						}

						//插入order信息
						Order order =new Order(detail,data);
						order.setNewid(descom.getNewid());
						service.insertOrder(order);
					}
					FileTools.copy(filename, tempPath , orderFilePath);
				}
			}
			if(null == descoms || descoms.size()==0){
				logger.info("未找到对应组合，不做处理,id:"+data.getId());
			}
			if(isFromInterface)
				reqService.updateRequest(data,Constant.REQUEST_STATUS_SUCESS);
		}catch(Exception e){
			logger.error("生成交易指令异常，事务回滚。");
			cacheRollBack(descoms);
			throw e;
		}
	}

	/**
	 * 如果是买入： newprice=price*(1+比例)，用newprice与涨停价比较，如果小于等于涨停价，就用newprice做为指令文件中的价格，否则用涨停价作为指令文件中的价格。
	 * 如果是卖出:  newprice=price*(1-比例)，用newprice与跌停价比较，如果大于等于跌停价，就用newprice做为指令文件中的价格，否则用跌停价作为指令文件中的价格。
	 * @param detail
	 * @param allClose
	 * @throws Exception
	 */
	private void generateRelaPrice(Detail detail, AllClose allClose) throws Exception {
		BigDecimal ratio = new BigDecimal(CustomizedPropertyConfigurer.getStringContextProperty("ratio"));
		BigDecimal newprice;
		if(detail.getTrading_type()==Constant.TRADE_TYPE_BUY) {
			BigDecimal tempprice = detail.getPrice().multiply(new BigDecimal(1).add(ratio));
			if(allClose.getZt().subtract(tempprice).compareTo(new BigDecimal(0))>0){
				newprice = tempprice;
			}else{
				newprice = allClose.getZt();
			}
		}else if(detail.getTrading_type()==Constant.TRADE_TYPE_SELL){
			BigDecimal tempprice = detail.getPrice().multiply(new BigDecimal(1).subtract(ratio));
			if(allClose.getDt().subtract(tempprice).compareTo(new BigDecimal(0))<0){
				newprice = tempprice;
			}else{
				newprice = allClose.getDt();
			}
		}else{
			throw new Exception("未获取到正确的买卖标识");
		}
		detail.setPrice(newprice);
	}

	private boolean isInitHolding(Detail detail, BigDecimal newId) {
		//key为股票代码_newid
//		return CacheManager.getInstance().getInitHolding().containsKey(detail.getCode()+"_"+newId.intValue());
		return true;
	}
	private String getFileName(Descom descom, Data data) {
		FileName filename = new FileName();
		filename.setNewid(descom.getNewid().toString());
		filename.setOrdertime(data.getOrdertime());
		filename.setRealtime(data.getRealtime());
		logger.info(filename.toString());
		return filename.toString();
	}

	/**
	 * 生成交易指令
	 * @param detail
	 * @param isInitHolding 
	 * @throws Exception
	 */
	private void generateRecord(Descom descom, Detail detail, BigDecimal changePosition,Data data, boolean isInitHolding, String filename) throws Exception {
		if(isInitHolding&&detail.getTrading_type()==Constant.TRADE_TYPE_SELL){
			generateInitRecord(descom, detail, changePosition, data);
		}else{
			generateCommonRecord(descom, detail, changePosition, data, filename);
		}
	}
	private void generateInitRecord(Descom descom, Detail detail,
			BigDecimal changePosition, Data data) {
		//买入持仓为正，卖出持仓为负
		BigDecimal num = detail.getTrading_type()==Constant.TRADE_TYPE_BUY?changePosition:changePosition.negate();
		//更新持仓信息
		PositionRT position = new PositionRT();
		position.setCode(detail.getCode());
		position.setHoldprice(detail.getPrice());
		position.setNewid(descom.getNewid());
		position.setNum(num);
		position.setUpdatetime(new Date());
		position.setSource(Constant.POSITION_SOURCE_INITHOLDING);
		updatePositionRT(descom, position);
	}
	private void updatePositionRT(Descom descom, PositionRT position) {
		service.updatePositionRT(position);
		//更新内存中的持仓数据
		descom.addPosition(position);
	}
	private void generateCommonRecord(Descom descom, Detail detail,
			BigDecimal changePosition, Data data, String filename) throws Exception {
		//插入record数据
		Record record = new Record(detail,data);
		record.setNewid(descom.getNewid());
		//Num:交易数量，当为买入时，num应该是负值，卖出时num为正值。
		record.setNum(detail.getTrading_type()==Constant.TRADE_TYPE_BUY?changePosition.negate():changePosition);
		record.setPrice(detail.getPrice());
		service.insertRecord(record);
		//买入持仓为正，卖出持仓为负
		BigDecimal num = detail.getTrading_type()==Constant.TRADE_TYPE_BUY?changePosition:changePosition.negate();
		
		//生成交易指令文件
		createOrder(detail,changePosition,filename);
		
		//更新持仓信息
		PositionRT position = new PositionRT();
		position.setCode(detail.getCode());
		position.setHoldprice(detail.getPrice());
		position.setNewid(descom.getNewid());
		position.setNum(num);
		position.setUpdatetime(new Date());
		position.setSource(Constant.POSITION_SOURCE_NEW);
		updatePositionRT(descom, position);
		
		//更新资金信息
		AssetRT asset = descom.getAsset();
		//最新资金=最新资金-(交易价格*交易数量)
		asset.setCash(asset.getCash().subtract(detail.getPrice().multiply(num)));
		service.updateAssetRT(asset);
	}
	
	/**
	 * 生成交易指令文件
	 * @param detail
	 * @param changePosition
	 * @param filename 
	 * @throws Exception 
	 */
	private void createOrder(Detail detail, BigDecimal changePosition, String filename) throws Exception {
		Trade trade = new Trade();
		trade.setCode(detail.getCode());
		trade.setTradetype(String.valueOf(detail.getTrading_type()));
		trade.setNum(changePosition.toString());
		
		FileTools.write(filename, tempPath, trade.getTradeOrder().getBytes());
	}

	private void cacheRollBack(List<Descom> descoms) {
		//TODO 可能需要改为直接操作内存数据,目前直接设置为过期
		if( null != descoms && descoms.size()>0) {
			CacheManager.getInstance().invalidate(descoms.get(0).getId());
		}
	}

	/**
	 * 匹配组合持仓 
	 * @param descom
	 * @param detail
	 * @param net 
	 * @param isInitHolding 是否初始持仓
	 */
	private BigDecimal generatePosition(Descom descom, Detail detail, BigDecimal net, boolean isInitHolding) {
		BigDecimal changePosition = BigDecimal.ZERO;
		//持仓数量
		BigDecimal positionAccount = descom.getHoldedCodeAccount(detail.getCode());
		if(null==positionAccount){
			positionAccount = BigDecimal.ZERO;
		}
		
		AssetRT asset = descom.getAsset();
		//没有资金，按照资金为0计算
		if(asset==null){
			asset = new AssetRT();
			asset.setCash(BigDecimal.ZERO);
			asset.setAsset(BigDecimal.ZERO);
		}
		BigDecimal price = detail.getPrice();
		//分子=(调仓前权重/100 - 调仓后权重/100)*总资产
		BigDecimal numerator = detail.getWeight1().divide(Constant.WEIGHT_MULTIPLE).subtract(detail.getWeight2().divide(Constant.WEIGHT_MULTIPLE)).multiply(asset.getAsset());
		//分母=委托价格
		BigDecimal denominator = price;
		//数量=分子/分母;(100的整数倍，向下取整, 不足100为0)
		changePosition = numerator.divide(denominator.multiply(Constant.POSITION_MULTIPLE),0,BigDecimal.ROUND_DOWN).multiply(Constant.POSITION_MULTIPLE);
		
		//买入指令
		if(detail.getTrading_type()==Constant.TRADE_TYPE_BUY){
			//买入数量=(数量)A的绝对值;
			BigDecimal buyPosition = changePosition.abs();
			//买入理论资金=买入数量*委托价格
			BigDecimal needAsset = buyPosition.multiply(price);
			//买入需要资金大于可以资金，买入数量=cash/委托价格, (100的整数倍，向下取整, 不足100为0)
			if(needAsset.compareTo(asset.getCash())==1){
				changePosition = asset.getCash().divide(price.multiply(Constant.POSITION_MULTIPLE),0,BigDecimal.ROUND_DOWN).multiply(Constant.POSITION_MULTIPLE);
			}else{
				//买入理论资金<=cash,实际买入数量=买入数量
				changePosition = buyPosition;
			}
		}
		
		//卖出指令
		if(detail.getTrading_type()==Constant.TRADE_TYPE_SELL){
			//初始持仓，只计算数量
			if(isInitHolding){
				changePosition = changePosition.abs();
			}else{
				//未持仓，不做交易
				if(positionAccount.compareTo(BigDecimal.ZERO)<=0){
					changePosition = BigDecimal.ZERO; 
				}else{
					//调仓后权重==0,实际卖出数量=持仓数量
					if(detail.getWeight2().compareTo(BigDecimal.ZERO)==0){
						changePosition = positionAccount;
					}else{
						//卖出数量=(数量)A的绝对值
						BigDecimal sellPosition = changePosition.abs();
						//实际卖出数量=min(持仓数量，卖出数量);
						changePosition = sellPosition.compareTo(positionAccount)==-1?sellPosition:positionAccount;
					}
				}
			}
		}
		return changePosition;
	}

	/**
	 * 风控检查
	 * 1.非st;2.只交易6或0或3开头的
	 */
	private boolean checkRisk(Detail detail) {
		String windCode = generateWindCode(detail.getCode());
		//判断是否为ST股票
		if(CacheManager.getInstance().getSTCode().containsKey(windCode)){
			return false;
		}
		String beginCode = detail.getCode().substring(2, 3);
		if(!(beginCode.equals("0")||beginCode.equals("3")||beginCode.equals("6"))){
			return false;
		}
		AllClose allClose = CacheManager.getInstance().getAllClose().get(windCode);
		//判断ALLCLOSE是否存在且是交易状态
		if(allClose == null || !"交易".equals(allClose.getStatus())){
			return false;
		}
		return true;
	}
	private String generateWindCode(String code) {
		return code.substring(2)+"."+code.substring(0, 2);
	}
	@Transactional(rollbackFor=Exception.class)
	public void handleInitHolding(){
		logger.info("准备处理初始化持仓数据");
		try{
			List<InitHolding> initHoldings = marketService.getInitHoldingList();
			for (Iterator<InitHolding> iterator = initHoldings.iterator(); iterator.hasNext();) {
				InitHolding initHolding = iterator.next();
				String windCode = generateWindCode(initHolding.getCode());
				AllClose allClose = CacheManager.getInstance().getAllClose().get(windCode);
				//判断ALLCLOSE是否存在且是交易状态,获取涨停价格
				if(allClose == null || !"交易".equals(allClose.getStatus())){
					return;
				}
				Data data  = new Data();
				
				Detail detail = new Detail();
				detail.setCode(initHolding.getCode());
				detail.setPrice(allClose.getZt());
				detail.setTrading_type(Constant.TRADE_TYPE_BUY);
				detail.setWeight1(BigDecimal.ZERO);
				detail.setWeight2(initHolding.getWeight());
				
				List<Detail> details = new ArrayList<Detail>();
				details.add(detail);
				data.setDetails(details);
				data.setDelay(0);
				data.setMsguid("initholding_"+initHolding.getNewid());
				data.setOrigJson("{}");
				data.setRequestId(BigDecimal.ZERO);
				data.setId(initHolding.getId());
				data.setNetvalue(initHolding.getNet());
				data.setOrdertime(new SimpleDateFormat(Constant.DEFAULT_DATE_FORMAT).format(new Date()));
				data.setRealtime(new SimpleDateFormat("HHmm").format(new Date()));
				logger.info("开始处理初始化持仓数据："+data);
				handleData(data, false);
				InitHoldingLog holding  = new InitHoldingLog(initHolding);
				service.insertInitHoldingLog(holding);
			}
		}catch(Exception e){
			logger.error("处理初始化持仓数据异常",e);
		}
		logger.info("处理初始化持仓数据成功");
	}
}
