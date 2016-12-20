package com.zhanglin.service.impl;

import java.math.BigDecimal;

import javax.annotation.Resource;

import com.zhanglin.dao.DescomMapper;
import com.zhanglin.pojo.Descom;
import com.zhanglin.service.IDescomService;

public class DescomServiceImpl implements IDescomService{
	
	@Resource
	private DescomMapper dao;
	
	public Descom getDescom(Integer id) {
		return dao.selectByPrimaryKey(new BigDecimal(id));
	}

}
