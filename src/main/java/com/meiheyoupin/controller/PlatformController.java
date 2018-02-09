
package com.meiheyoupin.controller;

import com.meiheyoupin.service.GoodsService;
import com.meiheyoupin.service.StoreService;
import com.meiheyoupin.service.UserAdminService;
import com.meiheyoupin.common.utils.R1;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @RequiresRoles("admin")
    @GetMapping("auditStores")
    @ResponseBody
    public R1 toAuditStores(@RequestParam(value = "storeIds",required = false) Integer[] storeIds){
        try {
            storeService.autidStores(storeIds);
            return R1.success("请求成功");
        }catch (Exception e){
            return R1.error();
        }
    }

    //商家审核未通过
    @RequiresRoles("admin")
    @PostMapping("unsanctionedStore")
    @ResponseBody
    public R1 toUnsanctionedStore(@RequestParam(value = "storeIds",required = false) Integer[] storeIds,
                                  @RequestParam(value = "reason",required = false) String reason){
        try {
            storeService.unsanctionedStores(storeIds,reason);
            return R1.success("请求成功");
        }catch (Exception e){
            return R1.error();
        }
    }

    //套餐审核通过
    @RequiresRoles("admin")
    @GetMapping("auditGoods")
    @ResponseBody
    public R1 toAuditGoods(@RequestParam(value = "goodIds",required = false) Integer[] goodIds){
        try {
            goodsService.auditGoods(goodIds);
            return R1.success("请求成功");
        }catch (Exception e){
            return R1.error();
        }
    }

    //套餐审核未通过
    @RequiresRoles("admin")
    @PostMapping("unsanctionedGood")
    @ResponseBody
    public R1 toUnsanctionedGood(@RequestParam(value = "goodIds",required = false) Integer[] goodIds,
                                 @RequestParam(value = "reason",required = false) String reason){
        try {
            goodsService.unsanctionedGoods(goodIds,reason);
            return R1.success("请求成功");
        }catch (Exception e){
            return R1.error();
        }
    }

    //套餐下架
    @RequiresRoles("admin")
    @GetMapping("downGoods")
    @ResponseBody
    public R1 toDownGoods(@RequestParam(value = "goodIds",required = false) Integer[] goodIds){
        try {
            goodsService.downGoods(goodIds);
            return R1.success("选中套餐已下架");
        }catch (Exception e){
            return R1.error();
        }
    }

    //套餐上架
    @RequiresRoles("admin")
    @GetMapping("upGoods")
    @ResponseBody
    public R1 toUpGoods(@RequestParam(value = "goodIds",required = false) Integer[] goodIds){
        try {
            goodsService.upGoods(goodIds);
            return R1.success("选中套餐已上架");
        }catch (Exception e){
            return R1.error();
        }
    }

    /*@GetMapping("administrator")
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
    }*/
}

