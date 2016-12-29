package com.zhanglin.scheduler.jobs;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.zhanglin.service.IMarketService;

public class BeginScheduledJob extends QuartzJobBean {
	private static Logger logger = Logger.getLogger(BeginScheduledJob.class); 
	@Resource
	private IMarketService service;
	public void setService(IMarketService service) {
		this.service = service;
	}
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		logger.info("准备开盘");
		try{
//			service.openMarket();
		}catch(Exception e){
			logger.error("开盘失败");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
//			service.openMarket();
		}
		logger.info("开盘成功");
	}



}
