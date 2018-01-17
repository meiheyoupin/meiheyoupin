package com.meiheyoupin.utils;


import com.meiheyoupin.entity.StoreInfo;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class ImdadaStoreUtils {

    private static final String appKey = "dada85a86c579633e89";
    private static final String appSecret = "9acbd2d7755719045ee2f50bcdcd477d";

    //商家入驻url       测试
    private static final String ENTER_STORE_URL = "http://newopen.qa.imdada.cn/api/shop/add";

    //json 序列化使用,本示例使用jackson
    private static ObjectMapper mapper = new ObjectMapper();

    // 发送http请求，注意post请求方式，json数据格式，可以使用其他http工具
    public static String sendPost(String urlStr, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(urlStr);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            //设置参数
            httpConn.setDoOutput(true);   //需要输出
            httpConn.setDoInput(true);   //需要输入
            httpConn.setRequestMethod("POST");   //设置POST方式连接
            //设置请求属性
            httpConn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            //建立输入流，向指向的URL传入参数
            DataOutputStream dos = new DataOutputStream(httpConn.getOutputStream());
            dos.write(param.getBytes("utf-8"));
            dos.flush();
            dos.close();
            //获得响应状态
            int resultCode = httpConn.getResponseCode();
            if (HttpURLConnection.HTTP_OK == resultCode) {
                String readLine;
                BufferedReader responseReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
                while ((readLine = responseReader.readLine()) != null) {
                    result.append(readLine).append("\n");
                }
                responseReader.close();
            }
        } catch (Exception e) {
            result.append("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result.toString();
    }

    //根据业务需求按照文档构造请求参数
    public static Map<String, Object> getRequestParam(List storeInfo) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("body", toJson(storeInfo));  // 注意body是json字符串
        paramMap.put("format", "json");
        paramMap.put("timestamp", System.currentTimeMillis());
        paramMap.put("app_key", appKey);
        paramMap.put("v", "1.0");
        paramMap.put("source_id", 73753);
        return paramMap;
    }

    public static List toList(StoreInfo storeInfo){
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("station_name",storeInfo.getStation_name());
        map.put("business",storeInfo.getBusiness());
        map.put("city_name",storeInfo.getCity_name());
        map.put("area_name",storeInfo.getArea_name());
        map.put("station_address",storeInfo.getStation_address());
        map.put("lng",storeInfo.getLng());
        map.put("lat",storeInfo.getLat());
        map.put("contact_name",storeInfo.getContact_name());
        map.put("phone",storeInfo.getPhone());

//        map.put("origin_shop_id",storeInfo.getOrigin_shop_id());
//        map.put("id_card",storeInfo.getId_card());
//        map.put("username",storeInfo.getUsername());
//        map.put("password",storeInfo.getPassword());
        list.add(map);
        return list;
    }

    // json 序列化
    public static <T> String toJson(T src) {
        try {
            if (null != mapper) {
                if (src instanceof String) {
                    return (String) src;
                } else {
                    return mapper.writeValueAsString(src);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //生成签名
    public static String getSign(Map<String, Object> requestMap) {
        //请求参数键值升序排序
        Collection<String> keySet = requestMap.keySet();
        List<String> list = new ArrayList<>(keySet);
        Collections.sort(list);

        //拼参数字符串。
        StringBuffer signStr = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            String key = list.get(i);
            signStr.append(key + requestMap.get(key));
        }


        //MD5签名并校验
        String sign = encrypt(appSecret + signStr.toString() + appSecret);
        return sign.toUpperCase();
    }


    /*
     * MD5 加密
     */
    public static String encrypt(String inbuf) {
        String s = null;
        char hexDigits[] = { // 用来将字节转换成 16 进制表示的字符
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            md.update(inbuf.getBytes("UTF-8"));
            byte tmp[] = md.digest(); // MD5 的计算结果是一个 128 位的长整数，
            // 用字节表示就是 16 个字节
            char str[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符，
            // 所以表示成 16 进制需要 32 个字符
            int k = 0; // 表示转换结果中对应的字符位置
            for (int i = 0; i < 16; i++) { // 从第一个字节开始，对 MD5 的每一个字节
                // 转换成 16 进制字符的转换
                byte byte0 = tmp[i]; // 取第 i 个字节
                str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换,
                // >>> 为逻辑右移，将符号位一起右移
                str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
            }
            s = new String(str); // 换后的结果转换为字符串

        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;

    }
}
