package com.meiheyoupin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.meiheyoupin.entity.Saler;
import com.meiheyoupin.service.GoodsService;
import com.meiheyoupin.service.SalerService;
import com.meiheyoupin.service.StoreService;
import com.meiheyoupin.service.UserService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class RouteController {

    @Autowired
    StoreService storeService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    UserService userService;

    @Autowired
    SalerService salerService;

    @RequestMapping("/")
    public String admin(){
        return "login";
    }

    @GetMapping("/toSaler")
    public String toSaler(){
        return "saler";
    }

    @GetMapping("cpySaler")
    public String toCpySaler(@RequestParam(value = "pageNum",defaultValue = "1",required = false)Integer pageNum,
                             @RequestParam(value = "pageSize",defaultValue = "10",required = false)Integer pageSize,
                             Model model){
        PageHelper.startPage(pageNum,pageSize);
        List<Saler> list = salerService.getSalers();
        PageInfo<Saler> pageInfo = new PageInfo<Saler>(list);
        model.addAttribute("salers",pageInfo);
        return "cpy_saler";
    }

    //未审核商家
    @RequiresRoles({"admin"})
    @GetMapping("cpyStore")
    public String unauditStores(Model model){
        model.addAttribute("unauditStores",storeService.getStoresByState(0));
        return "cpy_store";
    }

    //未审核套餐
    @RequiresRoles({"admin"})
    @GetMapping("cpyPack")
    public String unauditPacks(Model model){
        model.addAttribute("unauditGoods",goodsService.getCorrelationToGoodsByState(0));
        return "cpy_pack";
    }

    @RequiresRoles({"admin"})
    @GetMapping("cpyCustom")
    public String toCpyCustom(){
        return "cpy_custom";
    }

    @RequiresRoles({"admin"})
    @GetMapping("cpyCharges")
    public String toCpyCharges(){
        return "cpy_charges";
    }

    @RequiresRoles({"admin"})
    @GetMapping("cpyUser")
    public String tocpyUser(){
        return "cpy_user";
    }

    @RequiresRoles({"admin"})
    @GetMapping("cpyPackage")
    public String tocpyPackage(){
        return "cpy_package";
    }

}
