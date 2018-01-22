package com.meiheyoupin.common;

import com.meiheyoupin.common.login.WXLogin;

/**
 * Created by w2tto on 2018/1/22.
 */
public class test {
    public static void main(String[] args) {
        String res = WXLogin.toGetUri("meiheyoupin.com");
        WXLogin.toGetCode(res);
    }
}
