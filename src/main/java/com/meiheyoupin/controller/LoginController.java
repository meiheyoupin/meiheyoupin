package com.meiheyoupin.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping(value = "login")
    public String testLogin(@RequestParam("username")String username,
                            @RequestParam("password")String password,
                            Model model){
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()==false){
            String msg = "";
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            try {
                subject.login(token);
                return "shiro/toSuccess";
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
        return "shiro/toError";
    }

    @GetMapping("toLogin")
    public String toLogin(){
        return "shiro/toLogin";
    }
}
