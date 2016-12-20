package com.zhanglin.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Asset extends AssetKey {
    private BigDecimal cash;

    private BigDecimal addcash;

    private BigDecimal asset;

    private Date updatetime;

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public BigDecimal getAddcash() {
        return addcash;
    }

    public void setAddcash(BigDecimal addcash) {
        this.addcash = addcash;
    }

    public BigDecimal getAsset() {
        return asset;
    }

    public void setAsset(BigDecimal asset) {
        this.asset = asset;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}