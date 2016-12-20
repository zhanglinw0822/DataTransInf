package com.zhanglin.pojo;

import java.math.BigDecimal;

public class PositionKey {
    private BigDecimal newid;

    private String time;

    private String code;

    public BigDecimal getNewid() {
        return newid;
    }

    public void setNewid(BigDecimal newid) {
        this.newid = newid;
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
}