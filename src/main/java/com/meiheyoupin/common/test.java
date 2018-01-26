package com.meiheyoupin.common;

import com.meiheyoupin.common.login.WXLoginUtils;

import java.util.UUID;

import static com.meiheyoupin.common.login.WXLoginUtils.toGet;


public class test {
    public static void main(String[] args) {
        String password = UUID.randomUUID().toString().substring(0,8);
        System.out.println(password);
    }
}
