package com.zhanglin.bean;

public class Result{
	/**
	 * 消息id
	 */
	private String msguid;
	/**
	 * 消息状态,1:成功,0:失败
	 */
	private int msgstate;
	public String getMsguid() {
		return msguid;
	}
	public void setMsguid(String msguid) {
		this.msguid = msguid;
	}
	public int getMsgstate() {
		return msgstate;
	}
	public void setMsgstate(int msgstate) {
		this.msgstate = msgstate;
	}
}
