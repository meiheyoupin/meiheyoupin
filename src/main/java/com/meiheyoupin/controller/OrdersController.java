package com.meiheyoupin.controller;


import com.meiheyoupin.service.OrdersService;
import com.meiheyoupin.utils.R1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @GetMapping("ordersize")
    @ResponseBody
    public R1 toOrderSize(@RequestParam Integer state){
        return R1.add("count",ordersService.getOrderSize(state));
    }

    @GetMapping("orders")
    @ResponseBody
    public R1 toFinishedOrders(@RequestParam Integer state){
        return R1.add("orders",ordersService.getOrders(state));
    }
}
