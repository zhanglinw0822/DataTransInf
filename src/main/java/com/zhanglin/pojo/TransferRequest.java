package com.zhanglin.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class TransferRequest {
    private BigDecimal id;

    private String msguid;

    private String data;

    private String ordertime;

    private String realtime;

    private BigDecimal delay;

    private String status;

    private Date updatetime;

    private String descomid;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getMsguid() {
        return msguid;
    }

    public void setMsguid(String msguid) {
        this.msguid = msguid == null ? null : msguid.trim();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime == null ? null : ordertime.trim();
    }

    public String getRealtime() {
        return realtime;
    }

    public void setRealtime(String realtime) {
        this.realtime = realtime == null ? null : realtime.trim();
    }

    public BigDecimal getDelay() {
        return delay;
    }

    public void setDelay(BigDecimal delay) {
        this.delay = delay;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getDescomid() {
        return descomid;
    }

    public void setDescomid(String descomid) {
        this.descomid = descomid == null ? null : descomid.trim();
    }
}