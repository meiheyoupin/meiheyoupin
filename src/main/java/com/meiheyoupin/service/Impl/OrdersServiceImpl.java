package com.meiheyoupin.service.Impl;

import com.meiheyoupin.dao.OrdersMapper;
import com.meiheyoupin.entity.Orders;
import com.meiheyoupin.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersMapper ordersMapper;

    @Override
    public List<Orders> getOrders(Integer state) {
        return ordersMapper.selectByState(state);
    }

    @Override
    public int getOrderSize(Integer state) {
        return ordersMapper.selectOrderSize(state);
    }

    @Override
    public Orders getOrderById(String id) {
        return ordersMapper.selectOrderById(id);
    }

}
