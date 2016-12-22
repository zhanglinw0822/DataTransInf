package com.zhanglin.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhanglin.Constant;
import com.zhanglin.bean.Config;
import com.zhanglin.bean.Data;
import com.zhanglin.bean.Detail;
import com.zhanglin.cache.CacheManager;
import com.zhanglin.cache.DataManager;
import com.zhanglin.pojo.AssetRT;
import com.zhanglin.pojo.Descom;
import com.zhanglin.pojo.Order;
import com.zhanglin.pojo.PositionRT;
import com.zhanglin.service.IDataTransInfService;
import com.zhanglin.service.IDescomService;
import com.zhanglin.service.IRequestService;

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
	
	public void dataTransInfo(Data data) throws Exception{
		long now = System.currentTimeMillis();
		logger.info("开始处理数据,requestid:"+data.getRequestId().intValue()+",data:"+data);
		if(reqService.getRequest(data)==null){
			Descom descom = CacheManager.getInstance().getDescom(data.getId());
			if(descom!=null&&descom.getIstrue().compareTo(BigDecimal.ONE)==0){
				for (Iterator<Detail> iterator = data.getDetails().iterator(); iterator.hasNext();) {
					Detail detail = iterator.next();
					if(checkRisk(detail)){
						BigDecimal changePosition = generatePosition(descom,detail);
						if(changePosition.compareTo(BigDecimal.ZERO)==1){
							generateOrder(descom,detail,changePosition,data);
						}else{
							logger.info("需交易数量为0，不做处理,detail:"+detail);
						}
					}
				}
			}
			reqService.updateRequest(data,Constant.REQUEST_STATUS_SUCESS);
		}else{
			reqService.updateRequest(data,Constant.REQUEST_STATUS_IGNOER);
			logger.info("重复请求,requestid:"+data.getRequestId().intValue()+",data:"+data);
		}
		logger.info("数据处理完成,耗时:"+(System.currentTimeMillis()-now)+",requestid:"+data.getRequestId().intValue()+",data:"+data);
	}

	/**
	 * 生成交易指令
	 * @param newId 
	 * @param detail
	 * @param num
	 * @throws Exception 
	 */
	private void generateOrder(Descom descom, Detail detail, BigDecimal changePosition,Data data) throws Exception {
		//TODO 事务是否有问题有待确认
		try{
			//插入交易信息
			Order order =new Order(detail,data);
			order.setOrderNum(changePosition);
			order.setNewid(descom.getNewid());
			service.insertOrder(order);
			//更新持仓信息
			PositionRT position = new PositionRT();
			position.setCode(detail.getCode());
			position.setHoldprice(detail.getPrice());
			position.setNewid(descom.getNewid());
			//买入持仓为正，卖出持仓为负
			position.setNum(detail.getTradetype()==Constant.TRADE_TYPE_BUY?changePosition:BigDecimal.ZERO.subtract(changePosition));
			position.setUpdatetime(new Date());
			service.updatePositionRT(position);
			//更新内存中的持仓数据
			descom.addPosition(position);
			//更新资金信息
			AssetRT asset = descom.getAsset();
			//最新资金=最新资金-(交易价格*交易数量)
			asset.setCash(asset.getCash().subtract(detail.getPrice().multiply(position.getNum())));
			service.updateAssetRT(asset);
			
		}catch(Exception e){
			logger.error("生成交易指令异常，事务回滚。");
			cacheRollBack(descom);
			throw e;
		}
		
	}
	
	private void cacheRollBack(Descom descom) {
		//TODO 可能需要改为直接操作内存数据,目前直接设置为过期
		CacheManager.getInstance().invalidate(descom.getId());
	}

	/**
	 * 匹配组合持仓 
	 * @param descom
	 * @param detail
	 */
	private BigDecimal generatePosition(Descom descom, Detail detail) {
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
		
		//买入指令
		if(detail.getTradetype()==Constant.TRADE_TYPE_BUY){
			//指令买入数量=weight2*t_asset表里的asset值/price向下取整，100整数倍
			BigDecimal orderPositionAcount = asset.getAsset().multiply(detail.getWeight2()).divide(detail.getPrice().multiply(Constant.POSITION_MULTIPLE),0,BigDecimal.ROUND_DOWN).multiply(Constant.POSITION_MULTIPLE);
			//理论买入数量
			BigDecimal account1 =  orderPositionAcount.subtract(positionAccount);
			//可买数量=(cash+addcash)/price; 向下取整, 100整数倍
			BigDecimal account2 =  asset.getCash().divide(detail.getPrice().multiply(Constant.POSITION_MULTIPLE),0,BigDecimal.ROUND_DOWN).multiply(Constant.POSITION_MULTIPLE);
			
			if(account1.compareTo(BigDecimal.ZERO)==-1){
				changePosition = BigDecimal.ZERO;
			}else{
				changePosition = account1.compareTo(account2)==-1?account1:account2;
			}
		}
		
		//卖出指令
		if(detail.getTradetype()==Constant.TRADE_TYPE_SELL){
			//指令卖出数量=weight2*t_asset表里的asset值/price向下取整，100整数倍
			BigDecimal orderPositionAcount = asset.getAsset().multiply(detail.getWeight2()).divide(detail.getPrice().multiply(Constant.POSITION_MULTIPLE),0,BigDecimal.ROUND_DOWN).multiply(Constant.POSITION_MULTIPLE);
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
	private boolean checkRisk(Detail detail) {
		
		if(detail.getWeight2().compareTo(config.getMaxWeight())>0){
			detail.setWeight2(config.getMaxWeight());
			logger.info("请求数据:"+detail+",权重大于"+config.getMaxWeight().multiply(new BigDecimal(100))+",设置为最大权重");
		}
		
		//TODO 判断是否为ST股票
		if(detail.getCode()==null){
			return false;
		}
		return true;
	}

}
