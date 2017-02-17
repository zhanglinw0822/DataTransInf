package com.zhanglin.dao;

import com.zhanglin.pojo.ST;
import com.zhanglin.pojo.STExample;
import java.util.List;

public interface STMapper {
    int insert(ST record);

    int insertSelective(ST record);

    List<ST> selectByExample(STExample example);
}