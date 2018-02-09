package com.meiheyoupin.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.meiheyoupin.common.utils.R;
import com.meiheyoupin.common.utils.R1;
import com.meiheyoupin.entity.Refund;
import com.meiheyoupin.service.RefundService;
import io.swagger.models.auth.In;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    /**
     * 审核退款单通过
     * @param id 退款单ID
     * @return  code:200成功/500失败    msg:异常信息
     */
    @RequiresRoles("admin")
    @PostMapping("auditRefund")
    public R1 toAuditRefund(@RequestParam Integer id){
        int res = refundService.auditRefund(id);
        if ( res > 0){
            return R1.success("退款单已通过审核");
        }else if (res == -1){
            return R1.error("第三方申请退款失败");
        }
        return R1.error();
    }

    /**
     * 审核退款单不通过
     * @param id 审核单ID
     * @return  code:200成功/500失败    msg:异常信息
     */
    @RequiresRoles("admin")
    @PostMapping("unauditRefund")
    public R1 toUnauditRefund(@RequestParam Integer id,
                              @RequestParam String reason){
        if (refundService.unAuditRefund(id,reason)>0){
            return R1.success("审核未通过处理成功");
        }
        return R1.error();
    }

}
