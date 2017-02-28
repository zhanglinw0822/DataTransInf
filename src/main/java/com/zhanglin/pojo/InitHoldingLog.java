package com.zhanglin.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class InitHoldingLog {
    private String id;

    private String curdate;

    private String code;

    private BigDecimal weight;

    private BigDecimal net;

    private BigDecimal newid;

    private BigDecimal volume;

    private BigDecimal closeprice;

    private Date updatetime;

    public InitHoldingLog(InitHolding initHolding) {
		this.id = initHolding.getId();
		this.curdate = initHolding.getCurdate();
		this.code = initHolding.getCode();
		this.weight = initHolding.getWeight();
		this.net = initHolding.getNet();
		this.newid = initHolding.getNewid();
		this.volume = initHolding.getVolume();
		this.closeprice = initHolding.getCloseprice();
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCurdate() {
        return curdate;
    }

    public void setCurdate(String curdate) {
        this.curdate = curdate == null ? null : curdate.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getNet() {
        return net;
    }

    public void setNet(BigDecimal net) {
        this.net = net;
    }

    public BigDecimal getNewid() {
        return newid;
    }

    public void setNewid(BigDecimal newid) {
        this.newid = newid;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getCloseprice() {
        return closeprice;
    }

    public void setCloseprice(BigDecimal closeprice) {
        this.closeprice = closeprice;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}