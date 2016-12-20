package com.zhanglin.dao;

import com.zhanglin.pojo.Asset;
import com.zhanglin.pojo.AssetExample;
import java.math.BigDecimal;
import java.util.List;

public interface AssetMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(Asset record);

    int insertSelective(Asset record);

    List<Asset> selectByExample(AssetExample example);

    Asset selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(Asset record);

    int updateByPrimaryKey(Asset record);
}