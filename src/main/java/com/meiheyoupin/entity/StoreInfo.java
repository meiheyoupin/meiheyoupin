package com.meiheyoupin.entity;


public class StoreInfo {

    private String station_name;
    private Integer business;
    private String city_name;
    private String area_name;
    private String station_address;
    private Double lng;
    private Double lat;
    private String contact_name;
    private String phone;

    private String origin_shop_id;
    private String id_card;
    private String username;
    private String password;

    public StoreInfo() {
    }

    public StoreInfo(String station_name, Integer business, String city_name, String area_name, String station_address, Double lng, Double lat, String contact_name, String phone) {
        this.station_name = station_name;
        this.business = business;
        this.city_name = city_name;
        this.area_name = area_name;
        this.station_address = station_address;
        this.lng = lng;
        this.lat = lat;
        this.contact_name = contact_name;
        this.phone = phone;
    }

    public StoreInfo(String station_name, Integer business, String city_name, String area_name, String station_address, Double lng, Double lat, String contact_name, String phone, String origin_shop_id, String id_card, String username, String password) {
        this.station_name = station_name;
        this.business = business;
        this.city_name = city_name;
        this.area_name = area_name;
        this.station_address = station_address;
        this.lng = lng;
        this.lat = lat;
        this.contact_name = contact_name;
        this.phone = phone;
        this.origin_shop_id = origin_shop_id;
        this.id_card = id_card;
        this.username = username;
        this.password = password;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public Integer getBusiness() {
        return business;
    }

    public void setBusiness(Integer business) {
        this.business = business;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public String getStation_address() {
        return station_address;
    }

    public void setStation_address(String station_address) {
        this.station_address = station_address;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOrigin_shop_id() {
        return origin_shop_id;
    }

    public void setOrigin_shop_id(String origin_shop_id) {
        this.origin_shop_id = origin_shop_id;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
