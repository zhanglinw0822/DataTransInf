package com.zhanglin.dao;

import com.zhanglin.pojo.InitHolding;
import com.zhanglin.pojo.InitHoldingExample;
import java.util.List;

public interface InitHoldingMapper {
    int insert(InitHolding record);

    int insertSelective(InitHolding record);

    List<InitHolding> selectByExample(InitHoldingExample example);
}