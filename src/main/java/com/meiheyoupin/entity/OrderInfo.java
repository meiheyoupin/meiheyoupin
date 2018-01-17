package com.meiheyoupin.entity;



public class OrderInfo {

    private String shop_no;     //门店编号，门店创建后可在门店列表和单页查看
    private String origin_id;       //第三方订单ID
    private String city_code;       //订单所在城市的code（查看各城市对应的code值）
    private Double cargo_price;     //订单金额
    private Integer is_prepay;      //是否需要垫付 1:是 0:否 (垫付订单金额，非运费)
    private Long expected_fetch_time;       //期望取货时间（1.时间戳,以秒计算时间，即unix-timestamp; 2.该字段的设定，不会影响达达正常取货; 3.订单待接单时,该时间往后推半小时后，会自动被系统取消;4.建议取值为当前时间往后推10~15分钟）
    private String receiver_name;       //收货人姓名
    private String receiver_address;        //收货人地址
    private Double receiver_lat;        //收货人地址维度（高德坐标系）
    private Double receiver_lng;        //收货人地址经度（高德坐标系）
    private String callback;        //回调URL（查看回调说明）

    /*
    非必需
     */
    private String receiver_phone;      //收货人手机号（手机号和座机号必填一项）
    private String receiver_tel;        //收货人座机号（手机号和座机号必填一项）
    private Double tips;        //小费（单位：元，精确小数点后一位）
    private String info;        //订单备注
    private Integer cargo_type;         //订单商品类型：食品小吃-1,饮料-2,鲜花-3,文印票务-8,便利店-9,水果生鲜-13,同城电商-19, 医药-20,蛋糕-21,酒品-24,小商品市场-25,服装-26,汽修零配-27,数码-28,小龙虾-29, 其他-5
    private Double cargo_weight;        //订单重量（单位：Kg）
    private Integer cargo_num;      //订单商品数量
    private String invoice_title;       //发票抬头
    private String deliver_locker_code;     //送货开箱码
    private String pickup_locker_code;      //取货开箱码
    private String origin_mark;         //	订单来源标示（该字段可以显示在达达app订单详情页面，只支持字母，最大长度为10）
    private String origin_mark_no;      //订单来源编号（该字段可以显示在达达app订单详情页面，支持字母和数字，最大长度为30）
    private Integer insurance_fee;      //商品保价费(当商品出现损坏，可获取一定金额的赔付)
    private Integer is_finish_code_needed;      //收货码（0：不需要；1：需要。收货码的作用是：骑手必须输入收货码才能完成订单妥投）
    private Integer delay_publish_time;     //预约发单时间（预约时间unix时间戳(10位),精确到分;整10分钟为间隔，并且需要至少提前20分钟预约。）

    public OrderInfo() {
    }

    public OrderInfo(String shop_no, String origin_id, String city_code, Double cargo_price, Integer is_prepay, Long expected_fetch_time, String receiver_name, String receiver_address, Double receiver_lat, Double receiver_lng, String callback) {
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

    public OrderInfo(String shop_no, String origin_id, String city_code, Double cargo_price, Integer is_prepay, Long expected_fetch_time, String receiver_name, String receiver_address, Double receiver_lat, Double receiver_lng, String callback, Integer insurance_fee) {
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

    public OrderInfo(String shop_no, String origin_id, String city_code, Double cargo_price, Integer is_prepay, Long expected_fetch_time, String receiver_name, String receiver_address, Double receiver_lat, Double receiver_lng, String callback, String receiver_phone, String receiver_tel, Double tips, String info, Integer cargo_type, Double cargo_weight, Integer cargo_num, String invoice_title, String deliver_locker_code, String pickup_locker_code, String origin_mark, String origin_mark_no, Integer insurance_fee, Integer is_finish_code_needed, Integer delay_publish_time) {
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
