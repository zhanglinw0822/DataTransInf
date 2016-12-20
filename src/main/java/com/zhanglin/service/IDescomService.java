package com.zhanglin.service;

import java.math.BigDecimal;

import com.zhanglin.pojo.Descom;
import com.zhanglin.pojo.Order;
import com.zhanglin.pojo.Position;



public interface IDescomService {
	public Descom getDescom(String id);

	public void insertOrder(Order order);

	public void updatePosition(Position position);

	public void updateAsset(BigDecimal newId, BigDecimal multiply);
}
