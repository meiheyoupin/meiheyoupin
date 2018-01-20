package com.meiheyoupin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.meiheyoupin.common.R1;
import com.meiheyoupin.entity.Store;
import com.meiheyoupin.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StoreController {

    @Autowired
    StoreService storeService;

    @GetMapping("auditStores")
    @ResponseBody
    public R1 toAuditStores(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Store> list = storeService.getStoresByState(1);
        PageInfo<Store> pageInfo = new PageInfo<Store>(list);
        return R1.add("auditStores",pageInfo);
    }
}
