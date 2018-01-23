package com.meiheyoupin.common;

import com.meiheyoupin.common.login.WXLoginUtils;

import static com.meiheyoupin.common.login.WXLoginUtils.toGet;


public class test {
    public static void main(String[] args) {
        String res = WXLoginUtils.getCodeApi("meiheyoupin.com");
        String str = toGet(res);
        System.out.println(str);
    }
}
