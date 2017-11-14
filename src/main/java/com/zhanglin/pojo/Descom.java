package com.zhanglin.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.common.base.MoreObjects;
import com.zhanglin.Constant;

public class Descom {
    private BigDecimal newid;

    private String id;

    private String time;

    private BigDecimal istrue;

    private Date updatetime;

	private BigDecimal tstatus;

	/**
     * 组合资金
     */
    private AssetRT asset;
    /**
     * 组合历史持仓
     */
    private List<Position> position;
    /**
     * 组合当日持仓
     */
    private List<PositionRT> positionRT = new ArrayList<PositionRT>();
    
    /**
     * 期初资金
     */
    private Asset firstAsset;
    
    public Asset getFirstAsset() {
		return firstAsset;
	}

	public void setFirstAsset(Asset firstAsset) {
		this.firstAsset = firstAsset;
	}

	public void setPositionRT(List<PositionRT> positionRT) {
		this.positionRT = positionRT;
		for (Iterator<PositionRT> iterator = positionRT.iterator(); iterator.hasNext();) {
			PositionRT temp = iterator.next();
			// 如果是当日减仓，需要更新使持仓数据减少
			if (temp.getSource() == Constant.POSITION_SOURCE_NEW && temp.getNum().compareTo(BigDecimal.ZERO) < 0){
				putCodePosition(temp.getCode()+"_"+Constant.POSITION_SOURCE_REAL, temp.getNum());
			}
			putCodePosition(temp.getCode()+"_"+temp.getSource(), temp.getNum());
		}
	}

	/**
     * 组合股票持仓总数
     */
    private Map<String,BigDecimal> codePositions = new HashMap<String, BigDecimal>();
    

    public AssetRT getAsset() {
		return asset;
	}

	public void setAsset(AssetRT asset) {
		this.asset = asset;
	}

	public void setPosition(List<Position> position) {
		this.position = position;
	}
	
	public BigDecimal getHoldedCodeAccount(String code){
		return codePositions.get(code+"_"+Constant.POSITION_SOURCE_REAL);
	}
	
	public BigDecimal getNewHoldCodeAccount(String code){
		return codePositions.get(code+"_"+Constant.POSITION_SOURCE_NEW);
	}
	
	public BigDecimal getInitHoldCodeAccount(String code){
		String key = code+"_"+Constant.POSITION_SOURCE_INITHOLDING;
		return codePositions.get(key)==null?BigDecimal.ZERO:codePositions.get(key);
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

	public BigDecimal getTstatus() {
		return tstatus;
	}

	public void setTstatus(BigDecimal tstatus) {
		this.tstatus = tstatus;
	}

	public void addPosition(PositionRT position) {
		this.positionRT.add(position);
		// 如果是当日减仓，需要使实际持仓数据减少
		if (position.getSource() == Constant.POSITION_SOURCE_NEW && position.getNum().compareTo(BigDecimal.ZERO) < 0){
			putCodePosition(position.getCode()+"_"+Constant.POSITION_SOURCE_REAL, position.getNum());
		}
		putCodePosition(position.getCode()+"_"+position.getSource(),position.getNum());
	}
	
	private void putCodePosition(String code,BigDecimal num){
		if(codePositions.containsKey(code)){
			codePositions.put(code, codePositions.get(code).add(num));
		}else{
			codePositions.put(code, num);
		}
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("newid", newid)
				.add("id", id).add("time", time).add("istrue", istrue)
				.add("updatetime", updatetime).add("tstatus", tstatus).add("asset", asset)
				.add("position", position).add("positionRT", positionRT)
				.add("codePositions", codePositions).toString();
	}
	
	
}