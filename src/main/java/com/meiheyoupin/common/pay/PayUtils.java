package com.meiheyoupin.common.pay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeFastpayRefundQueryRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeFastpayRefundQueryResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConstants;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PayUtils {

    public static String WXPAY_RESPONSE_SUCCESS = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>" + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
    public static String WXPAY_RESPONSE_FAIL = "<xml>\" + \"<return_code><![CDATA[FAIL]]></return_code>\" + \"<return_msg></return_msg>\" + \"</xml> ";
    public static String ALIPAY_RESPONSE_SUCCESS = "success";
    public static String ALIPAY_RESPONSE_FAIL = "fail";

    private static com.github.wxpay.sdk.WXPayConfig config;

    private static AlipayClient alipayClient;

    static {
        try {
            config = new WXPayConfig();
            alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key,
                    "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 微信支付下单交易
     *
     * @param orderNumber   订单号
     * @param orderName     订单名
     * @param paymentAmount 支付金额
     * @param remoteAddress 客户端ip地址
     * @return 二维码url
     */
    public static String wxpayTrade(String orderNumber, String orderName, Double paymentAmount, String remoteAddress) {
        WXPay wxpay = new WXPay(config);
        // 所需支付金额以分为单位
        paymentAmount *= 100;
        Map<String, String> params = new HashMap<>();
        params.put("body", orderName);
        params.put("out_trade_no", orderNumber);
        params.put("fee_type", "CNY");
        params.put("total_fee", String.valueOf(paymentAmount.intValue()));
        params.put("spbill_create_ip", remoteAddress);
        params.put("notify_url", "http://www.meiheyoupin.com/wxpay/notify");
        params.put("trade_type", "NATIVE");  // 此处指定为扫码支付
        try {
            Map<String, String> map = wxpay.unifiedOrder(params);
            return map.get("code_url");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, String> wxpayOrderQuery(String orderId) {
        WXPay wxpay = new WXPay(config);
        Map<String, String> data = new HashMap<>();
        data.put("out_trade_no", orderId);
        try {
            return wxpay.orderQuery(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, String> wxpayRefund(String orderNumber, Double totalAmount, Double refundAmount, String refundDesc) {
        WXPay wxpay = new WXPay(config);
        Map<String, String> data = new HashMap<>();
        data.put("out_trade_no", orderNumber);
        data.put("out_refund_no", "2016090910595900000012");
        data.put("total_fee", String.valueOf(totalAmount * 100));
        data.put("refund_fee", String.valueOf(refundAmount * 100));
        data.put("refund_desc", refundDesc);
        Map<String, String> resp = null;
        try {
            resp = wxpay.refund(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public static Map<String, String> wxpayRefundQuery(String orderNumber) {
        WXPay wxpay = new WXPay(config, WXPayConstants.SignType.MD5);
        Map<String, String> data = new HashMap<>();
        data.put("out_trade_no", orderNumber);
        try {
            Map<String, String> resp = wxpay.refundQuery(data);
            System.out.println(resp);
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static AlipayTradeRefundResponse alipayRefund(String orderNumber, Double refundAmount) {
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        request.setBizContent("{" +
                "\"out_trade_no\":\"" + orderNumber + "\"," +
                "\"refund_amount\":" + refundAmount +
                "  }");
        try {
            return alipayClient.execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static AlipayTradePrecreateResponse alipayTrade(String orderNumber, Double paymentAmount, String orderName) {
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        request.setNotifyUrl(AlipayConfig.notify_url);
        request.setBizContent("{" +
                "\"out_trade_no\":\"" + orderNumber + "\"," +
                "\"total_amount\":" + paymentAmount + "," +
                "\"subject\":\"" + orderName + "\"" +
                "}");
        try {
            return alipayClient.execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static AlipayTradeFastpayRefundQueryResponse alipayRefundQuery(String orderNumber) {
        AlipayTradeFastpayRefundQueryRequest request = new AlipayTradeFastpayRefundQueryRequest();
        request.setBizContent("{" +
                "\"out_trade_no\":\"" + orderNumber + "\"," +
                "\"out_request_no\":\"" + orderNumber + "\"" +
                "}");
        try {
            return alipayClient.execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return null;
    }

}
