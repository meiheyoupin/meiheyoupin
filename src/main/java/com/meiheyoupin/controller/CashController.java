package com.meiheyoupin.controller;

import com.meiheyoupin.service.StoreOrdersService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author vincent
 */
@Controller
public class CashController {

    @Autowired
    StoreOrdersService storeOrdersService;

    @RequiresRoles("admin")
    @GetMapping("cpyCharges")
    public String toWithdrawCashes(Model model){
        model.addAttribute("withdrawCashes",storeOrdersService.getWithdrawCash());
        return "cpy_charges";
    }
}
