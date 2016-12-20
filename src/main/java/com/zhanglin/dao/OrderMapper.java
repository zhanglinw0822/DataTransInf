package com.zhanglin.dao;

import com.zhanglin.pojo.Order;
import com.zhanglin.pojo.OrderExample;
import java.util.List;

public interface OrderMapper {
    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);
}