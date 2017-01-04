package com.zhanglin.bean;

import java.math.BigDecimal;

import com.google.common.base.MoreObjects;

public class Detail {
	/**
	 * 股票代码
	 */
	private String code;
	/**
	 * 委托价格
	 */
	private BigDecimal price;
	/**
	 * 调仓前权重
	 */
	private BigDecimal weight1;
	/**
	 * 调仓后权重
	 */
	private BigDecimal weight2;
	/**
	 * 交易方向,1：买，0：卖
	 */
	private int trading_type;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getWeight1() {
		return weight1;
	}
	public void setWeight1(BigDecimal weight1) {
		this.weight1 = weight1;
	}
	public BigDecimal getWeight2() {
		return weight2;
	}
	public void setWeight2(BigDecimal weight2) {
		this.weight2 = weight2;
	}
	public int getTrading_type() {
		return trading_type;
	}
	public void setTrading_type(int trading_type) {
		this.trading_type = trading_type;
	}
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("code", code)
				.add("price", price).add("weight1", weight1)
				.add("weight2", weight2).add("trading_type", trading_type).toString();
	}
	
}
