package com.meiheyoupin.dao;

import com.meiheyoupin.entity.Orders;
import com.meiheyoupin.entity.OrdersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdersMapper {

    List<Orders> selectByExample(OrdersExample example);

    List<Orders> selectByState(Integer state);

    int selectOrderSize(Integer state);
}