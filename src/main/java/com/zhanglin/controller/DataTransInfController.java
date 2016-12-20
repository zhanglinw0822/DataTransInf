package com.zhanglin.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhanglin.interceptor.MyRequestWrapper;
import com.zhanglin.pojo.Data;
import com.zhanglin.service.IDataTransInfService;

@Controller
@RequestMapping("/DataTransInf")
public class DataTransInfController {
	@Resource
	private IDataTransInfService service;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public JSONObject dataTransInfo(HttpServletRequest request){
		try{
			MyRequestWrapper myRequestWrapper = new MyRequestWrapper((HttpServletRequest) request);
	        List<Data> datas = JSONArray.parseArray(myRequestWrapper.getBody(),Data.class);
	        
	        service.dataTransInfo(datas);
		}catch(Exception e){
			e.printStackTrace();
		}
		return JSONObject.parseObject("");
	}
}
