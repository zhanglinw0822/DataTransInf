package com.zhanglin.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.zhanglin.dao.*;
import com.zhanglin.pojo.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhanglin.Constant;
import com.zhanglin.cache.CacheManager;
import com.zhanglin.service.IMarketService;
import com.zhanglin.tools.CustomizedPropertyConfigurer;
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
	@Resource
	private STMapper STDao;
	@Resource
	private InitHoldingMapper initHoldingDao;
	@Resource
	private DescomMapper descomDao;
	@Resource
	private AllCloseMapper allCloseDao;
    private boolean initholdingflag = CustomizedPropertyConfigurer.getBooleanContextProperty("initholdingflag");;
	
	public void openMarket() {
		List<Asset> assets =assetDao.selectLastAsset();
		assetRTDao.deleteAll();
		positionRTDao.deleteAll();
		for (Iterator<Asset> iterator = assets.iterator(); iterator.hasNext();) {
			Asset asset = iterator.next();
			AssetRT assetRT = new AssetRT(asset);
			assetRTDao.insert(assetRT);
			
			Position position = new Position();
			position.setNewid(asset.getNewid());
			position.setTime(asset.getTime());
			List<Position> positions = positionDao.getHolding(position);
			for (Iterator<Position> iterator2 = positions.iterator(); iterator2.hasNext();) {
				Position position_temp = iterator2.next();
				PositionRT positionRT = new PositionRT(position_temp);
				positionRT.setSource(Constant.POSITION_SOURCE_PREVIOUS);
				positionRTDao.insert(positionRT);
			}
		}

		SystemStatus status = new SystemStatus();
		status.setId(BigDecimal.ONE);
		status.setStatus(Constant.SYSTEM_STATUS_OPEN);
		status.setTradedate(new SimpleDateFormat(Constant.DEFAULT_DATE_FORMAT).format(new Date()));
		systemStatusDao.updateByPrimaryKey(status);
		
		loadCache();
	}

	public void loadCache() {
		//清除缓存
		CacheManager.getInstance().invalidateAll();
		
		//初始化缓存数据
		DescomExample example = new DescomExample();
		example.createCriteria().andIstrueEqualTo(BigDecimal.ONE);
		List<Descom> descoms = descomDao.selectByExample(example);
		for (Iterator<Descom> iterator = descoms.iterator(); iterator.hasNext();) {
			Descom descom = iterator.next();
			CacheManager.getInstance().getDescom(descom.getId());
		}
		if(initholdingflag){
			CacheManager.getInstance().getInitHolding();
		}
		CacheManager.getInstance().getSTCode();
		CacheManager.getInstance().getSystemStatus();
		CacheManager.getInstance().getAllClose();
	}

	public Map<String, AllClose> getAllCloses() {
		Map<String, AllClose> map = new HashMap<String, AllClose>();
		List<AllClose> sts = allCloseDao.list();
		for (Iterator<AllClose> iterator = sts.iterator(); iterator.hasNext();) {
			AllClose temp = iterator.next();
			map.put(temp.getCode(), temp);
		}
		return map;
	}

	public void closeMarket() {
//		List<AssetRT> assets = assetRTDao.selectByExample(new AssetRTExample());
//		for (Iterator<AssetRT> iterator = assets.iterator(); iterator.hasNext();) {
//			AssetRT assetRT = iterator.next();
//			assetDao.insert(new Asset(assetRT));
//		}
		
		SystemStatus status = new SystemStatus();
		status.setId(BigDecimal.ONE);
		status.setStatus(Constant.SYSTEM_STATUS_CLOSE);
		systemStatusDao.updateByPrimaryKeySelective(status);
		//清除缓存
		CacheManager.getInstance().invalidateAll();
	}
	
	public String getSystemStaus() {
		return systemStatusDao.selectByPrimaryKey(BigDecimal.ONE).getStatus();
	}

	public Map<String, String> getSTCodes() {
		Map<String, String> map = new HashMap<String, String>();
		List<ST> sts = STDao.selectByExample(new STExample());
		for (Iterator<ST> iterator = sts.iterator(); iterator.hasNext();) {
			ST st = iterator.next();
			map.put(st.getCode(), st.getName());
		}
		return map;
	}

	public Map<String, InitHolding> getInitHoldings() {
		Map<String, InitHolding> map = new HashMap<String, InitHolding>();
		List<InitHolding> initHoldings = getInitHoldingList();
		for (Iterator<InitHolding> iterator = initHoldings.iterator(); iterator.hasNext();) {
			InitHolding initHolding = iterator.next();
			map.put(initHolding.getCode()+"_"+initHolding.getNewid().intValue(), initHolding);
		}
		return map;
	}
	
	public List<InitHolding> getInitHoldingList() {
		return initHoldingDao.selectNotHandled();
	}

}
