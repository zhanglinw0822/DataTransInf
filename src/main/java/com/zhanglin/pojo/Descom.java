package com.zhanglin.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Descom {
    private BigDecimal newid;

    private String id;

    private String time;

    private BigDecimal istrue;

    private Date updatetime;
    
    /**
     * 组合资金
     */
    private List<Asset> asset;
    /**
     * 组合持仓
     */
    private List<Position> position;
    
    /**
     * 组合股票持仓总数
     */
    private Map<String,BigDecimal> codePositions = new HashMap<String, BigDecimal>();
    

    public List<Asset> getAsset() {
		return asset;
	}

	public void setAsset(List<Asset> asset) {
		this.asset = asset;
	}

	public List<Position> getPosition() {
		return position;
	}

	public void setPosition(List<Position> position) {
		this.position = position;
		for (Iterator<Position> iterator = position.iterator(); iterator.hasNext();) {
			Position temp = iterator.next();
			if(codePositions.containsKey(temp.getCode())){
				codePositions.put(temp.getCode(), codePositions.get(temp.getCode()).add(temp.getNum()));
			}else{
				codePositions.put(temp.getCode(), temp.getNum());
			}
		}
	}
	
	public BigDecimal getCodeAccount(String code){
		return codePositions.get(code);
	}

	public BigDecimal getNewid() {
        return newid;
    }

    public void setNewid(BigDecimal newid) {
        this.newid = newid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public BigDecimal getIstrue() {
        return istrue;
    }

    public void setIstrue(BigDecimal istrue) {
        this.istrue = istrue;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}