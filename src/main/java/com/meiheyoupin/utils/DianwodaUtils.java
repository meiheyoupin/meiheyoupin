package com.meiheyoupin.utils;


import com.meiheyoupin.common.utils.SHA1Utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class DianwodaUtils {

    private static final String appSecret = "8da01c8e262543ef617fd7c0171b9bdb";
    private static final String appKey = "10140";

    //测试url
    private static final String ADD_ORDER_URL = "http://60.191.68.46:43580/api/v3/order-send.json";

    /*
    第一步：
    生成签名
    传入业务参数requestMap
     */
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

        //SHA-1加密
        String sign = SHA1Utils.encode(appSecret + signStr.toString() + appSecret);
        return sign.toUpperCase();
    }

    /*
    第二步：
    根据业务需求按照文档构造请求参数
     */
    public static Map<String, Object> getRequestParam(String sign) {
        Map<String, Object> paramMap = new HashMap<>();
        /*
        系统参数
         */
        paramMap.put("pk", appKey);
        paramMap.put("format", "json");
        paramMap.put("timestamp", System.currentTimeMillis());
        paramMap.put("sig", sign);

        return paramMap;
    }


    //提交器
    /*public static String sendPost(String urlStr, Map requestMap) {
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
            httpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            //建立输入流，向指向的URL传入参数
            DataOutputStream dos = new DataOutputStream(httpConn.getOutputStream());
            dos.write(requestMap);
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
    }*/

    //执行函数
    public static void main(String[] args) {
        Map map = new HashMap();
        String sign = getSign(map);
        Map map1 = getRequestParam(sign);
        //String response = sendPost(ADD_ORDER_URL,);
    }
}
