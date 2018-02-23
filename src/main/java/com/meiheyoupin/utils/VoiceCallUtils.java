package com.meiheyoupin.utils;


import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dyvmsapi.model.v20170525.SingleCallByTtsRequest;
import com.aliyuncs.dyvmsapi.model.v20170525.SingleCallByTtsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * @author vincent
 */
public class VoiceCallUtils {

    public static void runCall(String tel) throws ClientException {
        //云通信产品-语音API服务产品名称（产品名固定，无需修改）
        final String product = "Dyvmsapi";
        //产品域名（接口地址固定，无需修改）
        final String domain = "dyvmsapi.aliyuncs.com";
        //AK信息
        final String accessKeyId = "LTAIz6Tsov6ehm0w";
        final String accessKeySecret = "zXk2jENFOz2ZQzMa6PVeKSyh3gLMt6";
        //初始化acsClient 暂时不支持多region
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SingleCallByTtsRequest request = new SingleCallByTtsRequest();

        //必填-被叫显号,可在语音控制台中找到所购买的显号
        request.setCalledShowNumber("057128284737");
        //必填-被叫号码
        request.setCalledNumber(tel);
        //必填-Tts模板ID
        request.setTtsCode("TTS_120376271");
        //可选-当模板中存在变量时需要设置此值
        //request.setTtsParam("{\"code\":\"123456\"}");
        //可选-音量 取值范围 0--200
        request.setVolume(100);
        //可选-播放次数
        request.setPlayTimes(2);
        //可选-外部扩展字段,此ID将在回执消息中带回给调用方
        request.setOutId("yourOutId");

        //hint 此处可能会抛出异常，注意catch
        SingleCallByTtsResponse singleCallByTtsResponse = acsClient.getAcsResponse(request);
        if(singleCallByTtsResponse.getCode() != null && singleCallByTtsResponse.getCode().equals("OK")) {
            //请求成功
            System.out.println("语音文本外呼---------------");
            System.out.println("RequestId=" + singleCallByTtsResponse.getRequestId());
            System.out.println("Code=" + singleCallByTtsResponse.getCode());
            System.out.println("Message=" + singleCallByTtsResponse.getMessage());
            System.out.println("CallId=" + singleCallByTtsResponse.getCallId());
        }
    }
}
