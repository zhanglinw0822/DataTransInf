package com.zhanglin.service;

import com.zhanglin.bean.Data;


public interface IDataTransInfService {
	public void dataTransInfo(Data data) throws Exception;
	
	public void reciveData(Data data) throws Exception;
	
	public void handleInitHolding();
}