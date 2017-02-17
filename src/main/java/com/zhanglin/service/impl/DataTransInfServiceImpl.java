package com.zhanglin.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
		//Num:交易数量，当为买入时，num应该是负值，卖出时num为正值。
		record.setNum(detail.getTrading_type()==Constant.TRADE_TYPE_BUY?changePosition.negate():changePosition);
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
		//分子=(调仓前权重/100 - 调仓后权重/100)*总资产的平方
		BigDecimal numerator = detail.getWeight1().divide(Constant.WEIGHT_MULTIPLE).subtract(detail.getWeight2().divide(Constant.WEIGHT_MULTIPLE)).multiply(asset.getAsset().pow(2));
		//分母=期初总资产*调仓瞬时净值*委托价格
		BigDecimal denominator = descom.getFirstAsset().getAsset().multiply(net).multiply(price);
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
			//未持仓，不做交易
			if(positionAccount.compareTo(BigDecimal.ZERO)!=1){
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
		return changePosition;
	}

	/**
	 * 风控检查
	 * 1.非st;2.只交易6或0或3开头的
	 * @param descom
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
		return true;
	}
	private String generateWindCode(String code) {
		return code.substring(2)+"."+code.substring(0, 2);
	}

}
