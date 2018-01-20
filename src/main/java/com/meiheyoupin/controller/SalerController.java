package com.meiheyoupin.controller;


import com.meiheyoupin.entity.Saler;
import com.meiheyoupin.service.SalerService;
import com.meiheyoupin.common.R1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("platform/")
public class SalerController {

    @Autowired
    SalerService salerService;

    /*
    拿到所有业务员
     */
    @GetMapping("salers")
    @ResponseBody
    public R1 getSalers(){
        return R1.add("salers",salerService.getSalers());
    }

    /*
    添加一个业务员
     */
    @PostMapping("saler")
    @ResponseBody
    public R1 insertSaler(@RequestBody Saler saler){
        try {
            salerService.addSaler(saler);
            return R1.success(201,"创建成功");
        }catch (Exception e){
            return R1.error(500,"服务器内部错误");
        }
    }

    /*
    修改一个业务员
     */
    @PutMapping("saler")
    @ResponseBody
    public R1 updateSaler(@RequestBody Saler saler){
        try {
            salerService.putSaler(saler);
            return R1.success(200,"修改成功");
        }catch (Exception e){
            return R1.error(500,"服务器内部错误");
        }
    }

    /*
    删除一个业务员
     */
    @DeleteMapping("saler")
    @ResponseBody
    public R1 deleteSaler(@RequestParam Integer salerId){
        try {
            salerService.removeSaler(salerId);
            return R1.success(200,"删除成功");
        }catch (Exception e){
            return R1.error(500,"服务器内部错误");
        }
    }
}
