package com.meiheyoupin.common.entity;



public class pojo {
    public String name;
    public String password;
    public String addr;

    public pojo() {
    }

    public pojo(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public pojo(String name, String password, String addr) {
        this.name = name;
        this.password = password;
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
