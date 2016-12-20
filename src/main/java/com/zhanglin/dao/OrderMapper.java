package com.zhanglin.dao;

import com.zhanglin.pojo.Order;
import com.zhanglin.pojo.OrderExample;
import java.math.BigDecimal;
import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}