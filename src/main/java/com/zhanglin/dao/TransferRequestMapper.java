package com.zhanglin.dao;

import com.zhanglin.pojo.TransferRequest;
import com.zhanglin.pojo.TransferRequestExample;
import java.math.BigDecimal;
import java.util.List;

public interface TransferRequestMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(TransferRequest record);

    int insertSelective(TransferRequest record);

    List<TransferRequest> selectByExample(TransferRequestExample example);

    TransferRequest selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(TransferRequest record);

    int updateByPrimaryKey(TransferRequest record);
    
    int updateByMsguid(TransferRequest record);
}