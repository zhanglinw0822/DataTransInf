package com.zhanglin.scheduler.jobs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.zhanglin.cache.CacheManager;
import org.apache.log4j.Logger;
import org.quartz.CronExpression;

import com.zhanglin.Constant;
import com.zhanglin.service.IDataTransInfService;
import com.zhanglin.service.IMarketService;
import com.zhanglin.tools.CustomizedPropertyConfigurer;
import com.zhanglin.tools.SpringContextUtil;

public class InitJob {
	private static Logger logger = Logger.getLogger(InitJob.class); 
	
	public void init(){
		logger.info("initjob init!");
		try {
			String tempPath = CustomizedPropertyConfigurer.getStringContextProperty("tempPath");
			String orderFilePath = CustomizedPropertyConfigurer.getStringContextProperty("orderFilePath");
			String begintime = CustomizedPropertyConfigurer.getStringContextProperty("begintime");
			String endtime = CustomizedPropertyConfigurer.getStringContextProperty("endtime");
			boolean initholdingflag =  CustomizedPropertyConfigurer.getBooleanContextProperty("initholdingflag");
			String handleinitholdingtime = CustomizedPropertyConfigurer.getStringContextProperty("handleinitholdingtime");
			logger.info("系统配置【tempPath】值为【"+tempPath+"】");
			logger.info("系统配置【orderFilePath】值为【"+orderFilePath+"】");
			logger.info("系统配置【begintime】值为【"+begintime+"】");
			logger.info("系统配置【endtime】值为【"+endtime+"】");
			logger.info("系统配置【initholdingflag】值为【"+initholdingflag+"】");
			logger.info("系统配置【handleinitholdingtime】值为【"+handleinitholdingtime+"】");
			
			Calendar ca = Calendar.getInstance();
			CronExpression begin = new CronExpression(begintime);
			CronExpression end = new CronExpression(endtime);
			CronExpression handleinitholding = new CronExpression(handleinitholdingtime);
			Calendar nextOpenTime = Calendar.getInstance();
			nextOpenTime.setTime(begin.getNextValidTimeAfter(ca.getTime()));
			Calendar nextCloseTime = Calendar.getInstance();
			nextCloseTime.setTime(end.getNextValidTimeAfter(ca.getTime()));
			Calendar nextInitHoldingTime = Calendar.getInstance();
			nextInitHoldingTime.setTime(handleinitholding.getNextValidTimeAfter(ca.getTime()));
			logger.info("系统计算出的下次开盘时间为【"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(nextOpenTime.getTime())+"】");
			logger.info("系统计算出的下次收盘时间为【"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(nextCloseTime.getTime())+"】");
			logger.info("系统计算出的下次初始化持仓时间为【"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(nextInitHoldingTime.getTime())+"】");
			
			IMarketService service = (IMarketService)SpringContextUtil.getBean("marketService");
			IDataTransInfService dataTransInfService = (IDataTransInfService)SpringContextUtil.getBean("dataTransInfService");
			String status = service.getSystemStaus();
			CacheManager.getInstance().getAllClose();
			// 当天开盘前
			if (nextOpenTime.get(Calendar.DAY_OF_MONTH) == ca
					.get(Calendar.DAY_OF_MONTH)) {
				logger.info("status is ok,do nothing.");
			} else if (nextOpenTime.get(Calendar.DAY_OF_MONTH) != ca
					.get(Calendar.DAY_OF_MONTH)
					&& nextCloseTime.get(Calendar.DAY_OF_MONTH) == ca
							.get(Calendar.DAY_OF_MONTH)) {//盘中
				if(Constant.SYSTEM_STATUS_CLOSE.equals(status)){
					logger.info("status is close,do open.");
					service.openMarket();
					logger.info("system opend.");
				}else{
					service.loadCache();
					//判断是否需要进行初始化持仓操作
					if(initholdingflag){
						if(nextInitHoldingTime.get(Calendar.DAY_OF_MONTH) != ca
								.get(Calendar.DAY_OF_MONTH)){
							dataTransInfService.handleInitHolding();
						}
					}
					logger.info("status is ok");
				}
			}else if (nextCloseTime.get(Calendar.DAY_OF_MONTH) != ca
							.get(Calendar.DAY_OF_MONTH)) {//收盘后
				if(Constant.SYSTEM_STATUS_OPEN.equals(status)){
					logger.info("status is open,do close.");
					service.closeMarket();
					logger.info("system closed.");
				}else{
					logger.info("status is ok,do nothing.");
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 
	}
}
