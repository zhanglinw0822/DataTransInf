package com.zhanglin.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import com.zhanglin.dao.AssetMapper;
import com.zhanglin.dao.DescomMapper;
import com.zhanglin.dao.OrderMapper;
import com.zhanglin.dao.PositionMapper;
import com.zhanglin.pojo.Asset;
import com.zhanglin.pojo.AssetExample;
import com.zhanglin.pojo.Descom;
import com.zhanglin.pojo.DescomExample;
import com.zhanglin.pojo.Order;
import com.zhanglin.pojo.Position;
import com.zhanglin.pojo.PositionExample;
import com.zhanglin.service.IDescomService;

public class DescomServiceImpl implements IDescomService{
	
	@Resource
	private DescomMapper descomDao;
	@Resource
	private PositionMapper positionDao;
	@Resource
	private AssetMapper assetDao;
	@Resource
	private OrderMapper orderDao;
	
	public Descom getDescom(String id) {
		DescomExample example = new DescomExample();
		example.createCriteria().andIdEqualTo(id);
		List<Descom> descoms = descomDao.selectByExample(example);
		if(descoms.size()>0){
			Descom descom = descoms.get(0);
			
			PositionExample positionExample = new PositionExample();
			positionExample.createCriteria().andNewidEqualTo(descom.getNewid());
			descom.setPosition(positionDao.selectByExample(positionExample));
			
			AssetExample assetExample = new AssetExample();
			assetExample.createCriteria().andNewidEqualTo(descom.getNewid());
			descom.setAsset(assetDao.selectByExample(assetExample));
		}
		return descoms.size()>0?descoms.get(0):null;
	}

	public void insertOrder(Order order) {
		orderDao.insert(order);
	}

	public void updatePosition(Position position) {
		//TODO 怎么更新持仓数据，有待确认
		positionDao.insert(position);
	}

	public void updateAsset(BigDecimal newId, BigDecimal multiply) {
		// TODO 怎么更新资金数据，有待确认
		assetDao.updateByPrimaryKey(new Asset());
	}

}
