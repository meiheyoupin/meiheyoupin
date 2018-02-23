package com.meiheyoupin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.meiheyoupin.common.utils.R1;
import com.meiheyoupin.entity.Goods;
import com.meiheyoupin.service.GoodsService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author vincent
 */
@RestController
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    /*
    根据套餐状态拿到套餐（分页）
     */
    @RequiresRoles("admin")
    @GetMapping("/goods")
    public R1 goods(@RequestParam(value = "1") Integer state,
                    @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                    @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){
        try {
            PageHelper.startPage(pageNum,pageSize);
            List<Map> list = goodsService.getCorrelationToGoodsByState(state);
            PageInfo<Map> pageInfo = new PageInfo<Map>(list);
            return R1.add("goods",pageInfo);
        }catch (Exception e){
            return R1.error();
        }
    }

    /*
    修改套餐
     */
    @RequiresRoles("admin")
    @PostMapping("goods")
    public R1 goods(@RequestBody Goods goods){
        try {
            goodsService.modifyGoods(goods);
            return R1.success("修改套餐成功");
        }catch (Exception e){
            return R1.error();
        }
    }

    /*
    删除套餐
     */
    @RequiresRoles("admin")
    @DeleteMapping("goods")
    public R1 goods(@RequestParam Integer goodId){
        try {
            goodsService.removeGoods(goodId);
            return R1.success("删除套餐成功");
        }catch (Exception e){
            return R1.error();
        }
    }
}
