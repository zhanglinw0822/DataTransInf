package com.zhanglin.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Position extends PositionKey {
    private BigDecimal num;

    private BigDecimal close;

    private Date updatetime;
    
    private String windCode;

    public String getWindCode() {
		return windCode;
	}

	public void setWindCode(String windCode) {
		this.windCode = windCode;
	}

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public BigDecimal getClose() {
        return close;
    }

    public void setClose(BigDecimal close) {
        this.close = close;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}