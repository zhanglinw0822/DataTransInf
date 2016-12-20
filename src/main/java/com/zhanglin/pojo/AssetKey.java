package com.zhanglin.pojo;

import java.math.BigDecimal;

public class AssetKey {
    private String time;

    private BigDecimal newid;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public BigDecimal getNewid() {
        return newid;
    }

    public void setNewid(BigDecimal newid) {
        this.newid = newid;
    }
}