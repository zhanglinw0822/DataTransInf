package com.zhanglin.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

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
import com.zhanglin.bean.Detail;
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
	public String dataTransInfo(HttpServletRequest request){
		long now = System.currentTimeMillis();
		Result result = new Result();
		try{
			MyRequestWrapper myRequestWrapper = new MyRequestWrapper((HttpServletRequest) request);
			logger.info("接收到请求，request:"+request+",data:"+myRequestWrapper.getBody());
			String json = URLDecoder.decode(myRequestWrapper.getBody(), Constant.DEFAULT_ENCODING);
			//替换\r \n 特殊字符，及数据标识符
			json = json.replaceFirst(Constant.DEFAULT_DATA_FLAG, "").replaceAll("\r", "").replaceAll("\n", "");
	        Data data = JSON.parseObject(json,Data.class);
	        data.setOrigJson(myRequestWrapper.getBody());
			result.setMsguid(data.getMsguid());
			try{
				if(validate(data)){
					if(Constant.SYSTEM_STATUS_OPEN.equals(CacheManager.getInstance().getSystemStatus())){
						service.reciveData(data);
						result.setMsgstate(Constant.RESULT_CODE_OK);
					}else{
						logger.error("系统状态为收盘状态，暂不接收请求。");
						result.setMsgstate(Constant.RESULT_CODE_ERR);
					}
				}else{
					result.setMsgstate(Constant.RESULT_CODE_ERR);
				}
				
			}catch(Exception e){
				logger.error("error",e);
				result.setMsgstate(Constant.RESULT_CODE_ERR);
			}
		}catch(Exception e){
			logger.error("error",e);
		}
		logger.info("处理请求完成,耗时："+(System.currentTimeMillis()-now)+",request:"+request);
		String str_result="{}";
		try {
			str_result = URLEncoder.encode(JSON.toJSONString(result), Constant.DEFAULT_ENCODING);
		} catch (UnsupportedEncodingException e) {
			logger.error("error",e);
		}
		 return str_result;
	}

	private boolean validate(Data data) {
		// 所有参数不能为空
		if (isEmpty(data.getDetails()) || isEmpty(data.getDelay())
				|| isEmpty(data.getId()) || isEmpty(data.getMsguid())
				|| isEmpty(data.getNetvalue()) || isEmpty(data.getOrdertime())
				|| isEmpty(data.getRealtime()) || isEmpty(data.getDetails())
				|| data.getDetails().size() == 0) {
			logger.info("请求格式验证未通过,参数为空,data="+data);
			return false;
		}
		// 如果是买入（tradetype=1）时，weight2> weight1; 如果是卖出(tradetype=0),
		// weight2<weight1;
		// trade type值为1或0
		// code格式校验: 2位市场代码+6位股票代码, SH600987，2位市场代码可以去不区分大小写,主要校验股票代码长度6位。
		for (Iterator<Detail> iterator = data.getDetails().iterator(); iterator
				.hasNext();) {
			Detail detail = iterator.next();
			if (isEmpty(detail.getCode()) || isEmpty(detail.getPrice())
					|| isEmpty(detail.getTrading_type())
					|| isEmpty(detail.getWeight1())
					|| isEmpty(detail.getWeight2())) {
				logger.info("请求格式验证未通过,参数为空,detail="+detail);
				return false;
			}
			if (detail.getTrading_type() == Constant.TRADE_TYPE_BUY) {
				if (detail.getWeight2().compareTo(detail.getWeight1()) <= 0) {
					logger.info("请求格式验证未通过,买入时weight2<=weight1,detail="+detail);
					return false;
				}
			} else if (detail.getTrading_type() == Constant.TRADE_TYPE_SELL) {
				if (detail.getWeight2().compareTo(detail.getWeight1()) == 1) {
					logger.info("请求格式验证未通过,卖出时weight2>weight1,detail="+detail);
					return false;
				}
			} else {
				logger.info("请求格式验证未通过,trade type值不为1和0,detail="+detail);
				return false;
			}
			if (detail.getCode().length() != 8
					|| (!detail.getCode().toLowerCase().startsWith("sh") && !detail
							.getCode().toLowerCase().startsWith("sz"))) {
				logger.info("请求格式验证未通过,股票代码格式错误,detail="+detail);
				return false;
			}
		}
		// ordertime等于当前日期
		String str_now = new SimpleDateFormat(Constant.DEFAULT_DATE_FORMAT)
				.format(new Date());
		if (!str_now.equals(data.getOrdertime())) {
			logger.info("请求格式验证未通过,ordertime不等于当前日期,data="+data);
			return false;
		}
		// realtime小于15点。 real-time<1500
		if (data.getRealtime().compareTo("1500") >= 0) {
			logger.info("请求格式验证未通过,realtime大于等于15点,data="+data);
			return false;
		}
		return true;
	}
	
	private boolean isEmpty(Object object){
		if(null == object || "".equals(object.toString())){
			return true;
		}
		return false;
	}
}
