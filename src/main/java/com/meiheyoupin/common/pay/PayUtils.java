package com.meiheyoupin.common.pay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConstants;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PayUtils {

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

    public static String alipayRefundQuery(String orderNumber) {
        AlipayTradeQueryRequest aliPayRequest = new AlipayTradeQueryRequest();
        aliPayRequest.setBizContent("{\"out_trade_no\":\"" + orderNumber + "\"}");
        String result = null;
        try {
            result = alipayClient.execute(aliPayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return result;
    }

}
