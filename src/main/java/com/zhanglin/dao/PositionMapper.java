package com.zhanglin.dao;

import com.zhanglin.pojo.Position;
import com.zhanglin.pojo.PositionExample;
import com.zhanglin.pojo.PositionKey;
import java.util.List;

public interface PositionMapper {
    int deleteByPrimaryKey(PositionKey key);

    int insert(Position record);

    int insertSelective(Position record);

    List<Position> selectByExample(PositionExample example);

    Position selectByPrimaryKey(PositionKey key);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);
}