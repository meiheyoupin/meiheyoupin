package com.meiheyoupin.entity;

/**
 * @author vincent
 */
public class Store {
    private Integer id;
    private String invitationCode;
    private String address;
    private Double lng;
    private String storeInsidePhotoUrl;
    private java.util.Date createTime;
    private String description;
    private Integer bossGender;
    private String bossName;
    private String password;
    private java.util.Date updateTime;
    private String avatarUrl;
    private String bossIdcardPhotoUrl;
    private Integer businessType;
    private String name;
    private String certificatePhotoUrl;
    private String tel;
    private Integer state;
    private String storeLicencePhotoUrl;
    private String storeOutsidePhotoUrl;
    private String email;
    private Double lat;

    private String verificationCode;
    private String storeInsidePhotoUrl1;
    private String storeInsidePhotoUrl2;
    private String bossIdcardPhotoUrl1;
    private String bossIdcardPhotoUrl2;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInvitationCode() {
        return this.invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLng() {
        return this.lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getStoreInsidePhotoUrl() {
        return this.storeInsidePhotoUrl;
    }

    public void setStoreInsidePhotoUrl(String storeInsidePhotoUrl) {
        this.storeInsidePhotoUrl = storeInsidePhotoUrl;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getBossGender() {
        return this.bossGender;
    }

    public void setBossGender(Integer bossGender) {
        this.bossGender = bossGender;
    }

    public String getBossName() {
        return this.bossName;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getBossIdcardPhotoUrl() {
        return this.bossIdcardPhotoUrl;
    }

    public void setBossIdcardPhotoUrl(String bossIdcardPhotoUrl) {
        this.bossIdcardPhotoUrl = bossIdcardPhotoUrl;
    }

    public Integer getBusinessType() {
        return this.businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCertificatePhotoUrl() {
        return this.certificatePhotoUrl;
    }

    public void setCertificatePhotoUrl(String certificatePhotoUrl) {
        this.certificatePhotoUrl = certificatePhotoUrl;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getState() {
        return this.state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getStoreLicencePhotoUrl() {
        return this.storeLicencePhotoUrl;
    }

    public void setStoreLicencePhotoUrl(String storeLicencePhotoUrl) {
        this.storeLicencePhotoUrl = storeLicencePhotoUrl;
    }

    public String getStoreOutsidePhotoUrl() {
        return this.storeOutsidePhotoUrl;
    }

    public void setStoreOutsidePhotoUrl(String storeOutsidePhotoUrl) {
        this.storeOutsidePhotoUrl = storeOutsidePhotoUrl;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getLat() {
        return this.lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getStoreInsidePhotoUrl1() {
        return storeInsidePhotoUrl1;
    }

    public void setStoreInsidePhotoUrl1(String storeInsidePhotoUrl1) {
        this.storeInsidePhotoUrl1 = storeInsidePhotoUrl1;
    }

    public String getStoreInsidePhotoUrl2() {
        return storeInsidePhotoUrl2;
    }

    public void setStoreInsidePhotoUrl2(String storeInsidePhotoUrl2) {
        this.storeInsidePhotoUrl2 = storeInsidePhotoUrl2;
    }

    public String getBossIdcardPhotoUrl1() {
        return bossIdcardPhotoUrl1;
    }

    public void setBossIdcardPhotoUrl1(String bossIdcardPhotoUrl1) {
        this.bossIdcardPhotoUrl1 = bossIdcardPhotoUrl1;
    }

    public String getBossIdcardPhotoUrl2() {
        return bossIdcardPhotoUrl2;
    }

    public void setBossIdcardPhotoUrl2(String bossIdcardPhotoUrl2) {
        this.bossIdcardPhotoUrl2 = bossIdcardPhotoUrl2;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", invitationCode='" + invitationCode + '\'' +
                ", address='" + address + '\'' +
                ", lng=" + lng +
                ", storeInsidePhotoUrl='" + storeInsidePhotoUrl + '\'' +
                ", createTime=" + createTime +
                ", description='" + description + '\'' +
                ", bossGender=" + bossGender +
                ", bossName='" + bossName + '\'' +
                ", password='" + password + '\'' +
                ", updateTime=" + updateTime +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", bossIdcardPhotoUrl='" + bossIdcardPhotoUrl + '\'' +
                ", businessType=" + businessType +
                ", name='" + name + '\'' +
                ", certificatePhotoUrl='" + certificatePhotoUrl + '\'' +
                ", tel='" + tel + '\'' +
                ", state=" + state +
                ", storeLicencePhotoUrl='" + storeLicencePhotoUrl + '\'' +
                ", storeOutsidePhotoUrl='" + storeOutsidePhotoUrl + '\'' +
                ", email='" + email + '\'' +
                ", lat=" + lat +
                ", verificationCode='" + verificationCode + '\'' +
                ", storeInsidePhotoUrl1='" + storeInsidePhotoUrl1 + '\'' +
                ", storeInsidePhotoUrl2='" + storeInsidePhotoUrl2 + '\'' +
                ", bossIdcardPhotoUrl1='" + bossIdcardPhotoUrl1 + '\'' +
                ", bossIdcardPhotoUrl2='" + bossIdcardPhotoUrl2 + '\'' +
                '}';
    }
}
