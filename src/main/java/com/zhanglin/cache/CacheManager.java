package com.zhanglin.cache;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.zhanglin.pojo.AllClose;
import org.apache.log4j.Logger;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.zhanglin.pojo.Descom;
import com.zhanglin.pojo.InitHolding;
import com.zhanglin.service.IDescomService;
import com.zhanglin.service.IMarketService;
import com.zhanglin.tools.SpringContextUtil;

public class CacheManager {
	private static Logger logger = Logger.getLogger(CacheManager.class);  
	private LoadingCache<String, List<Descom>> descoms = CacheBuilder.newBuilder()
			.expireAfterWrite(1, TimeUnit.HOURS)
			.build(new CacheLoader<String, List<Descom>>() {
				@Override
				public List<Descom> load(String key) throws Exception {
					return loadDescom(key);
				}
			});
	private LoadingCache<String, String> status = CacheBuilder.newBuilder()
			.expireAfterWrite(1, TimeUnit.MINUTES)
			.build(new CacheLoader<String, String>() {
				@Override
				public String load(String key) throws Exception {
					return loadSystemStatus();
				}

			});
	private LoadingCache<String, Map<String,String>> STCodes = CacheBuilder.newBuilder()
			.expireAfterWrite(1, TimeUnit.DAYS)
			.build(new CacheLoader<String, Map<String,String>>() {
				@Override
				public Map<String,String> load(String key) throws Exception {
					return loadSTCodes();
				}

			});
	
	private LoadingCache<String, Map<String,InitHolding>> initHoldings = CacheBuilder.newBuilder()
			.expireAfterWrite(1, TimeUnit.DAYS)
			.build(new CacheLoader<String, Map<String,InitHolding>>(){
				@Override
				public Map<String,InitHolding> load(String key) throws Exception {
					return loadInitHoldings();
				}

			});

	private LoadingCache<String, Map<String,AllClose>> AllCloses = CacheBuilder.newBuilder()
			.expireAfterWrite(1, TimeUnit.DAYS)
			.build(new CacheLoader<String, Map<String,AllClose>>() {
				@Override
				public Map<String,AllClose> load(String key) throws Exception {
					return loadAllCloses();
				}

			});



	private static CacheManager instance=null;  
	
	private CacheManager(){
		
	}

	public static CacheManager getInstance(){
		if(instance==null){
			synchronized (CacheManager.class) {
				if(instance==null)
					instance = new CacheManager();
			}
		}
		return instance;
	}
	
	IDescomService service = SpringContextUtil.getBean("descomService");
	IMarketService marketService = (IMarketService)SpringContextUtil.getBean("marketService");
	
	private List<Descom> loadDescom(String id) throws Exception {
		List<Descom> descoms = service.getDescom(id);
		if(null==descoms || descoms.size()==0)
			logger.error("组合ID="+id+"未找到数据");
		return descoms;
	}
	
	private String loadSystemStatus() {
		return marketService.getSystemStaus();
	}
	

	private Map<String,String> loadSTCodes() {
		return marketService.getSTCodes();
	}

	private Map<String,AllClose> loadAllCloses() {
		return marketService.getAllCloses();
	}
	
	private Map<String,InitHolding> loadInitHoldings() throws Exception {
		return marketService.getInitHoldings();
	}
	
	public List<Descom> getDescom(String id){
		try {
			List<Descom> results = descoms.get(id);
			logger.info("缓存中数据："+descoms.asMap());
			return results;
		} catch (Exception e) {
			logger.error("获取组合失败", e);
			return null;
		}
	}
	
	public String getSystemStatus(){
		try {
			String systemStatus = status.get("status");
			logger.info("缓存中数据："+status.asMap());
			return systemStatus;
		} catch (Exception e) {
			logger.error("获取系统状态失败", e);
			return null;
		}
	}
	
	public Map<String,String> getSTCode(){
		try {
			return STCodes.get("ST");
		} catch (Exception e) {
			logger.error("获取ST失败", e);
			return null;
		}
	}
	public Map<String,InitHolding> getInitHolding(){
		try {
			return initHoldings.get("InitHolding");
		} catch (Exception e) {
			logger.error("获取initholding失败", e);
			return null;
		}
	}

	public Map<String,AllClose> getAllClose(){
		try {
			return AllCloses.get("AllClose");
		} catch (Exception e) {
			logger.error("获取AllClose失败", e);
			return null;
		}
	}
	
	public void invalidate(String id){
		descoms.invalidate(id);
	}
	
	public void invalidateAll(){
		descoms.invalidateAll();
		initHoldings.invalidateAll();
		status.invalidateAll();
		STCodes.invalidateAll();
		AllCloses.invalidateAll();
	}
}
