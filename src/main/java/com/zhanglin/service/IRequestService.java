package com.zhanglin.service;

import java.math.BigDecimal;

import com.zhanglin.bean.Data;
import com.zhanglin.pojo.TransferRequest;

public interface IRequestService {
	public BigDecimal insertRequest(Data data, String status);
	
	public TransferRequest getRequest(Data data);

	public void updateRequest(Data data, String status);
}
