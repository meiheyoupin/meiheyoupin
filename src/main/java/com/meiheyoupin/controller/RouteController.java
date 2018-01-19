package com.meiheyoupin.controller;

import com.meiheyoupin.entity.Goods;
import com.meiheyoupin.service.GoodsService;
import com.meiheyoupin.service.StoreService;
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

    @RequestMapping("/")
    public String admin(){
        return "login";
    }

    @GetMapping("cpyPerson")
    public String toCpyPerson(){
        return "cpy_person";
    }

    //未审核商家
    @GetMapping("cpyStore")
    public String unauditStores(Model model){
        model.addAttribute("unauditStores",storeService.getUnauditStores());
        return "cpy_store";
    }

    //未审核商品
    @GetMapping("cpyShop")
    public String unauditGoods(Model model){
        List<Goods> unauditGoods = goodsService.getUnauditGoods();
        model.addAttribute("unauditGoods",unauditGoods);
        return "cpy_shop";
    }

    //未审核套餐
    @GetMapping("cpyPack")
    public String unauditPacks(Model model){
        model.addAttribute("unauditGoods",goodsService.getUnauditGoods());
        return "cpy_pack";
    }

    @GetMapping("cpyCustom")
    public String toCpyCustom(){
        return "cpy_custom";
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