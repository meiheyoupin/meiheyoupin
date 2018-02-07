package com.meiheyoupin.service;

import com.meiheyoupin.entity.Orders;

import java.util.List;



public interface OrdersService {

    List<Orders> getOrders(Integer state);

    int getOrderSize(Integer state);

    Orders getOrderById(String id);

}
