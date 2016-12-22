package com.zhanglin.dao;

import com.zhanglin.pojo.AssetRT;
import com.zhanglin.pojo.AssetRTExample;
import java.math.BigDecimal;
import java.util.List;

public interface AssetRTMapper {
    int deleteByPrimaryKey(BigDecimal newid);

    int insert(AssetRT record);

    int insertSelective(AssetRT record);

    List<AssetRT> selectByExample(AssetRTExample example);

    AssetRT selectByPrimaryKey(BigDecimal newid);

    int updateByPrimaryKeySelective(AssetRT record);

    int updateByPrimaryKey(AssetRT record);
    
    int deleteAll();
}