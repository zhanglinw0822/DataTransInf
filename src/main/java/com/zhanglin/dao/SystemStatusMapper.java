package com.zhanglin.dao;

import com.zhanglin.pojo.SystemStatus;
import com.zhanglin.pojo.SystemStatusExample;
import java.math.BigDecimal;
import java.util.List;

public interface SystemStatusMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(SystemStatus record);

    int insertSelective(SystemStatus record);

    List<SystemStatus> selectByExample(SystemStatusExample example);

    SystemStatus selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(SystemStatus record);

    int updateByPrimaryKey(SystemStatus record);
}