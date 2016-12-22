package com.zhanglin.pojo;

import java.math.BigDecimal;

import com.google.common.base.Objects;
import com.zhanglin.bean.PositionRTKey;

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

	@Override
	public int hashCode() {
		return Objects.hashCode(code,newid);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PositionKey) {
			PositionKey that = (PositionKey) obj;
            return Objects.equal(code, that.code)
                    && Objects.equal(newid, that.newid);
        }
        return false;
	}
}