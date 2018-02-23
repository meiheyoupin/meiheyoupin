package com.meiheyoupin.controller;

import com.meiheyoupin.common.utils.R;
import com.meiheyoupin.common.utils.R1;
import com.meiheyoupin.service.RefundService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.meiheyoupin.entity.UserAdmin.ADMINUSER_ROLE_ADMIN;

/**
 * @author vincent
 */
@Controller
public class RefundController {

    @Autowired
    private RefundService refundService;

    /**
     * 路由 / 获取需要审核的退款单
     * @param model
     */
    @RequiresRoles(ADMINUSER_ROLE_ADMIN)
    @GetMapping("refunds")
    public String refunds(Model model){
        model.addAttribute(refundService.getRefundsByState());
        return "refunds";
    }

    /**
     * 审核退款单通过
     * @param id 退款单ID
     * @return  code:200成功/500失败    msg:异常信息
     */
    @RequiresRoles(ADMINUSER_ROLE_ADMIN)
    @PostMapping("auditRefund")
    @ResponseBody
    public R1 toAuditRefund(@RequestParam Integer id){
        return R1.ok(refundService.auditRefund(id));
    }

    /**
     * 审核退款单不通过
     * @param id 审核单ID
     * @Param reason 不通过原因
     * @return  code:200成功/500失败    msg:异常信息
     */
    @RequiresRoles(ADMINUSER_ROLE_ADMIN)
    @PostMapping("unauditRefund")
    @ResponseBody
    public R toUnauditRefund(@RequestParam Integer id, @RequestParam String reason){
        return R.ok(refundService.unAuditRefund(id,reason));
    }

}
