package com.meiheyoupin.controller;


import com.meiheyoupin.service.SalerService;
import com.meiheyoupin.utils.R1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SalerController {

    @Autowired
    SalerService salerService;

    @GetMapping("salers")
    public R1 toSalers(){
        return R1.add("salers",salerService.getSaler());
    }
}
