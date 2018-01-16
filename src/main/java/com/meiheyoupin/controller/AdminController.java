package com.meiheyoupin.controller;


import com.meiheyoupin.entity.UserAdmin;
import com.meiheyoupin.service.GoodsService;
import com.meiheyoupin.service.StoreService;
import com.meiheyoupin.service.TokenService;
import com.meiheyoupin.service.UserAdminService;
import com.meiheyoupin.utils.R1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    @Autowired
    UserAdminService userAdminService;

    @Autowired
    TokenService tokenService;

    @Autowired
    StoreService storeService;

    @Autowired
    GoodsService goodsService;

    @PostMapping("adminLogin")
    @ResponseBody
    public R1 platformLogin(@RequestParam("adminName") String adminName, @RequestParam("adminPassword") String adminPassword){
        tokenService.checkExpire();
        UserAdmin userAdmin = userAdminService.getUserByPassword(new UserAdmin(adminName,adminPassword));
        if(userAdmin!=null){
            return R1.ok(tokenService.createToken(userAdmin));
        }
        return R1.error(404,"账号密码不正确");
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
        model.addAttribute("unauditGoods",goodsService.getUnauditGoods());
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

    @GetMapping("admin/toAdmin")
    public String toAdmin(){
        return "shiro/toAdmin";
    }

    @GetMapping("user/toUser")
    public String toUser(){
        return "shiro/toUser";
    }
}
