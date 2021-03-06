package com.zhanglin.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class PositionRT {
    private String code;

    private BigDecimal holdprice;

    private BigDecimal num;

    private BigDecimal newid;

    private Date updatetime;
    
    private String windCode;
    
    private int source;

    public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public String getWindCode() {
		return windCode;
	}

	public void setWindCode(String windCode) {
		this.windCode = windCode;
	}

	public PositionRT(Position position) {
    	this.code = position.getCode();
    	this.num = position.getNum();
    	this.newid = position.getNewid();
    	this.updatetime = position.getUpdatetime();
    	this.windCode = position.getWindCode();
	}
    
    public PositionRT(){
    	
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

    public BigDecimal getNewid() {
        return newid;
    }

    public void setNewid(BigDecimal newid) {
        this.newid = newid;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

	@Override
	public String toString() {
		return "PositionRT [code=" + code + ", holdprice=" + holdprice
				+ ", num=" + num + ", newid=" + newid + ", updatetime="
				+ updatetime + "]";
	}
    
    
}