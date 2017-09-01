package com.zhanglin.pojo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.zhanglin.Constant;
import com.zhanglin.bean.Data;
import com.zhanglin.bean.Detail;

public class Record {
    private Object msguid;

    private Object id;

    private BigDecimal newid;

    private String ordertime;

    private String code;

    private int tradetype;

    private String realtime;

    private BigDecimal num;
    
    private BigDecimal price;

    public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Record(Detail detail, Data data) {
    	this.msguid = data.getMsguid();
    	this.id = data.getId();
    	this.ordertime = data.getOrdertime();
    	this.code = detail.getCode();
    	this.tradetype = detail.getTrading_type();
    	this.realtime = new SimpleDateFormat("HHmmss").format(new Date());
	}
    
    public Object getMsguid() {
        return msguid;
    }

    public void setMsguid(Object msguid) {
        this.msguid = msguid;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public BigDecimal getNewid() {
        return newid;
    }

    public void setNewid(BigDecimal newid) {
        this.newid = newid;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime == null ? null : ordertime.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public int getTradetype() {
        return tradetype;
    }

    public void setTradetype(int tradetype) {
        this.tradetype = tradetype;
    }

    public String getRealtime() {
        return realtime;
    }

    public void setRealtime(String realtime) {
        this.realtime = realtime == null ? null : realtime.trim();
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }
}