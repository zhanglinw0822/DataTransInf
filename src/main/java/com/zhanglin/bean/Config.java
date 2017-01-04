package com.zhanglin.bean;

import java.math.BigDecimal;

public class Config {
	
	/**
	 * 最大权重
	 */
	private BigDecimal maxWeight=new BigDecimal(0.3);
	/**
	 * 开始时间
	 */
	private String beginTime;
	/**
	 * 结束时间
	 */
	private String endTime;
	/**
	 * 临时文件目录
	 */
	private String tempPath;
	/**
	 * 交易指令文件目录
	 */
	private String orderFilePath;

	public String getTempPath() {
		return tempPath;
	}

	public void setTempPath(String tempPath) {
		this.tempPath = tempPath;
	}

	public String getOrderFilePath() {
		return orderFilePath;
	}

	public void setOrderFilePath(String orderFilePath) {
		this.orderFilePath = orderFilePath;
	}

	public BigDecimal getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(BigDecimal maxWeight) {
		this.maxWeight = maxWeight;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
}
