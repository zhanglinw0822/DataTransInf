package com.zhanglin.service;

import java.util.List;
import java.util.Map;

import com.zhanglin.pojo.InitHolding;




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
	/**
	 * 获取ST股票
	 * @return 
	 */
	public Map<String, String> getSTCodes();
	/**
	 * 获取初始持仓
	 * @return 
	 */
	public Map<String, InitHolding> getInitHoldings();
	
	/**
	 * 获取初始持仓列表
	 * @return 
	 */
	public List<InitHolding> getInitHoldingList();
}
