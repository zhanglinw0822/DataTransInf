package com.zhanglin.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zhanglin.Constant;
import com.zhanglin.bean.Data;
import com.zhanglin.bean.Result;
import com.zhanglin.cache.CacheManager;
import com.zhanglin.interceptor.MyRequestWrapper;
import com.zhanglin.service.IDataTransInfService;

@Controller
@RequestMapping("/DataTransInf")
public class DataTransInfController {
	private static Logger logger = Logger.getLogger(DataTransInfController.class);  
	
	@Resource
	private IDataTransInfService service;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Result dataTransInfo(HttpServletRequest request){
		long now = System.currentTimeMillis();
		Result result = new Result();
		try{
			MyRequestWrapper myRequestWrapper = new MyRequestWrapper((HttpServletRequest) request);
			logger.info("接收到请求，request:"+request+",data:"+myRequestWrapper.getBody());
	        Data data = JSON.parseObject(myRequestWrapper.getBody(),Data.class);
	        data.setOrigJson(myRequestWrapper.getBody());
			result.setMsguid(data.getMsguid());
			try{
				if(Constant.SYSTEM_STATUS_OPEN.equals(CacheManager.getInstance().getSystemStatus())){
					service.reciveData(data);
					result.setMsgstate(Constant.RESULT_CODE_OK);
				}else{
					logger.error("系统状态为收盘状态，暂不接收请求。");
					result.setMsgstate(Constant.RESULT_CODE_ERR);
				}
				
			}catch(Exception e){
				logger.error(e);
				result.setMsgstate(Constant.RESULT_CODE_ERR);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		logger.info("处理请求完成,耗时："+(System.currentTimeMillis()-now)+",request:"+request);
		return result;
	}
}
