package com.zhanglin.cache;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import com.zhanglin.bean.Data;
import com.zhanglin.cache.thread.TakenData;

public class DataManager {

	private BlockingQueue<Data>  queue = new LinkedBlockingDeque<Data>();
	
	private static DataManager instance=null;  
	
	private DataManager() {
		new TakenData().start();
	}
	
	public static DataManager getInstance(){
		if(instance==null){
			synchronized (DataManager.class) {
				if(instance==null)
					instance = new DataManager();
			}
		}
		return instance;
	}
	
	public void addData(Data data){
		queue.add(data);
	}
	
	public Data takeData() throws InterruptedException{
		return queue.take();
	}
}
