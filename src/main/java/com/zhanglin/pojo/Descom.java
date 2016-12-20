package com.zhanglin.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Descom {
    private BigDecimal id;

    private String time;

    private BigDecimal istrue;

    private Date updatetime;

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

    public BigDecimal getIstrue() {
        return istrue;
    }

    public void setIstrue(BigDecimal istrue) {
        this.istrue = istrue;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}