package com.zhanglin.service.impl;

import java.math.BigDecimal;
import java.util.Iterator;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhanglin.Constant;
import com.zhanglin.bean.Config;
import com.zhanglin.bean.Data;
import com.zhanglin.bean.Detail;
import com.zhanglin.bean.FileName;
import com.zhanglin.bean.Trade;
import com.zhanglin.cache.CacheManager;
import com.zhanglin.cache.DataManager;
import com.zhanglin.pojo.AssetRT;
import com.zhanglin.pojo.Descom;
import com.zhanglin.pojo.Order;
import com.zhanglin.pojo.Record;
import com.zhanglin.service.IDataTransInfService;
import com.zhanglin.service.IDescomService;
import com.zhanglin.service.IRequestService;
import com.zhanglin.tools.FileTools;

@Transactional
@Service("dataTransInfService")
public class DataTransInfServiceImpl implements IDataTransInfService {
	private static Logger logger = Logger.getLogger(DataTransInfServiceImpl.class); 
	@Resource
	private Config config;
	@Resource
	IDescomService service;
	@Resource
	IRequestService reqService;
	
	public void reciveData(Data data) throws Exception{
		reqService.insertRequest(data,Constant.REQUEST_STATUS_PENDING);
		DataManager.getInstance().addData(data);
	}
	@Transactional(rollbackFor=Exception.class)
	public void dataTransInfo(Data data) throws Exception{
		long now = System.currentTimeMillis();
		logger.info("开始处理数据,requestid:"+data.getRequestId().intValue()+",data:"+data);
		if(reqService.getRequest(data)==null){
			Descom descom = CacheManager.getInstance().getDescom(data.getId());
			try{
				if(descom!=null&&descom.getIstrue().compareTo(BigDecimal.ONE)==0){
					//清除指令文件，避免脏数据
					String filename = getFileName(descom, data);
					FileTools.delete(filename, config.getTempPath());
					for (Iterator<Detail> iterator = data.getDetails().iterator(); iterator.hasNext();) {
						Detail detail = iterator.next();
						if(checkRisk(detail)){
							BigDecimal changePosition = generatePosition(descom,detail,data.getNetvalue());
							if(changePosition.compareTo(BigDecimal.ZERO)==1){
								generateOrder(descom,detail,changePosition,data);
							}else{
								logger.info("需交易数量为0，不做处理,detail:"+detail);
							}
						}
					}
					FileTools.copy(filename, config.getTempPath(), config.getOrderFilePath());
				}else{
					logger.info("未找到对应组合，不做处理,id:"+data.getId());
				}
				reqService.updateRequest(data,Constant.REQUEST_STATUS_SUCESS);
			}catch(Exception e){
				logger.error("生成交易指令异常，事务回滚。");
				cacheRollBack(descom);
				throw e;
			}
		}else{
			reqService.updateRequest(data,Constant.REQUEST_STATUS_IGNOER);
			logger.info("重复请求,requestid:"+data.getRequestId().intValue()+",data:"+data);
		}
		logger.info("数据处理完成,耗时:"+(System.currentTimeMillis()-now)+",requestid:"+data.getRequestId().intValue()+",data:"+data);
	}

	private String getFileName(Descom descom, Data data) {
		FileName filename = new FileName();
		filename.setNewid(descom.getNewid().toString());
		filename.setOrdertime(data.getOrdertime());
		filename.setRealtime(data.getRealtime());
		
		return filename.toString();
	}

	/**
	 * 生成交易指令
	 * @param newId 
	 * @param detail
	 * @param num
	 * @throws Exception 
	 */
	private void generateOrder(Descom descom, Detail detail, BigDecimal changePosition,Data data) throws Exception {
		//插入交易信息
		Order order =new Order(detail,data);
		order.setNewid(descom.getNewid());
		service.insertOrder(order);
		//插入record数据
		Record record = new Record(detail,data);
		record.setNewid(descom.getNewid());
		record.setNum(changePosition);
		service.insertRecord(record);
		//买入持仓为正，卖出持仓为负
		BigDecimal num = detail.getTrading_type()==Constant.TRADE_TYPE_BUY?changePosition:changePosition.negate();
		//更新资金信息
		AssetRT asset = descom.getAsset();
		//最新资金=最新资金-(交易价格*交易数量)
		asset.setCash(asset.getCash().subtract(detail.getPrice().multiply(num)));
		service.updateAssetRT(asset);
		//生成交易指令文件
		createOrder(detail,changePosition,getFileName(descom, data));
		
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
		
		FileTools.write(filename, config.getTempPath(), trade.getTradeOrder().getBytes());
	}

	private void cacheRollBack(Descom descom) {
		//TODO 可能需要改为直接操作内存数据,目前直接设置为过期
		CacheManager.getInstance().invalidate(descom.getId());
	}

	/**
	 * 匹配组合持仓 
	 * @param descom
	 * @param detail
	 * @param net 
	 */
	private BigDecimal generatePosition(Descom descom, Detail detail, BigDecimal net) {
		BigDecimal changePosition = BigDecimal.ZERO;
		//持仓数量
		BigDecimal positionAccount = descom.getCodeAccount(detail.getCode());
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
		//分子=(调仓后权重-调仓前权重)*总资产的平方
		BigDecimal numerator = detail.getWeight2().subtract(detail.getWeight1()).multiply(asset.getAsset().pow(2));
		//分母=期初总资产*调仓瞬时净值*委托价格
		//期初总资产此处取出来单位为万元
		BigDecimal denominator = descom.getFirstAsset().getAsset().multiply(Constant.ASSET_UNIT).multiply(net).multiply(price);
		//数量=分子/分母;(100的整数倍，向下取整, 不足100为0)
		changePosition = numerator.divide(denominator.multiply(Constant.POSITION_MULTIPLE),0,BigDecimal.ROUND_DOWN).multiply(Constant.POSITION_MULTIPLE);
		
		//买入指令
		if(detail.getTrading_type()==Constant.TRADE_TYPE_BUY){
			BigDecimal needAsset = changePosition.multiply(price);
			//买入需要资金大于可以资金，买入数量=cash/委托价格, (100的整数倍，向下取整, 不足100为0)
			if(needAsset.compareTo(asset.getCash())==1){
				changePosition = asset.getCash().divide(price.multiply(Constant.POSITION_MULTIPLE),0,BigDecimal.ROUND_DOWN).multiply(Constant.POSITION_MULTIPLE);
			}
		}
		
		//卖出指令
		if(detail.getTrading_type()==Constant.TRADE_TYPE_SELL){
			//未持仓，不做交易
			if(positionAccount.compareTo(BigDecimal.ZERO)!=1){
				changePosition = BigDecimal.ZERO; 
			}
		}
		return changePosition;
	}

	/**
	 * 风控检查
	 * 1.单只个股权调仓后最大权重不超过30%,超过就按30%算;2.非st.
	 * @param descom
	 */
	private boolean checkRisk(Detail detail) {
		
//		if(detail.getWeight2().compareTo(config.getMaxWeight())>0){
//			detail.setWeight2(config.getMaxWeight());
//			logger.info("请求数据:"+detail+",权重大于"+config.getMaxWeight().multiply(new BigDecimal(100))+",设置为最大权重");
//		}
//		
//		//TODO 判断是否为ST股票
//		if(detail.getCode()==null){
//			return false;
//		}
		return true;
	}

}
