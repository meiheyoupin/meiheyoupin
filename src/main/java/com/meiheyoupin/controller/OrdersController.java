package com.meiheyoupin.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.meiheyoupin.entity.Orders;
import com.meiheyoupin.service.OrdersService;
import com.meiheyoupin.common.R1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    /*
    根据订单状态拿到订单数量
     */
    @GetMapping("ordersize")
    @ResponseBody
    public R1 toOrderSize(@RequestParam Integer state){
        return R1.add("count",ordersService.getOrderSize(state));
    }

    /*
    根据订单状态拿到订单
     */
    @GetMapping("orders")
    @ResponseBody
    public R1 toFinishedOrders(@RequestParam Integer state,
                               @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                               @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Orders> list = ordersService.getOrders(state);
        PageInfo<Orders> pageInfo = new PageInfo<Orders>(list);
        return R1.add("orders",pageInfo);
    }
}
