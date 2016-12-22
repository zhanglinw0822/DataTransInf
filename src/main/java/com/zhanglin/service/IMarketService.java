package com.zhanglin.service;




public interface IMarketService {
	/**
	 * 开市操作，初始化运行时资金表和运行时持仓表
	 */
	public void openMarket();
	/**
	 * 闭市操作，更新资金表和持仓表
	 */
	public void closeMarket();
	/**
	 * 获取市场状态
	 */
	public String getSystemStaus();
}
