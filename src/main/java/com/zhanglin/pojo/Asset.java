package com.zhanglin.pojo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.zhanglin.Constant;

public class Asset extends AssetKey {
    private BigDecimal cash;

    private BigDecimal addcash;

    private BigDecimal asset;

    private Date updatetime;

    public Asset(AssetRT assetRT) {
		this.cash = assetRT.getCash().divide(Constant.ASSET_UNIT);
		this.addcash = BigDecimal.ZERO;
		this.asset = assetRT.getAsset().divide(Constant.ASSET_UNIT);
		this.setNewid(assetRT.getNewid());
		this.setTime(new SimpleDateFormat(Constant.DEFAULT_DATE_FORMAT).format(new Date()));
	}
    
    public Asset() {
    }
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