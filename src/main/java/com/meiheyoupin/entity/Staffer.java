package com.meiheyoupin.entity;

import java.util.Date;

public class Staffer {
    private Integer id;

    private String name;

    private Integer sex;

    private String phone;

    private String companyCreditCode;

    private Date birthday;

    private String position;

    public String getCompanyCreditCode() {
        return companyCreditCode;
    }

    public void setCompanyCreditCode(String companyCreditCode) {
        this.companyCreditCode = companyCreditCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }
}