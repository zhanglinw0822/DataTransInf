package com.zhanglin.bean;

import java.math.BigDecimal;
import java.util.List;

import com.google.common.base.MoreObjects;

public class Data {
	/**
	 * 消息id
	 */
	private String msguid;
	/**
	 * 组合id
	 */
	private String id;
	/**
	 * 委托时间(精确到分钟)
	 */
	private String realtime;
	/**
	 * 委托日期
	 */
	private String ordertime;
	/**
	 * 延迟时间(单位分钟)
	 */
	private int delay;
	
	private List<Detail> details;
	/**
	 * 原始json
	 */
	private String origJson;
	/**
	 * 请求id
	 */
	private BigDecimal requestId;
	
	public BigDecimal getRequestId() {
		return requestId;
	}
	public void setRequestId(BigDecimal requestId) {
		this.requestId = requestId;
	}
	public String getOrigJson() {
		return origJson;
	}
	public void setOrigJson(String origJson) {
		this.origJson = origJson;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRealtime() {
		return realtime;
	}
	public void setRealtime(String realtime) {
		this.realtime = realtime;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public int getDelay() {
		return delay;
	}
	public void setDelay(int delay) {
		this.delay = delay;
	}
	public String getMsguid() {
		return msguid;
	}
	public void setMsguid(String msguid) {
		this.msguid = msguid;
	}
	public List<Detail> getDetails() {
		return details;
	}
	public void setDetails(List<Detail> details) {
		this.details = details;
	}
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("msguid", msguid)
				.add("id", id).add("realtime", realtime)
				.add("ordertime", ordertime).add("delay", delay)
				.add("details", details).toString();
	}
	
	
}
