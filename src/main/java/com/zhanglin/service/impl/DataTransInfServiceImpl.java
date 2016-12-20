package com.zhanglin.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.zhanglin.Constant;
import com.zhanglin.bean.Config;
import com.zhanglin.bean.Data;
import com.zhanglin.cache.CacheManager;
import com.zhanglin.pojo.Asset;
import com.zhanglin.pojo.Descom;
import com.zhanglin.pojo.Order;
import com.zhanglin.pojo.Position;
import com.zhanglin.service.IDataTransInfService;
import com.zhanglin.service.IDescomService;

@Service("dataTransInfService")
public class DataTransInfServiceImpl implements IDataTransInfService {
	private static Logger logger = Logger.getLogger(DataTransInfServiceImpl.class); 
	@Resource
	private Config config;
	@Resource
	IDescomService service;
	
	public void dataTransInfo(List<Data> datas) {
		for (Iterator<Data> iterator = datas.iterator(); iterator.hasNext();) {
			Data data = iterator.next();
			Descom descom = CacheManager.getInstance().getDescom(data.getId());
			if(descom!=null){
				if(checkRisk(data)){
					BigDecimal changePosition = generatePosition(descom,data);
					
					generateOrder(descom.getNewid(),data,changePosition);
				}
			}
			
			logger.info("处理完毕数据："+data);
		}

	}

	/**
	 * 生成交易指令
	 * @param newId 
	 * @param data
	 * @param num
	 */
	private void generateOrder(BigDecimal newId, Data data, BigDecimal changePosition) {
		//TODO 事务是否有问题有待确认
		//插入交易信息
		Order order =new Order(data);
		order.setOrderNum(changePosition);
		order.setNewid(newId);
		service.insertOrder(order);
		//更新持仓信息
		Position position = new Position();
		position.setCode(data.getCode());
		position.setHoldprice(data.getPrice());
		position.setNewid(newId);
		position.setNum(changePosition);
		position.setTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		position.setUpdatetime(new Date());
		service.updatePosition(position);
		//更新资金信息
		service.updateAsset(newId,changePosition.multiply(data.getPrice()));
		
	}

	/**
	 * 匹配组合持仓 
	 * @param descom
	 * @param data
	 */
	private BigDecimal generatePosition(Descom descom, Data data) {
		BigDecimal changePosition = BigDecimal.ZERO;
		//持仓数量
		BigDecimal positionAccount = descom.getCodeAccount(data.getCode());
		if(null==positionAccount){
			positionAccount = BigDecimal.ZERO;
		}
		
		List<Asset> assets = descom.getAsset();
		Asset asset = new Asset();
		//没有资金，按照资金为0计算
		if(assets.size()>0){
			asset = assets.get(assets.size()-1);
		}else{
			asset.setAddcash(BigDecimal.ZERO);
			asset.setAddcash(BigDecimal.ZERO);
			asset.setAsset(BigDecimal.ZERO);
		}
		
		//买入指令
		if(data.getTradetype()==Constant.TRADE_TYPE_BUY){
			//指令买入数量=weight2*t_asset表里的asset值/price向下取整，100整数倍
			BigDecimal orderPositionAcount = asset.getAsset().multiply(data.getWeight2()).divide(data.getPrice()).divide(Constant.POSITION_MULTIPLE,BigDecimal.ROUND_DOWN).multiply(Constant.POSITION_MULTIPLE);
			//理论买入数量
			BigDecimal account1 =  orderPositionAcount.subtract(positionAccount);
			//可买数量=(cash+addcash)/price; 向下取整, 100整数倍
			BigDecimal account2 =  asset.getCash().add(asset.getAddcash()).divide(data.getPrice()).divide(Constant.POSITION_MULTIPLE,BigDecimal.ROUND_DOWN).multiply(Constant.POSITION_MULTIPLE);;
			
			if(account1.compareTo(BigDecimal.ZERO)==-1){
				changePosition = BigDecimal.ZERO;
			}else{
				changePosition = account1.compareTo(account2)==-1?account1:account2;
			}
		}
		
		//卖出指令
		if(data.getTradetype()==Constant.TRADE_TYPE_SELL){
			//指令卖出数量=weight2*t_asset表里的asset值/price向下取整，100整数倍
			BigDecimal orderPositionAcount = asset.getAsset().multiply(data.getWeight2()).divide(data.getPrice()).divide(Constant.POSITION_MULTIPLE,BigDecimal.ROUND_DOWN).multiply(Constant.POSITION_MULTIPLE);
			//理论卖出数量
			BigDecimal account1 =  positionAccount.subtract(orderPositionAcount);
			
			if(account1.compareTo(BigDecimal.ZERO)==-1){
				changePosition = BigDecimal.ZERO;
			}else{
				changePosition = account1;
			}
		}
		return changePosition;
	}

	/**
	 * 风控检查
	 * 1.单只个股权调仓后最大权重不超过30%,超过就按30%算;2.非st.
	 * @param descom
	 */
	private boolean checkRisk(Data data) {
		
		if(data.getWeight2().compareTo(config.getMaxWeight())>0){
			data.setWeight2(config.getMaxWeight());
			logger.info("请求数据:"+data+",权重大于"+config.getMaxWeight().multiply(new BigDecimal(100))+",设置为最大权重");
		}
		
		//TODO 判断是否为ST股票
		if(data.getCode()==null){
			return false;
		}
		return true;
	}

}
