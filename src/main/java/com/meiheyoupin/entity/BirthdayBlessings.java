package com.meiheyoupin.entity;

/**
 * @author vincent
 */
public class BirthdayBlessings {

    public static final String BIRTHDAY_DEFAULT_MSG = "Happy Birthday!";

    private Integer id;

    private String msg;

    private String companyCreditCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public String getCompanyCreditCode() {
        return companyCreditCode;
    }

    public void setCompanyCreditCode(String companyCreditCode) {
        this.companyCreditCode = companyCreditCode;
    }
}