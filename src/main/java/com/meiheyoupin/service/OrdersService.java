package com.meiheyoupin.service;

import com.meiheyoupin.entity.Orders;

import java.util.List;
import java.util.Map;


public interface OrdersService {

    List<Orders> getOrders(Integer state);

    int getOrderSize(Integer state);

    Orders getOrderById(String id);

    List<Orders> getOrdersForInviteCode(String inviteCode);
}
