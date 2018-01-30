package com.meiheyoupin.controller;

import com.meiheyoupin.service.GoodsService;
import com.meiheyoupin.service.StoreService;
import com.meiheyoupin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;


@Controller
public class RouteController {

    @Autowired
    StoreService storeService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String admin(){
        return "login";
    }

    @GetMapping("cpySaler")
    public String toCpySaler(){
        return "cpy_saler";
    }

    @GetMapping("cpyPerson")
    public String toCpyPerson(Model model){
        model.addAttribute("user",userService.getUser());
        return "cpy_person";
    }

    //未审核商家
    @GetMapping("cpyStore")
    public String unauditStores(Model model){
        model.addAttribute("unauditStores",storeService.getStoresByState(0));
        return "cpy_store";
    }

    //未审核套餐
    @GetMapping("cpyPack")
    public String unauditPacks(Model model){
        model.addAttribute("unauditGoods",goodsService.getGoodsAndStoreByState(0));
        return "cpy_pack";
    }

    @GetMapping("cpyCustom")
    public String toCpyCustom(){
        return "cpy_custom";
    }

    @GetMapping("cpyCharges")
    public String toCpyCharges(){
        return "cpy_charges";
    }

    @GetMapping("cpyUser")
    public String tocpyUser(){
        return "cpy_user";
    }

    @GetMapping("cpyPackage")
    public String tocpyPackage(){
        return "cpy_package";
    }

}
