package com.zhanglin.service;

import com.zhanglin.pojo.AssetRT;
import com.zhanglin.pojo.Descom;
import com.zhanglin.pojo.InitHoldingLog;
import com.zhanglin.pojo.Order;
import com.zhanglin.pojo.PositionRT;
import com.zhanglin.pojo.Record;



public interface IDescomService {
	public Descom getDescom(String id);

	public void insertOrder(Order order);

	public void updatePositionRT(PositionRT position);

	public void updateAssetRT(AssetRT asset);

	public void insertRecord(Record record);
	
	public void insertInitHoldingLog(InitHoldingLog holding);
}
