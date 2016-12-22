package com.zhanglin.pojo;

import java.math.BigDecimal;
import java.util.Date;

import com.google.common.base.MoreObjects;
import com.zhanglin.Constant;

public class AssetRT {
    private BigDecimal newid;

    private BigDecimal cash;

    private BigDecimal asset;

    private Date updatetime;

    public AssetRT(Asset asset) {
		this.newid = asset.getNewid();
		this.cash = asset.getCash().add(asset.getAddcash()).multiply(Constant.ASSET_UNIT);
		this.asset = asset.getAsset().multiply(Constant.ASSET_UNIT);
	}
    
    public AssetRT() {
	}

	public BigDecimal getNewid() {
        return newid;
    }

    public void setNewid(BigDecimal newid) {
        this.newid = newid;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
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

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("newid", newid)
				.add("cash", cash).add("asset", asset)
				.add("updatetime", updatetime).toString();
	}
    
}