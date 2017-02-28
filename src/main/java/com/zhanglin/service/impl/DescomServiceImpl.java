package com.zhanglin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhanglin.dao.AssetMapper;
import com.zhanglin.dao.AssetRTMapper;
import com.zhanglin.dao.DescomMapper;
import com.zhanglin.dao.InitHoldingLogMapper;
import com.zhanglin.dao.OrderMapper;
import com.zhanglin.dao.PositionMapper;
import com.zhanglin.dao.PositionRTMapper;
import com.zhanglin.dao.RecordMapper;
import com.zhanglin.pojo.AssetRT;
import com.zhanglin.pojo.Descom;
import com.zhanglin.pojo.DescomExample;
import com.zhanglin.pojo.InitHoldingLog;
import com.zhanglin.pojo.Order;
import com.zhanglin.pojo.PositionExample;
import com.zhanglin.pojo.PositionRT;
import com.zhanglin.pojo.PositionRTExample;
import com.zhanglin.pojo.Record;
import com.zhanglin.service.IDescomService;
@Service("descomService")
public class DescomServiceImpl implements IDescomService{
	
	@Resource
	private DescomMapper descomDao;
	@Resource
	private PositionMapper positionDao;
	@Resource
	private AssetMapper assetDao;
	@Resource
	private OrderMapper orderDao;
	@Resource
	private PositionRTMapper positionRTDao;
	@Resource
	private AssetRTMapper assetRTDao;
	@Resource
	private RecordMapper recordDao;
	@Resource
	private InitHoldingLogMapper initHoldingLogDao;
	
	public Descom getDescom(String id) {
		DescomExample example = new DescomExample();
		example.createCriteria().andIdEqualTo(id);
		List<Descom> descoms = descomDao.selectByExample(example);
		if(descoms.size()>0){
			Descom descom = descoms.get(0);
			
			PositionExample positionExample = new PositionExample();
			positionExample.createCriteria().andNewidEqualTo(descom.getNewid());
			descom.setPosition(positionDao.selectByExample(positionExample));
			
			PositionRTExample positionRTExample = new PositionRTExample();
			positionRTExample.createCriteria().andNewidEqualTo(descom.getNewid());
			descom.setPositionRT(positionRTDao.selectByExample(positionRTExample));
			
			descom.setAsset(assetRTDao.selectByPrimaryKey(descom.getNewid()));
			
			descom.setFirstAsset(assetDao.selectFirstAsset(descom.getNewid()));
		}
		return descoms.size()>0?descoms.get(0):null;
	}

	public void insertOrder(Order order) {
		orderDao.insert(order);
	}

	public void updatePositionRT(PositionRT position) {
		positionRTDao.insert(position);
	}

	public void updateAssetRT(AssetRT asset) {
		assetRTDao.updateByPrimaryKey(asset);
	}

	public void insertRecord(Record record) {
		recordDao.insert(record);
	}

	public void insertInitHoldingLog(InitHoldingLog holding) {
		initHoldingLogDao.insert(holding);
	}

}
