package com.zhanglin.dao;

import com.zhanglin.pojo.Record;
import com.zhanglin.pojo.RecordExample;
import java.util.List;

public interface RecordMapper {
    int deleteByPrimaryKey(Object msguid);

    int insert(Record record);

    int insertSelective(Record record);

    List<Record> selectByExample(RecordExample example);

    Record selectByPrimaryKey(Object msguid);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);
}