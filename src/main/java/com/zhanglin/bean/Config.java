package com.zhanglin.bean;

import java.math.BigDecimal;

public class Config {
	
	/**
	 * 最大权重
	 */
	private BigDecimal maxWeight=new BigDecimal(0.3);

	public BigDecimal getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(BigDecimal maxWeight) {
		this.maxWeight = maxWeight;
	}
	
}
