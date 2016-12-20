package com.zhanglin.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Asset {
    private BigDecimal id;

    private String time;

    private BigDecimal cash;

    private Date updatetime;

    private BigDecimal descomId;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public BigDecimal getDescomId() {
        return descomId;
    }

    public void setDescomId(BigDecimal descomId) {
        this.descomId = descomId;
    }
}