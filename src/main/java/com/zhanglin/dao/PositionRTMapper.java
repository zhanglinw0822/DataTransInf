package com.zhanglin.dao;

import com.zhanglin.pojo.PositionRT;
import com.zhanglin.pojo.PositionRTExample;
import java.util.List;

public interface PositionRTMapper {
    int insert(PositionRT record);

    int insertSelective(PositionRT record);

    List<PositionRT> selectByExample(PositionRTExample example);
    
    int deleteAll();
}