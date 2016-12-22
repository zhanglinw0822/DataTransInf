package com.zhanglin.bean;

import java.math.BigDecimal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class PositionRTKey {

	private String code;
	
	private BigDecimal newid;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getNewid() {
		return newid;
	}

	public void setNewid(BigDecimal newid) {
		this.newid = newid;
	}
	
	public PositionRTKey(String code,BigDecimal newid){
		this.code = code;
		this.newid = newid;
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("code", code)
				.add("newid", newid).toString();
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(code,newid);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PositionRTKey) {
			PositionRTKey that = (PositionRTKey) obj;
            return Objects.equal(code, that.code)
                    && Objects.equal(newid, that.newid);
        }
        return false;
	}
}
