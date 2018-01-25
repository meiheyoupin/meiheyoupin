package com.meiheyoupin.controller;


import com.meiheyoupin.entity.UserAdmin;
import com.meiheyoupin.service.TokenService;
import com.meiheyoupin.service.UserAdminService;
import com.meiheyoupin.common.R1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class AdminController {

    @Autowired
    UserAdminService userAdminService;

    @Autowired
    TokenService tokenService;

    @PostMapping("adminLogin")
    @ResponseBody
    public R1 platformLogin(@RequestParam("adminName") String adminName, @RequestParam("adminPassword") String adminPassword){
        tokenService.checkExpire();
        UserAdmin userAdmin = userAdminService.getUserByPassword(new UserAdmin(adminName,adminPassword));
        if(userAdmin!=null){
            return R1.ok(tokenService.createToken(userAdmin));
        }
        return R1.error(404,"账号密码不正确");
    }


}
