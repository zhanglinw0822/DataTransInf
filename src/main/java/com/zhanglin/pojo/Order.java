package com.zhanglin.pojo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.zhanglin.bean.Data;

public class Order {
    private String id;

    private String time;

    private String code;

    private BigDecimal orderPrice;

    private BigDecimal orderNum;

    private BigDecimal tradetype;

    private String orderTime;

    private BigDecimal delay;

    private String recvtime;

    private BigDecimal newid;

    private Date updatetime;

    public Order(Data data) {
		this.code = data.getCode();
		this.delay = new BigDecimal(data.getDelay());
		this.id = "id";
		this.orderPrice = data.getPrice();
		//this.orderTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		this.orderTime = data.getTime();
		this.recvtime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		this.time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		this.tradetype = new BigDecimal(data.getTradetype());
		this.updatetime = new Date();
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
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

    public BigDecimal getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(BigDecimal orderNum) {
        this.orderNum = orderNum;
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
}