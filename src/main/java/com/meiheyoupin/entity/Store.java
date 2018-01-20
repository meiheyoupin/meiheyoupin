package com.meiheyoupin.entity;

import java.util.Date;

public class Store {
    private Integer id;

    private String tel;

    private String password;

    private Byte state;         //0：未审核，1：审核通过，2：审核未通过

    private String invitationCode;

    private String storeName;

    private String storeAddr;

    private String bossName;

    private Byte bossGender;

    private String avatarUrl;

    public Store(Integer id, String password) {
        this.id = id;
        this.password = password;
    }

    public Store() {
    }

    public Store(Integer id, String tel, String password, Byte state, String invitationCode, String storeName, String storeAddr, String bossName, Byte bossGender, String avatarUrl, String storeOutsidePhotoUrl, String storeInsidePhotoUrl, String bossIdcardPhotoUrl, String certificatePhotoUrl, String storeLicencePhotoUrl, Date createTime, Date updateTime) {
        this.id = id;
        this.tel = tel;
        this.password = password;
        this.state = state;
        this.invitationCode = invitationCode;
        this.storeName = storeName;
        this.storeAddr = storeAddr;
        this.bossName = bossName;
        this.bossGender = bossGender;
        this.avatarUrl = avatarUrl;
        this.storeOutsidePhotoUrl = storeOutsidePhotoUrl;
        this.storeInsidePhotoUrl = storeInsidePhotoUrl;
        this.bossIdcardPhotoUrl = bossIdcardPhotoUrl;
        this.certificatePhotoUrl = certificatePhotoUrl;
        this.storeLicencePhotoUrl = storeLicencePhotoUrl;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    private String storeOutsidePhotoUrl;

    private String storeInsidePhotoUrl;

    private String bossIdcardPhotoUrl;

    private String certificatePhotoUrl;

    private String storeLicencePhotoUrl;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode == null ? null : invitationCode.trim();
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public String getStoreAddr() {
        return storeAddr;
    }

    public void setStoreAddr(String storeAddr) {
        this.storeAddr = storeAddr == null ? null : storeAddr.trim();
    }

    public String getBossName() {
        return bossName;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName == null ? null : bossName.trim();
    }

    public Byte getBossGender() {
        return bossGender;
    }

    public void setBossGender(Byte bossGender) {
        this.bossGender = bossGender;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    public String getStoreOutsidePhotoUrl() {
        return storeOutsidePhotoUrl;
    }

    public void setStoreOutsidePhotoUrl(String storeOutsidePhotoUrl) {
        this.storeOutsidePhotoUrl = storeOutsidePhotoUrl == null ? null : storeOutsidePhotoUrl.trim();
    }

    public String getStoreInsidePhotoUrl() {
        return storeInsidePhotoUrl;
    }

    public void setStoreInsidePhotoUrl(String storeInsidePhotoUrl) {
        this.storeInsidePhotoUrl = storeInsidePhotoUrl == null ? null : storeInsidePhotoUrl.trim();
    }

    public String getBossIdcardPhotoUrl() {
        return bossIdcardPhotoUrl;
    }

    public void setBossIdcardPhotoUrl(String bossIdcardPhotoUrl) {
        this.bossIdcardPhotoUrl = bossIdcardPhotoUrl == null ? null : bossIdcardPhotoUrl.trim();
    }

    public String getCertificatePhotoUrl() {
        return certificatePhotoUrl;
    }

    public void setCertificatePhotoUrl(String certificatePhotoUrl) {
        this.certificatePhotoUrl = certificatePhotoUrl == null ? null : certificatePhotoUrl.trim();
    }

    public String getStoreLicencePhotoUrl() {
        return storeLicencePhotoUrl;
    }

    public void setStoreLicencePhotoUrl(String storeLicencePhotoUrl) {
        this.storeLicencePhotoUrl = storeLicencePhotoUrl == null ? null : storeLicencePhotoUrl.trim();
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
}