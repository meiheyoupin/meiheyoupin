
package com.meiheyoupin.controller;

import com.meiheyoupin.service.GoodsService;
import com.meiheyoupin.service.StoreService;
import com.meiheyoupin.service.UserAdminService;
import com.meiheyoupin.utils.R1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("platform/")
public class PlatformController {

    @Autowired
    StoreService storeService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    UserAdminService userAdminService;

    @GetMapping("auditStores")
    public String toAuditStores(@RequestParam(value = "storeIds",required = false) Integer[] storeIds,Model model){
        try {
            storeService.autidStores(storeIds);
            model.addAttribute("unauditStores",storeService.getUnauditStores());
            return "cpy_store";
        }catch (Exception e){
            return "error";
        }
    }

    @GetMapping("auditGoods")
    public String toAuditGoods(@RequestParam(value = "goodIds",required = false) Integer[] goodIds,Model model){
        try {
            goodsService.auditGoods(goodIds);
            model.addAttribute("unauditGoods",goodsService.getUnauditGoods());
            return "admin/cpy_shop";
        }catch (Exception e){
            return "error";
        }
    }

    @GetMapping("administrator")
    public String getAdministrator(Model model){
        model.addAttribute("administrators",userAdminService.getUser());
        System.out.println(userAdminService.getUser().get(0).getUsername());
        return "admin/cpy_user";
    }


    //管理员
    @GetMapping("administrators")
    @ResponseBody
    public R1 getAdministrator(){
        return R1.add("administrators",userAdminService.getUser());
    }


    //商品
    @GetMapping("unauditGoods")
    @ResponseBody
    public R1 unauditGoods(){
        return R1.add("unauditGoods",goodsService.getUnauditGoods());
    }

    //商家
    @GetMapping("unauditStores")
    @ResponseBody
    public R1 unauditStores(){
        return R1.add("unauditStores",storeService.getUnauditStores());
    }
}

