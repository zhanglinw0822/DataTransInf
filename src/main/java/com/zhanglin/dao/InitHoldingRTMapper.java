package com.zhanglin.dao;

import com.zhanglin.pojo.InitHoldingRT;
import com.zhanglin.pojo.InitHoldingRTExample;
import java.util.List;

public interface InitHoldingRTMapper {
    int insert(InitHoldingRT record);

    int insertSelective(InitHoldingRT record);

    List<InitHoldingRT> selectByExample(InitHoldingRTExample example);
}