package com.zhanglin.scheduler.jobs;

import java.text.ParseException;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.quartz.CronExpression;

import com.zhanglin.Constant;
import com.zhanglin.service.IMarketService;
import com.zhanglin.tools.SpringContextUtil;

public class InitJob {
	private static Logger logger = Logger.getLogger(InitJob.class); 
	private String begintime;
	private String endtime;
	
	public String getBegintime() {
		return begintime;
	}
	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	
	public void init(){
		logger.info("initjob init!");
		try {
			Calendar ca = Calendar.getInstance();
			CronExpression begin = new CronExpression(begintime);
			CronExpression end = new CronExpression(endtime);
			Calendar nextOpenTime = Calendar.getInstance();
			nextOpenTime.setTime(begin.getNextValidTimeAfter(ca.getTime()));
			Calendar nextCloseTime = Calendar.getInstance();
			nextCloseTime.setTime(end.getNextValidTimeAfter(ca.getTime()));
			
			IMarketService service = (IMarketService)SpringContextUtil.getBean("marketService");
			String status = service.getSystemStaus();
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
					logger.info("status is ok,do nothing.");
				}
			}else if (nextCloseTime.get(Calendar.DAY_OF_MONTH) == ca
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
}
