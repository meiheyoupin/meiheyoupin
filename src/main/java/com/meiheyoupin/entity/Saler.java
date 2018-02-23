package com.meiheyoupin.entity;

import java.util.Date;

/**
 * @author vincent
 */
public class Saler extends SalerKey {

    private Integer id;

    private String name;

    private String password;

    private String invitationCode;

    private String tel;

    private Integer sex;

    private Date createTime;

    private Date updateTime;

    private Integer boss;

    public Saler() {
    }

    public Saler(String name, String tel, Integer sex, Integer boss) {
        this.name = name;
        this.tel = tel;
        this.sex = sex;
        this.boss = boss;
    }

    public Saler(String name, String invitationCode, String tel, Integer sex, Date createTime, Date updateTime, Integer boss) {
        this.name = name;
        this.invitationCode = invitationCode;
        this.tel = tel;
        this.sex = sex;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.boss = boss;
    }

    public Saler(String name, String password, String invitationCode, String tel, Integer sex, Date createTime, Date updateTime, Integer boss) {
        this.name = name;
        this.password = password;
        this.invitationCode = invitationCode;
        this.tel = tel;
        this.sex = sex;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.boss = boss;
    }

    public Saler(Integer id, String name, String invitationCode, String tel, Integer sex, Date createTime, Date updateTime, Integer boss) {
        this.id = id;
        this.name = name;
        this.invitationCode = invitationCode;
        this.tel = tel;
        this.sex = sex;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.boss = boss;
    }

    public Saler(Integer id, String name, String password, String invitationCode, String tel, Integer sex, Date createTime, Date updateTime, Integer boss) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.invitationCode = invitationCode;
        this.tel = tel;
        this.sex = sex;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.boss = boss;
    }

    @Override
    public String getInvitationCode() {
        return invitationCode;
    }

    @Override
    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
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

    public Integer getBoss() {
        return boss;
    }

    public void setBoss(Integer boss) {
        this.boss = boss;
    }
}