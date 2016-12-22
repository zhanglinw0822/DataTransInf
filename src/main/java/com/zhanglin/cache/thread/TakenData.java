package com.zhanglin.cache.thread;

import org.apache.log4j.Logger;

import com.zhanglin.bean.Data;
import com.zhanglin.cache.DataManager;
import com.zhanglin.service.IDataTransInfService;
import com.zhanglin.tools.SpringContextUtil;


public class TakenData extends Thread{
	private static Logger logger = Logger.getLogger(TakenData.class);  
	
	private boolean flag = true;
	
	IDataTransInfService service = SpringContextUtil.getBean("dataTransInfService");
	
	public void run() {
		DataManager mgr = DataManager.getInstance();
		while (flag) {
			try {
				Data data = mgr.takeData();
				service.dataTransInfo(data);
			} catch (Exception e) {
				logger.error("datatransinfo error!",e);
				sleepSomeTime();
			}
		}
	}
	
	private void sleepSomeTime()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			logger.error("TakenData sleep error.", e);
		}
	}
	
	public void shutdown(){
		this.flag = false;
	}
}
