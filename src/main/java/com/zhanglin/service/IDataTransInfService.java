package com.zhanglin.service;

import com.zhanglin.bean.Data;


public interface IDataTransInfService {
	public void dataTransInfo(Data data) throws Exception;
	
	public void reciveData(Data data) throws Exception;
	/**
	 * @param data 数据
	 * @param isFromInterface 是否为接口数据
	 * @throws Exception
	 */
	public void handleData(Data data,boolean isFromInterface) throws Exception;
}