package com.zhanglin.scheduler.jobs;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.zhanglin.service.IMarketService;
import com.zhanglin.tools.SpringContextUtil;

public class EndScheduledJob extends QuartzJobBean {
	private static Logger logger = Logger.getLogger(EndScheduledJob.class); 
	IMarketService service;
	public void setService(IMarketService service) {
		this.service = service;
	}
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		logger.info("准备收盘");
		try{
			service.closeMarket();
		}catch(Exception e){
			logger.error("收盘失败");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			service.closeMarket();
		}
		logger.info("收盘成功");
		
	}



}
