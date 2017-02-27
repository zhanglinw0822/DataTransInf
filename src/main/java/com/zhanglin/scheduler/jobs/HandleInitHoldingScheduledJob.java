package com.zhanglin.scheduler.jobs;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.zhanglin.Constant;
import com.zhanglin.bean.Data;
import com.zhanglin.bean.Detail;
import com.zhanglin.pojo.InitHolding;
import com.zhanglin.service.IDataTransInfService;
import com.zhanglin.service.IMarketService;

public class HandleInitHoldingScheduledJob extends QuartzJobBean{
	private static Logger logger = Logger.getLogger(EndScheduledJob.class); 
	IMarketService service;
	IDataTransInfService transInfoService;
	public void setService(IMarketService service) {
		this.service = service;
	}
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		logger.info("准备处理初始化持仓数据");
		try{
			List<InitHolding> initHoldings = service.getInitHoldingList();
			for (Iterator<InitHolding> iterator = initHoldings.iterator(); iterator.hasNext();) {
				InitHolding initHolding = iterator.next();
				Data data  = new Data();
				
				Detail detail = new Detail();
				detail.setCode(initHolding.getCode());
				detail.setPrice(initHolding.getCloseprice());
				detail.setTrading_type(Constant.TRADE_TYPE_BUY);
				detail.setWeight1(BigDecimal.ZERO);
				detail.setWeight2(initHolding.getWeight());
				
				List<Detail> details = new ArrayList<Detail>();
				details.add(detail);
				data.setDetails(details);
				data.setDelay(0);
				data.setMsguid("initholding_"+initHolding.getNewid());
				data.setOrigJson("{}");
				data.setRequestId(BigDecimal.ZERO);
				data.setId(initHolding.getId());
				data.setNetvalue(initHolding.getNet());
				data.setOrdertime(new SimpleDateFormat("yyyyMMdd").format(new Date()));
				data.setRealtime(new SimpleDateFormat("HHmm").format(new Date()));
				logger.info("开始处理初始化持仓数据："+data);
				transInfoService.handleData(data, false);
			}
		}catch(Exception e){
			logger.error("处理初始化持仓数据",e);
		}
		logger.info("处理初始化持仓数据");
		
	}
	public void setTransInfoService(IDataTransInfService transInfoService) {
		this.transInfoService = transInfoService;
	}

}
