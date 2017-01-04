package com.zhanglin.dao;

import com.zhanglin.pojo.Order;
import com.zhanglin.pojo.OrderExample;
import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Object msguid);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Object msguid);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}