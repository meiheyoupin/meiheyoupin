package com.meiheyoupin.entity;



public class orderInfo {
    private String shop_no;
    private String origin_id;
    private String city_code;
    private Double cargo_price;
    private Integer is_prepay;
    private Long expected_fetch_time;
    private String receiver_name;
    private String receiver_address;
    private Double receiver_lat;
    private Double receiver_lng;
    private String callback;
    private String receiver_phone;
    private String receiver_tel;
    private Double tips;
    private String info;
    private Integer cargo_type;
    private Double cargo_weight;
    private Integer cargo_num;
    private String invoice_title;
    private String deliver_locker_code;
    private String pickup_locker_code;
    private String origin_mark;
    private String origin_mark_no;
    private Integer insurance_fee;
    private Integer is_finish_code_needed;
    private Integer delay_publish_time;

    public orderInfo() {
    }

    public orderInfo(String shop_no, String origin_id, String city_code, Double cargo_price, Integer is_prepay, Long expected_fetch_time, String receiver_name, String receiver_address, Double receiver_lat, Double receiver_lng, String callback) {
        this.shop_no = shop_no;
        this.origin_id = origin_id;
        this.city_code = city_code;
        this.cargo_price = cargo_price;
        this.is_prepay = is_prepay;
        this.expected_fetch_time = expected_fetch_time;
        this.receiver_name = receiver_name;
        this.receiver_address = receiver_address;
        this.receiver_lat = receiver_lat;
        this.receiver_lng = receiver_lng;
        this.callback = callback;
    }

    public orderInfo(String shop_no, String origin_id, String city_code, Double cargo_price, Integer is_prepay, Long expected_fetch_time, String receiver_name, String receiver_address, Double receiver_lat, Double receiver_lng, String callback, Integer insurance_fee) {
        this.shop_no = shop_no;
        this.origin_id = origin_id;
        this.city_code = city_code;
        this.cargo_price = cargo_price;
        this.is_prepay = is_prepay;
        this.expected_fetch_time = expected_fetch_time;
        this.receiver_name = receiver_name;
        this.receiver_address = receiver_address;
        this.receiver_lat = receiver_lat;
        this.receiver_lng = receiver_lng;
        this.callback = callback;
        this.insurance_fee = insurance_fee;
    }

    public orderInfo(String shop_no, String origin_id, String city_code, Double cargo_price, Integer is_prepay, Long expected_fetch_time, String receiver_name, String receiver_address, Double receiver_lat, Double receiver_lng, String callback, String receiver_phone, String receiver_tel, Double tips, String info, Integer cargo_type, Double cargo_weight, Integer cargo_num, String invoice_title, String deliver_locker_code, String pickup_locker_code, String origin_mark, String origin_mark_no, Integer insurance_fee, Integer is_finish_code_needed, Integer delay_publish_time) {
        this.shop_no = shop_no;
        this.origin_id = origin_id;
        this.city_code = city_code;
        this.cargo_price = cargo_price;
        this.is_prepay = is_prepay;
        this.expected_fetch_time = expected_fetch_time;
        this.receiver_name = receiver_name;
        this.receiver_address = receiver_address;
        this.receiver_lat = receiver_lat;
        this.receiver_lng = receiver_lng;
        this.callback = callback;
        this.receiver_phone = receiver_phone;
        this.receiver_tel = receiver_tel;
        this.tips = tips;
        this.info = info;
        this.cargo_type = cargo_type;
        this.cargo_weight = cargo_weight;
        this.cargo_num = cargo_num;
        this.invoice_title = invoice_title;
        this.deliver_locker_code = deliver_locker_code;
        this.pickup_locker_code = pickup_locker_code;
        this.origin_mark = origin_mark;
        this.origin_mark_no = origin_mark_no;
        this.insurance_fee = insurance_fee;
        this.is_finish_code_needed = is_finish_code_needed;
        this.delay_publish_time = delay_publish_time;
    }

