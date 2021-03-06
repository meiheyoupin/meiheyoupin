package com.meiheyoupin.controller;


import com.meiheyoupin.service.TokenService;
import com.meiheyoupin.service.UserAdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.meiheyoupin.entity.UserAdmin.ADMINUSER_ROLE_ADMIN;
import static com.meiheyoupin.entity.UserAdmin.ADMINUSER_ROLE_SALER;

/**
 * @author vincent
 */
@Controller
public class AdminController {


    @Autowired
    UserAdminService userAdminService;

    @Autowired
    TokenService tokenService;

    @GetMapping("/adminLogin")
    public String platformLogin(@RequestParam("adminName") String adminName,
                            @RequestParam("adminPassword") String adminPassword,
                            Model model){
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()){
            String msg = "";
            UsernamePasswordToken token = new UsernamePasswordToken(adminName,adminPassword);
            try {
                subject.login(token);
                model.addAttribute("userName",adminName);
                if (subject.hasRole(ADMINUSER_ROLE_ADMIN)){
                    return "forward:/cpySaler";
                }else if (subject.hasRole(ADMINUSER_ROLE_SALER)){
                    return "redirect:/toSaler";
                }
            } catch (UnknownAccountException uae){
                msg = "没有用户名为"+token.getPrincipal()+"的用户";
                System.out.println(msg);
                model.addAttribute("msg",msg);
            } catch (IncorrectCredentialsException ice){
                msg = "用户名为："+token.getPrincipal()+"的用户密码不正确";
                System.out.println(msg);
                model.addAttribute("msg",msg);
            } catch (LockedAccountException lae){
                msg = "用户名为："+token.getPrincipal()+"的用户已被冻结";
                System.out.println(msg);
                model.addAttribute("msg",msg);
            } catch (AuthenticationException e){
                msg = "未知错误！";
                System.out.println(msg);
                model.addAttribute("msg",msg);
            }
        }
        return "redirect:/logout";
    }
}
