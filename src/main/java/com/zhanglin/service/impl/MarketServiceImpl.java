package com.zhanglin.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhanglin.Constant;
import com.zhanglin.bean.PositionRTKey;
import com.zhanglin.cache.CacheManager;
import com.zhanglin.dao.AssetMapper;
import com.zhanglin.dao.AssetRTMapper;
import com.zhanglin.dao.OrderMapper;
import com.zhanglin.dao.PositionMapper;
import com.zhanglin.dao.PositionRTMapper;
import com.zhanglin.dao.SystemStatusMapper;
import com.zhanglin.pojo.Asset;
import com.zhanglin.pojo.AssetRT;
import com.zhanglin.pojo.AssetRTExample;
import com.zhanglin.pojo.Position;
import com.zhanglin.pojo.PositionExample;
import com.zhanglin.pojo.PositionRT;
import com.zhanglin.pojo.PositionRTExample;
import com.zhanglin.pojo.SystemStatus;
import com.zhanglin.service.IMarketService;
@Transactional
@Service("marketService")
public class MarketServiceImpl implements IMarketService{
	
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
	private SystemStatusMapper systemStatusDao;

	public void openMarket() {
		List<Asset> assets =assetDao.selectLastAsset();
		assetRTDao.deleteAll();
		for (Iterator<Asset> iterator = assets.iterator(); iterator.hasNext();) {
			Asset asset = iterator.next();
			AssetRT assetRT = new AssetRT(asset);
			assetRTDao.insert(assetRT);
		}
		List<Position> positions =positionDao.selectByExample(new PositionExample());
		positionRTDao.deleteAll();
		for (Iterator<Position> iterator = positions.iterator(); iterator.hasNext();) {
			Position position = iterator.next();
			PositionRT positionRT = new PositionRT(position);
			positionRTDao.insert(positionRT);
		}
		SystemStatus status = new SystemStatus();
		status.setId(BigDecimal.ONE);
		status.setStatus(Constant.SYSTEM_STATUS_OPEN);
		status.setTradedate(new SimpleDateFormat(Constant.DEFAULT_DATE_FORMAT).format(new Date()));
		systemStatusDao.updateByPrimaryKey(status);
		//清除缓存
		CacheManager.getInstance().invalidateAll();
	}

	public void closeMarket() {
		List<AssetRT> assets = assetRTDao.selectByExample(new AssetRTExample());
		for (Iterator<AssetRT> iterator = assets.iterator(); iterator.hasNext();) {
			AssetRT assetRT = iterator.next();
			assetDao.insert(new Asset(assetRT));
		}
		
		SystemStatus status = new SystemStatus();
		status.setId(BigDecimal.ONE);
		status.setStatus(Constant.SYSTEM_STATUS_CLOSE);
		systemStatusDao.updateByPrimaryKeySelective(status);
		
	}

	public String getSystemStaus() {
		return systemStatusDao.selectByPrimaryKey(BigDecimal.ONE).getStatus();
	}

}