    @Override
    public String toString() {
        return "orderInfo{" +
                "shop_no='" + shop_no + '\'' +
                ", origin_id='" + origin_id + '\'' +
                ", city_code='" + city_code + '\'' +
                ", cargo_price=" + cargo_price +
                ", is_prepay=" + is_prepay +
                ", expected_fetch_time=" + expected_fetch_time +
                ", receiver_name='" + receiver_name + '\'' +
                ", receiver_address='" + receiver_address + '\'' +
                ", receiver_lat=" + receiver_lat +
                ", receiver_lng=" + receiver_lng +
                ", callback='" + callback + '\'' +
                ", receiver_phone='" + receiver_phone + '\'' +
                ", receiver_tel='" + receiver_tel + '\'' +
                ", tips=" + tips +
                ", info='" + info + '\'' +
                ", cargo_type=" + cargo_type +
                ", cargo_weight=" + cargo_weight +
                ", cargo_num=" + cargo_num +
                ", invoice_title='" + invoice_title + '\'' +
                ", deliver_locker_code='" + deliver_locker_code + '\'' +
                ", pickup_locker_code='" + pickup_locker_code + '\'' +
                ", origin_mark='" + origin_mark + '\'' +
                ", origin_mark_no='" + origin_mark_no + '\'' +
                ", insurance_fee=" + insurance_fee +
                ", is_finish_code_needed=" + is_finish_code_needed +
                ", delay_publish_time=" + delay_publish_time +
                '}';
    }

    public String getShop_no() {
        return shop_no;
    }

    public void setShop_no(String shop_no) {
        this.shop_no = shop_no;
    }

    public String getOrigin_id() {
        return origin_id;
    }

    public void setOrigin_id(String origin_id) {
        this.origin_id = origin_id;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public Double getCargo_price() {
        return cargo_price;
    }

    public void setCargo_price(Double cargo_price) {
        this.cargo_price = cargo_price;
    }

    public Integer getIs_prepay() {
        return is_prepay;
    }

    public void setIs_prepay(Integer is_prepay) {
        this.is_prepay = is_prepay;
    }

    public Long getExpected_fetch_time() {
        return expected_fetch_time;
    }

    public void setExpected_fetch_time(Long expected_fetch_time) {
        this.expected_fetch_time = expected_fetch_time;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public String getReceiver_address() {
        return receiver_address;
    }

    public void setReceiver_address(String receiver_address) {
        this.receiver_address = receiver_address;
    }

    public Double getReceiver_lat() {
        return receiver_lat;
    }

    public void setReceiver_lat(Double receiver_lat) {
        this.receiver_lat = receiver_lat;
    }

    public Double getReceiver_lng() {
        return receiver_lng;
    }

    public void setReceiver_lng(Double receiver_lng) {
        this.receiver_lng = receiver_lng;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public String getReceiver_phone() {
        return receiver_phone;
    }

    public void setReceiver_phone(String receiver_phone) {
        this.receiver_phone = receiver_phone;
    }

    public String getReceiver_tel() {
        return receiver_tel;
    }

    public void setReceiver_tel(String receiver_tel) {
        this.receiver_tel = receiver_tel;
    }

    public Double getTips() {
        return tips;
    }

    public void setTips(Double tips) {
        this.tips = tips;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getCargo_type() {
        return cargo_type;
    }

    public void setCargo_type(Integer cargo_type) {
        this.cargo_type = cargo_type;
    }

    public Double getCargo_weight() {
        return cargo_weight;
    }

    public void setCargo_weight(Double cargo_weight) {
        this.cargo_weight = cargo_weight;
    }

    public Integer getCargo_num() {
        return cargo_num;
    }

    public void setCargo_num(Integer cargo_num) {
        this.cargo_num = cargo_num;
    }

    public String getInvoice_title() {
        return invoice_title;
    }

    public void setInvoice_title(String invoice_title) {
        this.invoice_title = invoice_title;
    }

    public String getDeliver_locker_code() {
        return deliver_locker_code;
    }

    public void setDeliver_locker_code(String deliver_locker_code) {
        this.deliver_locker_code = deliver_locker_code;
    }

    public String getPickup_locker_code() {
        return pickup_locker_code;
    }

    public void setPickup_locker_code(String pickup_locker_code) {
        this.pickup_locker_code = pickup_locker_code;
    }

    public String getOrigin_mark() {
        return origin_mark;
    }

    public void setOrigin_mark(String origin_mark) {
        this.origin_mark = origin_mark;
    }

    public String getOrigin_mark_no() {
        return origin_mark_no;
    }

    public void setOrigin_mark_no(String origin_mark_no) {
        this.origin_mark_no = origin_mark_no;
    }

    public Integer getInsurance_fee() {
        return insurance_fee;
    }

    public void setInsurance_fee(Integer insurance_fee) {
        this.insurance_fee = insurance_fee;
    }

    public Integer getIs_finish_code_needed() {
        return is_finish_code_needed;
    }

    public void setIs_finish_code_needed(Integer is_finish_code_needed) {
        this.is_finish_code_needed = is_finish_code_needed;
    }

    public Integer getDelay_publish_time() {
        return delay_publish_time;
    }

    public void setDelay_publish_time(Integer delay_publish_time) {
        this.delay_publish_time = delay_publish_time;
    }
}
