package com.zhanglin.bean;

import java.math.BigDecimal;

public class Data {
	
	/**
	 * 组合id
	 */
	private String id;
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
	private int tradetype;
	/**
	 * 委托时间(精确到分钟)
	 */
	private String time;
	/**
	 * 委托日期
	 */
	private String date;
	/**
	 * 延迟时间(单位分钟)
	 */
	private String delay;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public int getTradetype() {
		return tradetype;
	}
	public void setTradetype(int tradetype) {
		this.tradetype = tradetype;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDelay() {
		return delay;
	}
	public void setDelay(String delay) {
		this.delay = delay;
	}
	
	@Override
	public String toString() {
		return "Data [id=" + id + ", code=" + code + ", price=" + price
				+ ", weight1=" + weight1 + ", weight2=" + weight2
				+ ", tradetype=" + tradetype + ", time=" + time + ", date="
				+ date + ", delay=" + delay + "]";
	}
	
}
