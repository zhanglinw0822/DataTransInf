package com.zhanglin.dao;

import com.zhanglin.pojo.Asset;
import com.zhanglin.pojo.AssetExample;
import com.zhanglin.pojo.AssetKey;
import java.util.List;

public interface AssetMapper {
    int deleteByPrimaryKey(AssetKey key);

    int insert(Asset record);

    int insertSelective(Asset record);

    List<Asset> selectByExample(AssetExample example);

    Asset selectByPrimaryKey(AssetKey key);

    int updateByPrimaryKeySelective(Asset record);

    int updateByPrimaryKey(Asset record);
}