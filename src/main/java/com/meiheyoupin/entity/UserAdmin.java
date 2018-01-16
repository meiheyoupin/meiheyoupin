package com.meiheyoupin.entity;

import java.util.Date;

public class UserAdmin {
    private Integer id;

    private String username;

    private String password;

    private String role;

    private Integer inviteCode;

    private Integer tel;

    private Integer sex;

    private Date createTime;

    private Date updateTime;


    public UserAdmin() {
    }

    public UserAdmin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserAdmin(String username, String password, String role, Integer inviteCode, Integer tel, Integer sex, Date createTime) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.inviteCode = inviteCode;
        this.tel = tel;
        this.sex = sex;
        this.createTime = createTime;
    }

    public Integer getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(Integer inviteCode) {
        this.inviteCode = inviteCode;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }
}