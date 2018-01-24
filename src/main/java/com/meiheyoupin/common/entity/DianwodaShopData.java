package com.meiheyoupin.common.entity;

/**
 * Created by w2tto on 2018/1/23.
 */
public class DianwodaShopData {

    private String city_code;
    private String external_shopid;
    private String shop_title;
    private String mobile;
    private Long lng;
    private Long lat;
    private String addr;

    public DianwodaShopData(String city_code, String external_shopid, String shop_title, String mobile, Long lng, Long lat, String addr) {
        this.city_code = city_code;
        this.external_shopid = external_shopid;
        this.shop_title = shop_title;
        this.mobile = mobile;
        this.lng = lng;
        this.lat = lat;
        this.addr = addr;
    }

    public DianwodaShopData() {
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public String getExternal_shopid() {
        return external_shopid;
    }

    public void setExternal_shopid(String external_shopid) {
        this.external_shopid = external_shopid;
    }

    public String getShop_title() {
        return shop_title;
    }

    public void setShop_title(String shop_title) {
        this.shop_title = shop_title;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getLng() {
        return lng;
    }

    public void setLng(Long lng) {
        this.lng = lng;
    }

    public Long getLat() {
        return lat;
    }

    public void setLat(Long lat) {
        this.lat = lat;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
