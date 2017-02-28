package com.zhanglin.dao;

import com.zhanglin.pojo.InitHoldingLog;
import com.zhanglin.pojo.InitHoldingLogExample;
import java.util.List;

public interface InitHoldingLogMapper {
    int insert(InitHoldingLog record);

    int insertSelective(InitHoldingLog record);

    List<InitHoldingLog> selectByExample(InitHoldingLogExample example);
}