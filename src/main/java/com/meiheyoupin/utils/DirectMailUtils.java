package com.meiheyoupin.utils;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class DirectMailUtils {


    /**
     * 单一发信接口
     * @param email     收件地址
     * @param theme     邮件主题
     * @param html      邮件正文（html格式）
     */
    public static String sendMail(String email,String theme,String html) {
        // 如果是除杭州region外的其它region（如新加坡、澳洲Region），需要将下面的"cn-hangzhou"替换为"ap-southeast-1"、或"ap-southeast-2"。
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIz6Tsov6ehm0w", "zXk2jENFOz2ZQzMa6PVeKSyh3gLMt6");
        // 如果是除杭州region外的其它region（如新加坡region）， 需要做如下处理
        //try {
        //DefaultProfile.addEndpoint("dm.ap-southeast-1.aliyuncs.com", "ap-southeast-1", "Dm",  "dm.ap-southeast-1.aliyuncs.com");
        //} catch (ClientException e) {
        //e.printStackTrace();
        //}
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest request = new SingleSendMailRequest();
        try {
            //request.setVersion("2017-06-22");// 如果是除杭州region外的其它region（如新加坡region）,必须指定为2017-06-22
            request.setAccountName("mhyp-info@mail.meiheyoupin.com");       //管理控制台中配置的发信地址。
            request.setFromAlias("美盒优品");                   //发信人昵称,长度小于 15 个字符。
            request.setAddressType(1);                          //取值范围 0~1: 0 为随机账号；1 为发信地址。
            request.setTagName("monthly");                      //控制台创建的标签
            request.setReplyToAddress(true);                    //使用管理控制台中配置的回信地址（状态必须是验证通过）。
            request.setToAddress(email);                   //目标地址，多个 email 地址可以用逗号分隔，最多100个地址。
            request.setSubject(theme);                     //邮件主题，建议填写。
            request.setHtmlBody(html);                    //邮件 html 正文。
            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
            String res = JSON.toJSONString(httpResponse);
            return res;
        } catch (ServerException e) {
            e.printStackTrace();
            return null;
        }
        catch (ClientException e) {
            e.printStackTrace();
            return null;
        }
    }

}
