package com.zhanglin.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Position extends PositionKey {
    private BigDecimal holdprice;

    private BigDecimal num;

    private BigDecimal close;

    private Date updatetime;

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