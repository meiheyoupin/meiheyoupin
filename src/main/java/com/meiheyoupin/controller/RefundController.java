package com.meiheyoupin.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.meiheyoupin.common.R1;
import com.meiheyoupin.entity.Refund;
import com.meiheyoupin.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RefundController {

    @Autowired
    RefundService refundService;

    /*
    根据退款订单状态拿到退单
     */
    @GetMapping("refunds")
    public R1 refunds(@RequestParam Integer state,
                      @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                      @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){
        try {
            PageHelper.startPage(pageNum,pageSize);
            List<Refund> list = refundService.getRefundsByState(state);
            PageInfo<Refund> pageInfo = new PageInfo<Refund>(list);
            return R1.add("refunds",pageInfo);
        }catch (Exception e ){
            return R1.error(500,"服务器内部错误");
        }
    }

    /*
    退款单审核通过
     */
    @GetMapping("auditRefund")
    public R1 toAuditRefund(@RequestParam Integer id){
        try {
            refundService.modifyRefundById(id);
            return R1.success(200,"审核退款单成功");
        }catch (Exception e ){
            return R1.error(500,"服务器内部错误");
        }
    }


}
