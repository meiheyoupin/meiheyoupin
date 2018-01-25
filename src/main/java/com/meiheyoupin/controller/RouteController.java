package com.meiheyoupin.controller;

import com.meiheyoupin.entity.Goods;
import com.meiheyoupin.service.GoodsService;
import com.meiheyoupin.service.StoreService;
import com.meiheyoupin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
        model.addAttribute("unauditGoods",goodsService.getGoodsByState(0));
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

    /*
    以下皆为shiro
     */
    //@RequiresRoles("admin")
    @GetMapping("admin/toAdmin")
    public String toAdmin(){
        return "shiro/toAdmin";
    }

    @GetMapping("user/toUser")
    public String toUser(){
        return "shiro/toUser";
    }

    @GetMapping("toLogin")
    public String toLogin(){
        return "shiro/toLogin";
    }

}
