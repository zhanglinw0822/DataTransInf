package com.zhanglin.cache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.zhanglin.pojo.Descom;
import com.zhanglin.service.IDescomService;

public class CacheManager {
	private static Logger logger = Logger.getLogger(CacheManager.class);  
	private LoadingCache<String, Descom> descoms = CacheBuilder.newBuilder()
			.expireAfterWrite(60, TimeUnit.SECONDS)
			.maximumSize(1000).build(new CacheLoader<String, Descom>() {
				@Override
				public Descom load(String key) throws Exception {
					return loadDescom(key);
				}
			});
	
	private static CacheManager instance=null;  
	
	public static CacheManager getInstance(){
		if(instance==null){
			synchronized (CacheManager.class) {
				if(instance==null)
					instance = new CacheManager();
			}
		}
		return instance;
	}
	
	@Resource
	IDescomService service;
	
	private Descom loadDescom(String id) throws Exception {
		Descom descom = service.getDescom(id);
		if(null==descom)
			throw new Exception("组合ID="+id+"未找到数据");
		return descom;
	}
	
	public Descom getDescom(String id){
		try {
//			return descoms.get(id);
			return service.getDescom(id);
		} catch (Exception e) {
			logger.error("获取组合失败", e);
			return null;
		}
	}
}
