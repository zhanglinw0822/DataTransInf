package com.zhanglin.dao;

import com.zhanglin.pojo.Descom;
import com.zhanglin.pojo.DescomExample;
import java.math.BigDecimal;
import java.util.List;

public interface DescomMapper {
    int deleteByPrimaryKey(BigDecimal newid);

    int insert(Descom record);

    int insertSelective(Descom record);

    List<Descom> selectByExample(DescomExample example);

    Descom selectByPrimaryKey(BigDecimal newid);

    int updateByPrimaryKeySelective(Descom record);

    int updateByPrimaryKey(Descom record);
}