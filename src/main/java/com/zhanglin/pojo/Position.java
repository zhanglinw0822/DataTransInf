package com.zhanglin.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Position {
    private BigDecimal id;

    private String time;

    private String code;

    private BigDecimal holdprice;

    private BigDecimal num;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public BigDecimal getHoldprice() {
        return holdprice;
    }

    public void setHoldprice(BigDecimal holdprice) {
        this.holdprice = holdprice;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
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