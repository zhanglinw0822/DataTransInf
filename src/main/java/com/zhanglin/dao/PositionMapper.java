package com.zhanglin.dao;

import com.zhanglin.pojo.Position;
import com.zhanglin.pojo.PositionExample;
import java.math.BigDecimal;
import java.util.List;

public interface PositionMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(Position record);

    int insertSelective(Position record);

    List<Position> selectByExample(PositionExample example);

    Position selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);
}