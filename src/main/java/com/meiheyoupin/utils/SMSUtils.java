package com.meiheyoupin.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * @author vincent
 */
public class SMSUtils {

    private static final String PRODUCT = "Dysmsapi";

    private static final String DOMAIN = "dysmsapi.aliyuncs.com";

    private static final String ACCESS_KEY_ID = "LTAIzHIrXlTmPrsT";

    private static final String ACCESS_KEY_SECRET = "9kXdmInYdKM3DH0KXatSJ9kgGW7Ukr";

    /*
    商家审核通过
     */
    public static boolean auditStoresMessage(String tel,String username,String password) throws ClientException {
        String templateCode = "SMS_121910315";
        String templateParam = "{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}";
        return sendMessage(tel,templateCode,templateParam);
    }

    /*
    商家审核未通过
     */
    public static boolean unsanctionedStoreMessage(String tel,String reason) throws ClientException {
        String templateCode = "SMS_121906456";
        String templateParam = "{\"reason\":\"" + reason + "\"}";
        return sendMessage(tel,templateCode,templateParam);
    }

    /*
    套餐审核通过
     */
    public static Boolean auditGoodsMessage(String tel,String storename,String packname) throws ClientException {
        String templateCode = "SMS_121856490";
        String templateParam = "{\"storename\":\"" + storename + "\",\"packname\":\"" + packname + "\"}";
        return sendMessage(tel,templateCode,templateParam);
    }


    /*
    套餐审核未通过
     */
    public static Boolean unsanctionedGoodMessage(String tel,String storename,String packname,String reason) throws ClientException {
        String templateCode = "SMS_121906482";
        String templateParam = "{\"storename\":\"" + storename + "\",\"packname\":\"" + packname + "\",\"reason\":\"" + reason + "\"}";
        return sendMessage(tel,templateCode,templateParam);
    }

    /*
    生日祝福语短信发送
     */
    public static Boolean sendBirthdayBlessings(String tel,String name,String blessing) throws ClientException {
        String templateCode = "SMS_122285852";
        String templateParam = "{\"blessing\":\"" + blessing +"\",\"name\":\"" + name + "\"}";
        return sendMessage(tel,templateCode,templateParam);
    }

    /*
    成为公司用户成功
     */
    public static Boolean sendUserToHRSuccess(String tel,String name) throws ClientException {
        String templateCode = "SMS_123672651";
        String templateParam = "{\"name\":\"" + name +"\"}";
        return sendMessage(tel,templateCode,templateParam);
    }

    /*
    成为公司用户失败    //未完成
     */
    public static Boolean sendUserToHRFail(String tel,String name,String reason) throws ClientException {
        String templateCode = "SMS_123667657";
        String templateParam = "{\"name\":\"" + name +"\",\"reason\":\"" + reason + "\"}";
        return sendMessage(tel,templateCode,templateParam);
    }

    /*
    退款单通过审核
     */
    public static Boolean sendUserRefundSuccess(String tel,String username, String goodsname) throws ClientException {
        String templateCode = "SMS_125017448";
        String templateParam = "{\"username\":\"" + username +"\",\"goodsname\":\"" + goodsname + "\"}";
        return sendMessage(tel,templateCode,templateParam);
    }

    /*
    退款单未通过审核
     */
    public static Boolean sendUserRefundFail(String tel,String username, String goodsname, String reason) throws ClientException {
        String templateCode = "SMS_125027319";
        String templateParam = "{\"username\":\"" + username +"\",\"goodsname\":\"" + goodsname + "\",\"reason\":\"" + reason + "\"}";
        return sendMessage(tel,templateCode,templateParam);
    }

    private static boolean sendMessage(String tel,String templateCode,String templateParam){
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", ACCESS_KEY_ID,
                ACCESS_KEY_SECRET);
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", PRODUCT, DOMAIN);
            IAcsClient acsClient = new DefaultAcsClient(profile);
            SendSmsRequest request = new SendSmsRequest();
            request.setMethod(MethodType.POST);
            request.setPhoneNumbers(tel);
            request.setSignName("美盒优品");
            //必填:短信模板-可在短信控制台中找到
            request.setTemplateCode(templateCode);
            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
            //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
            request.setTemplateParam(templateParam);
            //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
            request.setOutId("yourOutId");
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}