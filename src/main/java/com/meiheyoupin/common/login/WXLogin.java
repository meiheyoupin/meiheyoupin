package com.meiheyoupin.common.login;


import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URLEncoder;


public class WXLogin {

    //appId appSecret
    private static final String AppID = "wx4a300c4010f4be69";
    private static final String AppSecret = "66fb35add2f7242f24102a9380115abb";

    //getCodeApi url
    private static final String GET_CODE_URL = "https://open.weixin.qq.com/connect/qrconnect";

    //getAccess_token url
    private static final String GET_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";

    //refreshToken url
    private static final String REFRESH_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token";

    //checkToken url
    private static final String AVAILABLE_TOKEN_URL = "https://api.weixin.qq.com/sns/auth";

    //getUserInfo url
    private static final String GET_USERINFO_URL = "https://api.weixin.qq.com/sns/userinfo";

    //getCodeApi url
    public static String getCodeApi(String redirectUri){
        String res = "";
        try {
            res = URLEncoder.encode(redirectUri);
        }catch (Exception e){
            e.printStackTrace();
        }
        return GET_CODE_URL+"?appid="+AppID+"&redirect_uri="+res+"&response_type=code&scope=snsapi_login&state=2014#wechat_redirect";
    }

    //getAccess_token url
    public static String getTokenApi(String code){
        return GET_TOKEN_URL+"?appid="+AppID+"&secret="+AppSecret+"&code="+code+"&grant_type=authorization_code";
    }

    //refreshToken url
    public static String refreshTokenApi(String refreshToken){
        return REFRESH_TOKEN_URL+"?appid="+AppID+"&grant_type=refresh_token&refresh_token="+refreshToken;
    }

    //checkToken url
    public static String checkTokenApi(String accessToken,String openId){
        return AVAILABLE_TOKEN_URL+"?access_token="+accessToken+"&openid="+openId;
    }

    //getUserInfo url
    public static String getUserInfoApi(String accessToken,String openId){
        return GET_USERINFO_URL+"?access_token="+accessToken+"&openid="+openId;
    }

    public static void toGet(String uri){
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpget = new HttpGet(uri);
            // 执行get请求.
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                // 打印响应状态
                System.out.println(response.getStatusLine());
                if (entity != null) {
                    // 打印响应内容长度
                    System.out.println("Response content length: " + entity.getContentLength());
                    // 打印响应内容
                    System.out.println("Response content: " + EntityUtils.toString(entity));
                }
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        toGet(getCodeApi("meiheyoupin.com"));       //拿到code
        toGet(getTokenApi("code"));                  //通过code拿到access_token
        toGet(refreshTokenApi("refreshToken"));              //通过refresh_token刷新access_token
        toGet(checkTokenApi("accessToken","openId"));       //通过access_token和openid检查access_token是否还有效
        toGet(getUserInfoApi("accessToken","openId"));      //通过access_token和openid拿到用户信息，头像url保存起来
    }
}
