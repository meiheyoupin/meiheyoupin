package com.meiheyoupin.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.meiheyoupin.common.utils.R;
import com.meiheyoupin.common.utils.R1;
import com.meiheyoupin.entity.Refund;
import com.meiheyoupin.service.RefundService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RefundController {

    @Autowired
    RefundService refundService;

    /**
     * 根据退款单state遍历退款单（分页）
     * @param state     状态（非必需） 默认1（待审核）
     * @param pageNum       当前页码
     * @param pageSize      每页显示量
     * @return  code:200成功/500异常  msg异常信息
     */
    @RequiresRoles("admin")
    @GetMapping("refunds")
    public R refunds(@RequestParam(value = "state",defaultValue = "1",required = false) Integer state,
                     @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                     @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){
        try {
            PageHelper.startPage(pageNum,pageSize);
            return R.ok().put("refunds",new PageInfo<>(refundService.getRefundsByState(state)));
        }catch (Exception e){
            return R.error();
        }
    }

    /*
    退款单审核通过
     */
    @RequiresRoles("admin")
    @GetMapping("auditRefund")
    public R1 toAuditRefund(@RequestParam Integer id){
        try {
            refundService.modifyRefundById(id);
            return R1.success("审核退款单成功");
        }catch (Exception e ){
            return R1.error();
        }
    }


}
