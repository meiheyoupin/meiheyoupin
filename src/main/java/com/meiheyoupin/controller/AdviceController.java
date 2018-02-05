package com.meiheyoupin.controller;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceController {

    @ExceptionHandler(value = {
            AuthorizationException.class
    })
    public String ExceptionHandle(){
        return "no_authority";
    }

}
