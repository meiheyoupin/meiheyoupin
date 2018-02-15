package com.meiheyoupin.controller;

import com.meiheyoupin.common.utils.R1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogController {
    @GetMapping("/lxterror")
    public R1 error(){
        try {
            log.error("error log success");
            return R1.success("ok");
        }catch (Exception e){
            return R1.ok();
        }
    }

    @GetMapping("/lxtinfo")
    public R1 info(){
        try {
            log.info("info log success");
            return R1.success("ok");
        }catch (Exception e){
            return R1.ok();
        }
    }
}
