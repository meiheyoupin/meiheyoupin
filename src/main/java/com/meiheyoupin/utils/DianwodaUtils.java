package com.meiheyoupin.utils;


import com.alibaba.fastjson.JSON;
import com.meiheyoupin.common.entity.DianwodaResponseData;
import com.meiheyoupin.common.utils.SHA1Utils;
import okhttp3.*;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class DianwodaUtils {

    private static final String appSecret = "8da01c8e262543ef617fd7c0171b9bdb";
    private static final String appKey = "10140";

    //派送订单测试url
    private static final String ADD_ORDER_URL = "http://60.191.68.46:43580/api/v3/order-send.json";

    //订单详情测试url
    private static final String DETAILS_ORDER_URL = "http://60.191.68.46:43580/api/v3/order-get.json";

    //取消订单测试url
    private static final String CANCEL_ORDER_URL = "http://60.191.68.46:43580/api/v3/order-cancel.json";

    //修改订单测试url
    private static final String UPDATE_ORDER_URL = "http://60.191.68.46:43580/api/v3/order-update-remark.json";

    //派送员位置测试url
    private static final String LOCATION_COURIER_URL = "http://60.191.68.46:43580/api/v3/order-rider-position.json";

    //创建发货点测试url
    private static final String ADD_STORE_URL = "http://60.191.68.46:43580/api/v3/batchsave-store.json";

    //订单投诉测试url
    private static final String COMPLAIN_ORDER_URL = "http://60.191.68.46:43580/api/v3/order-complain.json";

    //查询订单投诉测试url
    private static final String GET_COMPLAIN_ORDER_URL = "http://60.191.68.46:43580/api/v3/order-get-complain.json";

    //查询订单投诉测试url
    private static final String TIP_ORDER_URL = "http://60.191.68.46:43580/api/v3/order-tip.json";

    //订单应收商家费用测试url
    private static final String ORDER_RECEIVABLE_PRICE_URL = "http://60.191.68.46:43580/api/v3/order-receivable-price.json";

    //商家确认已出餐测试url
    private static final String ORDER_MEAL_READY_URL = "http://60.191.68.46:43580/api/v3/order-meal-ready.json";


    /**
     * 向点我达开放平台发送请求
     * @param url 请求url
     * @param params 请求参数
     * @return 点我达开放平台给我们返回的数据
     */
    public static DianwodaResponseData doRequest(String url, Map<String, Object> params) {
        params = DianwodaUtils.appendCommonParam(params);
        try {
            String response = DianwodaUtils.sendPost(url, params);
            Logger.getLogger(DianwodaUtils.class).info(response);
            System.out.println("\n");
            return JSON.parseObject(response, DianwodaResponseData.class);
        } catch (IOException e) {
            return new DianwodaResponseData(false, "网络错误");
        }
    }

    /**
     * 生成签名
     */
    private static String generateSignature(Map<String, Object> param) {
        //请求参数键值升序排序
        Collection<String> keySet = param.keySet();
        List<String> list = new ArrayList<>(keySet);
        Collections.sort(list);

        //拼参数字符串。
        StringBuilder signStr = new StringBuilder();
        for (String key : list) {
            signStr.append(key).append(param.get(key));
        }

        //SHA-1加密
        String sign = SHA1Utils.encode(appSecret + signStr.toString() + appSecret);
        return sign.toUpperCase();
    }

    /**
     * 将公共参数附加进去
     */
    public static Map<String, Object> appendCommonParam(Map<String, Object> params) {
        params.put("sig", generateSignature(params));
        params.put("pk", appKey);
        params.put("format", "json");
        params.put("timestamp", System.currentTimeMillis());
        return params;
    }

    /**
     * 请求发送器
     */
    public static String sendPost(String url, Map<String, Object> param) throws IOException {
        OkHttpClient httpClient = new OkHttpClient.Builder().connectTimeout(1, TimeUnit.MINUTES).build();
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry entry : param.entrySet()) {
            builder.add(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
        }
        RequestBody requestBody = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .header("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8")
                .build();
        Response response = httpClient.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    //执行函数
    public static void main(String[] args) throws IOException {
        Map<String, Object> map = new HashMap<>();
//        map.put("order_original_id", "FTP211211091198");
//        map.put("order_create_time", new Date().getTime());
//        map.put("order_remark", "进门请按门铃");
//        map.put("order_price", 5000);
//        map.put("cargo_weight", 1000);
//        map.put("cargo_num", 1);
//        map.put("city_code", "330100");
//        map.put("seller_id", "123456");
//        map.put("seller_name", "肯德基宅急送（黄龙店）");
//        map.put("seller_mobile", "13986101111");
//        map.put("seller_address", "杭州市下城区白石路318号灯塔发展大厦A座");
//        map.put("seller_lat", 30.315408);
//        map.put("seller_lng", 120.165993);
//        map.put("consignee_name", "托尼·史塔克");
//        map.put("consignee_mobile", "13968041111");
//        map.put("consignee_address", "杭州市下城区西文街147号中粮方圆府");
//        map.put("consignee_lat", 30.315272);
//        map.put("consignee_lng", 120.168513);
//        map.put("money_rider_needpaid", 1);
//        map.put("money_rider_prepaid", 5000);
//        map.put("money_rider_charge", 5000);
//        map.put("time_waiting_at_seller", 300);
//        map.put("delivery_fee_from_seller", 500);

//        map.put("cancle_reason","用户取消订单");
//        map.put("order_info_content","客户的联系方式错了，正确的是13968011111");

//        map.put("rider_code","10088");
//        map.put("order_original_id","399103586");

//        map.put("shops", "[{\"addr\":\"长宁区长宁路820号\",\"city_code\":\"110100\",\"external_shopid\":\"3721970\",\"lat\":31218268,\"lng\":121417321,\"mobile\":\"18101944465\",\"shop_title\":\"南洋茶铺\"}]");
//        map.put("complain_source","");

//        map.put("complain_source",2);
//        map.put("complain_content","{\"code\": \"020489\",\"reason\":\"内容1\"，\"order_complain_original_id\":\"123456\"}");
//        map.put("complain_time",new Date().getTime());
//        map.put("order_complain_original_id",123456);
//        map.put("complain_type","020489");
//        map.put("tip",500);
        //map.put("time_ meal_ready",new Date().getTime());
//        map.put("time_ meal_ready",1517508122000L);
        map = appendCommonParam(map);
        System.out.println(sendPost(ORDER_MEAL_READY_URL, map));

    }
}
