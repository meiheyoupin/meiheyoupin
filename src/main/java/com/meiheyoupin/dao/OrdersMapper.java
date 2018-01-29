package com.meiheyoupin.dao;

import com.meiheyoupin.entity.Orders;
import java.util.List;


public interface OrdersMapper {

    List<Orders> selectByState(Integer state);

    int selectOrderSize(Integer state);

    Orders selectOrderById(String id);

}