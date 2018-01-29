package com.meiheyoupin.controller;

import com.alibaba.fastjson.JSON;
import com.meiheyoupin.dao.OrdersMapper;
import com.meiheyoupin.entity.Orders;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RabbitmqController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    OrdersMapper ordersMapper;

    @GetMapping("send")
    @ResponseBody
    public String toSend(){
        try {
            Orders orders = ordersMapper.selectOrderById("2018012019025068564");
            String res = JSON.toJSONString(orders);
            rabbitTemplate.convertAndSend("direct","key2",res);
            return "success";
        }catch (Exception e ){
            return "error";
        }
    }
}
