package com.meiheyoupin.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/admin")
    public String admin(){
        return "login";
    }

}
