package com.zhanglin.bean;

import java.util.UUID;

public class FileName {
	private String newid;
	private String realtime;
	private String ordertime;
	private long now = System.currentTimeMillis();
	private UUID uuid = UUID.randomUUID();
	public String getNewid() {
		return newid;
	}
	public void setNewid(String newid) {
		this.newid = newid;
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
	@Override
	public String toString() {
		return newid + "_" + ordertime+ "_" + realtime+"_"+ uuid + ".txt";
	}
	
}
