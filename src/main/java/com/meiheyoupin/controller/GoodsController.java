package com.meiheyoupin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.meiheyoupin.common.utils.R1;
import com.meiheyoupin.entity.Goods;
import com.meiheyoupin.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    /*
    根据套餐状态拿到套餐（分页）
     */
    @GetMapping("/goods")
    public R1 goods(@RequestParam(value = "1") Integer state,
                    @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                    @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){
        try {
            PageHelper.startPage(pageNum,pageSize);
            List<Goods> list = goodsService.getGoodsByState(state);
            PageInfo<Goods> pageInfo = new PageInfo<Goods>(list);
            return R1.add("goods",pageInfo);
        }catch (Exception e){
            return R1.error(500,"服务器内部错误");
        }
    }

    /*
    修改套餐
     */
    @PostMapping("goods")
    public R1 goods(@RequestBody Goods goods){
        try {
            goodsService.modifyGoods(goods);
            return R1.success(200,"修改套餐成功");
        }catch (Exception e){
            return R1.error(500,"服务器内部错误");
        }
    }

    /*
    删除套餐
     */
    @DeleteMapping("goods")
    public R1 goods(@RequestParam Integer goodId){
        try {
            goodsService.removeGoods(goodId);
            return R1.success(200,"删除套餐成功");
        }catch (Exception e){
            return R1.error(500,"服务器内部错误");
        }
    }
}
