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
		logger.info("准备闭市");
		service.closeMarket();
		logger.info("闭市成功");
		
	}



}
