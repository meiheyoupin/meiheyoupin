package com.meiheyoupin.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {


    @PostMapping(value = "login")
    public String testLogin(@RequestParam("username")String username, @RequestParam("password")String password){
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()==false){
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            try {
                subject.login(token);
            } catch (UnknownAccountException uae){
                System.out.println("没有用户名为"+token.getPrincipal()+"的用户");
            } catch (IncorrectCredentialsException ice){
                System.out.println("用户名为："+token.getPrincipal()+"的用户密码不正确");
            } catch (LockedAccountException lae){
                System.out.println("用户名为："+token.getPrincipal()+"的用户已被冻结");
            } catch (AuthenticationException e){
                System.out.println("未知错误！");
            }
        }
        return "index";
    }

    @GetMapping("toLogin")
    public String toLogin(){
        return "toLogin";
    }
}
