package com.zhanglin;

import java.math.BigDecimal;

public class Constant {
	/**
	 * 交易类型-买
	 */
	public static int TRADE_TYPE_BUY = 1;
	/**
	 * 交易类型-卖
	 */
	public static int TRADE_TYPE_SELL = 0;
	/**
	 * 持仓数量-倍数
	 */
	public static BigDecimal POSITION_MULTIPLE = new BigDecimal(100);
}
