package com.meiheyoupin.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.meiheyoupin.common.utils.R;
import com.meiheyoupin.entity.Demand;
import com.meiheyoupin.entity.Orders;
import com.meiheyoupin.service.DemandService;
import com.meiheyoupin.service.OrdersService;
import com.meiheyoupin.common.utils.R1;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @Autowired
    DemandService demandService;

    /**
     * 根据订单状态拿到订单数量
     * @param state 订单状态
     * @return  count
     */
    @RequiresRoles("admin")
    @GetMapping("ordersize")
    public R1 toOrderSize(@RequestParam Integer state){
        return R1.add("count",ordersService.getOrderSize(state));
    }

    /**
     * 根据订单状态拿到订单
     * @param state 订单状态
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequiresRoles("admin")
    @GetMapping("orders")
    public R1 toFinishedOrders(@RequestParam Integer state,
                               @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                               @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Orders> list = ordersService.getOrders(state);
        PageInfo<Orders> pageInfo = new PageInfo<Orders>(list);
        return R1.add("orders",pageInfo);
    }

    /**
     * 根据销售员的邀请码拿到所有与之相关的订单
     * @param invitationCode 邀请码
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequiresRoles("saler")
    @GetMapping("salerOrders")
    public R toSalerOrders(@RequestParam String invitationCode,
                           @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                           @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Orders> pageInfo = new PageInfo<Orders>(ordersService.getOrdersForInviteCode(invitationCode));
        return R.ok().put("salerOrders",pageInfo);
    }

    /**
     * 获取所有有效的定制订单（分页）
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequiresRoles("admin")
    @GetMapping("demands")
    public R demands(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                     @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return R.ok().put("demands",new PageInfo<>(demandService.getDemands()));
    }
}
