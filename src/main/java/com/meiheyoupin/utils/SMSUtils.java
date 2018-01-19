package com.meiheyoupin.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class SMSUtils {

    /*
    商家审核通过
     */
    public static Boolean auditStoresMessage(String tel,String username,String password) throws ClientException {

        final String product = "Dysmsapi";
        final String domain = "dysmsapi.aliyuncs.com";

        final String accessKeyId = "LTAIzHIrXlTmPrsT";
        final String accessKeySecret = "9kXdmInYdKM3DH0KXatSJ9kgGW7Ukr";

        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
                accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        SendSmsRequest request = new SendSmsRequest();

        request.setMethod(MethodType.POST);

        request.setPhoneNumbers(tel);

        request.setSignName("美盒优品");

        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode("SMS_121910315");

        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
        request.setTemplateParam("{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");

        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            return true;
        }
        return false;
    }

    /*
    商家审核未通过
     */
    public static Boolean unsanctionedStoreMessage(String tel,String reason) throws ClientException {

        final String product = "Dysmsapi";
        final String domain = "dysmsapi.aliyuncs.com";

        final String accessKeyId = "LTAIzHIrXlTmPrsT";
        final String accessKeySecret = "9kXdmInYdKM3DH0KXatSJ9kgGW7Ukr";

        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
                accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        SendSmsRequest request = new SendSmsRequest();

        request.setMethod(MethodType.POST);

        request.setPhoneNumbers(tel);

        request.setSignName("美盒优品");

        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode("SMS_121906456");

        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
        request.setTemplateParam("{\"reason\":\"" + reason + "\"}");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");

        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            return true;
        }
        return false;
    }

    /*
    套餐审核通过
     */
    public static Boolean auditGoodsMessage(String tel,String storename,String packname) throws ClientException {

        final String product = "Dysmsapi";
        final String domain = "dysmsapi.aliyuncs.com";

        final String accessKeyId = "LTAIzHIrXlTmPrsT";
        final String accessKeySecret = "9kXdmInYdKM3DH0KXatSJ9kgGW7Ukr";

        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
                accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        SendSmsRequest request = new SendSmsRequest();

        request.setMethod(MethodType.POST);

        request.setPhoneNumbers(tel);

        request.setSignName("美盒优品");

        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode("SMS_121856490");

        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
        request.setTemplateParam("{\"storename\":\"" + storename + "\",\"packname\":\"" + packname + "\"}");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");

        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            return true;
        }
        return false;
    }


    /*
    套餐审核未通过
     */
    public static Boolean unsanctionedGoodMessage(String tel,String storename,String packname,String reason) throws ClientException {

        final String product = "Dysmsapi";
        final String domain = "dysmsapi.aliyuncs.com";

        final String accessKeyId = "LTAIzHIrXlTmPrsT";
        final String accessKeySecret = "9kXdmInYdKM3DH0KXatSJ9kgGW7Ukr";

        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
                accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        SendSmsRequest request = new SendSmsRequest();

        request.setMethod(MethodType.POST);

        request.setPhoneNumbers(tel);

        request.setSignName("美盒优品");

        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode("SMS_121906482");

        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
        request.setTemplateParam("{\"storename\":\"" + storename + "\",\"packname\":\"" + packname + "\",\"reason\":\"" + reason + "\"}");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");

        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            return true;
        }
        return false;
    }

    /*
    生日祝福语短信发送
     */
    public static Boolean sendBirthdayBlessings(String tel,String name,String blessing) throws ClientException {

        final String product = "Dysmsapi";
        final String domain = "dysmsapi.aliyuncs.com";

        final String accessKeyId = "LTAIzHIrXlTmPrsT";
        final String accessKeySecret = "9kXdmInYdKM3DH0KXatSJ9kgGW7Ukr";

        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
                accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        SendSmsRequest request = new SendSmsRequest();

        request.setMethod(MethodType.POST);

        request.setPhoneNumbers(tel);

        request.setSignName("美盒优品");

        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode("SMS_122285852");

        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
        request.setTemplateParam("{\"blessing\":\"" + blessing +"\",\"name\":\"" + name + "\"}");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");

        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            return true;
        }
        return false;
    }
}