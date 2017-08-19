package com.zhanglin.scheduler.jobs;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.zhanglin.service.IDataTransInfService;
import com.zhanglin.tools.CustomizedPropertyConfigurer;

public class HandleInitHoldingScheduledJob extends QuartzJobBean{
	private static Logger logger = Logger.getLogger(EndScheduledJob.class); 
	IDataTransInfService transInfoService;
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		if(CustomizedPropertyConfigurer.getBooleanContextProperty("initholdingflag")){
			transInfoService.handleInitHolding();
		}
	}
	public void setTransInfoService(IDataTransInfService transInfoService) {
		this.transInfoService = transInfoService;
	}

}
