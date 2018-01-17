package com.meiheyoupin.entity;

import java.util.Date;

public class Region {
    private Long regionId;

    private String regionName;

    private String regionCode;

    private Long parentRegionId;

    private Integer layer;

    private Integer orderId;

    private Integer zipPhone;

    private Integer regionPost;

    private String isCity;

    private String regionMask;

    private String regionBanner;

    private String regionIcon;

    private String regionBannerOld;

    private Integer regionOnlineTotal;

    private Integer regionOnlineToday;

    private Date regionOnlineDate;

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName == null ? null : regionName.trim();
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode == null ? null : regionCode.trim();
    }

    public Long getParentRegionId() {
        return parentRegionId;
    }

    public void setParentRegionId(Long parentRegionId) {
        this.parentRegionId = parentRegionId;
    }

    public Integer getLayer() {
        return layer;
    }

    public void setLayer(Integer layer) {
        this.layer = layer;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getZipPhone() {
        return zipPhone;
    }

    public void setZipPhone(Integer zipPhone) {
        this.zipPhone = zipPhone;
    }

    public Integer getRegionPost() {
        return regionPost;
    }

    public void setRegionPost(Integer regionPost) {
        this.regionPost = regionPost;
    }

    public String getIsCity() {
        return isCity;
    }

    public void setIsCity(String isCity) {
        this.isCity = isCity == null ? null : isCity.trim();
    }

    public String getRegionMask() {
        return regionMask;
    }

    public void setRegionMask(String regionMask) {
        this.regionMask = regionMask == null ? null : regionMask.trim();
    }

    public String getRegionBanner() {
        return regionBanner;
    }

    public void setRegionBanner(String regionBanner) {
        this.regionBanner = regionBanner == null ? null : regionBanner.trim();
    }

    public String getRegionIcon() {
        return regionIcon;
    }

    public void setRegionIcon(String regionIcon) {
        this.regionIcon = regionIcon == null ? null : regionIcon.trim();
    }

    public String getRegionBannerOld() {
        return regionBannerOld;
    }

    public void setRegionBannerOld(String regionBannerOld) {
        this.regionBannerOld = regionBannerOld == null ? null : regionBannerOld.trim();
    }

    public Integer getRegionOnlineTotal() {
        return regionOnlineTotal;
    }

    public void setRegionOnlineTotal(Integer regionOnlineTotal) {
        this.regionOnlineTotal = regionOnlineTotal;
    }

    public Integer getRegionOnlineToday() {
        return regionOnlineToday;
    }

    public void setRegionOnlineToday(Integer regionOnlineToday) {
        this.regionOnlineToday = regionOnlineToday;
    }

    public Date getRegionOnlineDate() {
        return regionOnlineDate;
    }

    public void setRegionOnlineDate(Date regionOnlineDate) {
        this.regionOnlineDate = regionOnlineDate;
    }
}