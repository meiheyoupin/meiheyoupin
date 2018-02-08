package com.meiheyoupin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.meiheyoupin.common.utils.R;
import com.meiheyoupin.common.utils.R1;
import com.meiheyoupin.entity.Store;
import com.meiheyoupin.service.StoreService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StoreController {

    @Autowired
    StoreService storeService;

    @RequiresRoles("admin")
    @GetMapping("auditStores")
    @ResponseBody
    public R1 toAuditStores(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Store> list = storeService.getStoresByState(1);
        PageInfo<Store> pageInfo = new PageInfo<Store>(list);
        return R1.add("auditStores",pageInfo);
    }

    /*
    根据state拿到商铺s （分页）
     */
    @RequiresRoles("admin")
    @GetMapping("stores")
    public R1 stores(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                     @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize,
                     @RequestParam Integer state){
        try {
            PageHelper.startPage(pageNum,pageSize);
            List<Store> list = storeService.getStoresByState(state);
            PageInfo<Store> pageInfo = new PageInfo<Store>(list);
            return R1.add("stores",pageInfo);
        }catch (Exception e){
            return R1.error(500,"服务器内部错误");
        }
    }

    /*
    修改一个商铺
     */
    @RequiresRoles("admin")
    @PostMapping("store")
    public R1 updateStore(@RequestBody Store store){
        try {
            storeService.modifyStore(store);
            return R1.success(200,"商铺修改成功");
        }catch (Exception e){
            return R1.error(500,"服务器内部错误");
        }
    }

    /*
    根据邀请码拿到商家s
     */
    @RequiresRoles("saler")
    @GetMapping("salerStores")
    public R toSalerStores(@RequestParam String inviteCode){
        return R.ok(storeService.getStoresByInvitationCode(inviteCode));
    }
}
