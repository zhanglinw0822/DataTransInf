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
	private LoadingCache<Integer, Descom> descoms = CacheBuilder.newBuilder()
			.expireAfterWrite(60, TimeUnit.SECONDS)
			.maximumSize(1000).build(new CacheLoader<Integer, Descom>() {
				@Override
				public Descom load(Integer key) throws Exception {
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
	
	private Descom loadDescom(Integer id) {
		return service.getDescom(id);
	}
	
	public Descom getDescom(Integer id){
		try {
			return descoms.get(id);
		} catch (ExecutionException e) {
			logger.error("获取组合失败", e);
			return null;
		}
	}
}
