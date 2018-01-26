package com.meiheyoupin.controller;


import com.meiheyoupin.entity.UserAdmin;
import com.meiheyoupin.service.TokenService;
import com.meiheyoupin.service.UserAdminService;
import com.meiheyoupin.common.R1;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AdminController {


    @Autowired
    UserAdminService userAdminService;

    @Autowired
    TokenService tokenService;

    /*@PostMapping("adminLogin")
    @ResponseBody
    public R1 platformLogin(@RequestParam("adminName") String adminName, @RequestParam("adminPassword") String adminPassword){
        tokenService.checkExpire();
        UserAdmin userAdmin = userAdminService.getUserByPassword(new UserAdmin(adminName,adminPassword));
        if(userAdmin!=null){
            return R1.ok(tokenService.createToken(userAdmin));
        }
        return R1.error(404,"账号密码不正确");
    }*/

    @GetMapping("/adminLogin")
    public String platformLogin(@RequestParam("adminName") String adminName,
                            @RequestParam("adminPassword") String adminPassword,
                            Model model){
        tokenService.checkExpire();
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()==false){
            String msg = "";
            UsernamePasswordToken token = new UsernamePasswordToken(adminName,adminPassword);
            try {
                subject.login(token);
                model.addAttribute("userName",adminName);
                return "cpy_saler";
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
