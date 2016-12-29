package com.zhanglin;

import java.math.BigDecimal;

public class Constant {
	/**
	 * 默认日期格式
	 */
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
	/**
	 * 默认编码格式
	 */
	public static final String DEFAULT_ENCODING = "UTF-8";
	/**
	 * 默认数据标志
	 */
	public static final String DEFAULT_DATA_FLAG = "data=";
	/**
	 * 交易类型-买
	 */
	public static final int TRADE_TYPE_BUY = 1;
	/**
	 * 交易类型-卖
	 */
	public static final int TRADE_TYPE_SELL = 0;
	/**
	 * 持仓数量-倍数
	 */
	public static final BigDecimal POSITION_MULTIPLE = new BigDecimal(100);
	/**
	 * 金额单位-万元
	 */
	public static final BigDecimal ASSET_UNIT = new BigDecimal(10000);
	/**
	 * 处理结果-成功
	 */
	public static final int RESULT_CODE_OK = 1;
	/**
	 * 处理结果-失败
	 */
	public static final int RESULT_CODE_ERR = 0;
	
	/**
	 * 请求状态-待处理
	 */
	public static final String REQUEST_STATUS_PENDING = "P";
	/**
	 * 请求状态-处理成功
	 */
	public static final String REQUEST_STATUS_SUCESS = "S";
	/**
	 * 请求状态-处理失败
	 */
	public static final String REQUEST_STATUS_ERROR = "F";
	/**
	 * 请求状态-忽略该请求
	 */
	public static final String REQUEST_STATUS_IGNOER = "I";
	
	/**
	 * 市场状态-开盘
	 */
	public static final String SYSTEM_STATUS_OPEN = "OPEN";
	/**
	 * 市场状态-收盘
	 */
	public static final String SYSTEM_STATUS_CLOSE = "CLOSE";
}
