
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

    //商家审核通过
    @GetMapping("auditStores")
    @ResponseBody
    public R1 toAuditStores(@RequestParam(value = "storeIds",required = false) Integer[] storeIds,Model model){
        try {
            storeService.autidStores(storeIds);
            return R1.success(200,"请求成功");
        }catch (Exception e){
            return R1.error(500,"服务器内部错误");
        }
    }

    //商家审核未通过
    @GetMapping("unsanctionedStore")
    @ResponseBody
    public R1 toUnsanctionedStore(@RequestParam(value = "storeIds",required = false) Integer[] storeIds){
        try {
            storeService.unsanctionedStores(storeIds);
            return R1.success(200,"请求成功");
        }catch (Exception e){
            return R1.error(500,"服务器内部错误");
        }
    }

    //套餐审核通过
    @GetMapping("auditGoods")
    @ResponseBody
    public R1 toAuditGoods(@RequestParam(value = "goodIds",required = false) Integer[] goodIds){
        try {
            goodsService.auditGoods(goodIds);
            return R1.success(200,"请求成功");
        }catch (Exception e){
            return R1.error(500,"服务器内部错误");
        }
    }

    //套餐审核未通过
    @GetMapping("unsanctionedGood")
    @ResponseBody
    public R1 toUnsanctionedGood(@RequestParam(value = "goodIds",required = false) Integer[] goodIds){
        try {
            goodsService.unsanctionedGoods(goodIds);
            return R1.success(200,"请求成功");
        }catch (Exception e){
            return R1.error(500,"服务器内部错误");
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

