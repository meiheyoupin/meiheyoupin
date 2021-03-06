package com.meiheyoupin.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.meiheyoupin.entity.Saler;
import com.meiheyoupin.service.SalerService;
import com.meiheyoupin.common.utils.R1;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author vincent
 */
@Controller
public class SalerController {

    @Autowired
    SalerService salerService;

    /*
    拿到所有业务员
     */
    @RequiresRoles("admin")
    @GetMapping("salers")
    @ResponseBody
    public R1 getSalers(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                        @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Saler> list = salerService.getSalers();
        PageInfo<Saler> pageInfo = new PageInfo<Saler>(list);
        return R1.add("salers",pageInfo);
    }

    /*
    添加一个业务员
     */
    @RequiresRoles("admin")
    @PostMapping("saler")
    @ResponseBody
    public R1 insertSaler(@RequestBody Saler saler){
        try {
            salerService.addSaler(saler);
            return R1.success(201,"创建成功");
        }catch (Exception e){
            return R1.error();
        }
    }

    /*
    修改一个业务员
     */
    @RequiresRoles("admin")
    @PutMapping("saler")
    @ResponseBody
    public R1 updateSaler(@RequestBody Saler saler){
        try {
            salerService.putSaler(saler);
            return R1.success("修改成功");
        }catch (Exception e){
            return R1.error();
        }
    }

    /*
    删除一个业务员
     */
    @RequiresRoles("admin")
    @DeleteMapping("saler")
    @ResponseBody
    public R1 deleteSaler(@RequestParam Integer salerId){
        try {
            salerService.removeSaler(salerId);
            return R1.success("删除成功");
        }catch (Exception e){
            return R1.error();
        }
    }
}
