package com.zhanglin.pojo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.zhanglin.Constant;
import com.zhanglin.bean.Data;
import com.zhanglin.bean.Detail;

public class Order {
    private String msguid;

    private String id;

    private String code;

    private BigDecimal orderPrice;

    private BigDecimal tradetype;

    private String orderTime;

    private BigDecimal delay;

    private String recvtime;

    private BigDecimal newid;

    private Date updatetime;

    private BigDecimal net;

    private BigDecimal w1;

    private BigDecimal w2;
    
    public Order(Detail detail, Data data) {
    	this.msguid = data.getMsguid();
    	this.id = data.getId();
		this.code = detail.getCode();
		this.orderPrice = detail.getPrice();
		this.tradetype = new BigDecimal(detail.getTrading_type());
		this.orderTime = data.getRealtime();
		this.delay = new BigDecimal(data.getDelay());
		this.recvtime = data.getOrdertime();
		this.updatetime = new Date();
		this.net = data.getNetvalue();
		this.w1 = detail.getWeight1();
		this.w2 = detail.getWeight2();
	}

    public String getMsguid() {
        return msguid;
    }

    public void setMsguid(String msguid) {
        this.msguid = msguid;
    }

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
        this.code = code == null ? null : code.trim();
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public BigDecimal getTradetype() {
        return tradetype;
    }

    public void setTradetype(BigDecimal tradetype) {
        this.tradetype = tradetype;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime == null ? null : orderTime.trim();
    }

    public BigDecimal getDelay() {
        return delay;
    }

    public void setDelay(BigDecimal delay) {
        this.delay = delay;
    }

    public String getRecvtime() {
        return recvtime;
    }

    public void setRecvtime(String recvtime) {
        this.recvtime = recvtime == null ? null : recvtime.trim();
    }

    public BigDecimal getNewid() {
        return newid;
    }

    public void setNewid(BigDecimal newid) {
        this.newid = newid;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public BigDecimal getNet() {
        return net;
    }

    public void setNet(BigDecimal net) {
        this.net = net;
    }

    public BigDecimal getW1() {
        return w1;
    }

    public void setW1(BigDecimal w1) {
        this.w1 = w1;
    }

    public BigDecimal getW2() {
        return w2;
    }

    public void setW2(BigDecimal w2) {
        this.w2 = w2;
    }
}