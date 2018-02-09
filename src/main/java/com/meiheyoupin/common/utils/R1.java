package com.meiheyoupin.common.utils;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;


public class R1 extends HashMap<String,Object>{

    private static final long serialVersionUID = 1L;

    public R1(){
        put("code",HttpStatus.SC_OK);
    }

    public static R1 error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static R1 error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static R1 error(int code, String msg){
        R1 r1 = new R1();
        r1.put("code",code);
        r1.put("msg",msg);
        return r1;
    }

    public static R1 success(String msg){
        R1 r1 = new R1();
        r1.put("msg", msg);
        return r1;
    }

    public static R1 success(int code,String msg){
        R1 r1 = new R1();
        r1.put("code",code);
        r1.put("msg",msg);
        return r1;
    }

    public static R1 ok(Map<String,Object> map){
        R1 r1 = new R1();
        r1.putAll(map);
        return r1;
    }

    public static R1 ok(){
        return new R1();
    }

    public static R1 add(String key,Object value){
        R1 r1 = new R1();
        r1.put(key,value);
        r1.ok(r1);
        return r1;
    }

    public R1 put(String key,Object value){
        super.put(key,value);
        return this;
    }
}
