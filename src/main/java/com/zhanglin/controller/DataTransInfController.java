package com.zhanglin.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhanglin.bean.Data;
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
	public JSONObject dataTransInfo(HttpServletRequest request){
		try{
			MyRequestWrapper myRequestWrapper = new MyRequestWrapper((HttpServletRequest) request);
			logger.info("接收到请求，request="+request+",data=:"+myRequestWrapper.getBody());
	        List<Data> datas = JSONArray.parseArray(myRequestWrapper.getBody(),Data.class);
	        service.dataTransInfo(datas);
	        logger.info("数据处理完毕,request="+request);
		}catch(Exception e){
			e.printStackTrace();
		}
		return JSONObject.parseObject("");
	}
}
