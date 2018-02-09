package com.meiheyoupin.service.Impl;

import com.alipay.api.response.AlipayTradeRefundResponse;
import com.meiheyoupin.common.pay.PayUtils;
import com.meiheyoupin.dao.RefundMapper;
import com.meiheyoupin.entity.Orders;
import com.meiheyoupin.entity.Refund;
import com.meiheyoupin.service.OrdersService;
import com.meiheyoupin.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class RefundServiceImpl implements RefundService {

    @Autowired
    RefundMapper refundMapper;

    @Autowired
    OrdersService ordersService;

    /*
    根据退款单状态遍历退款单
     */
    @Override
    public List<Refund> getRefundsByState(Integer state) {
        return refundMapper.selectByState(state);
    }

    /*
    退款单审核通过
     */
    @Override
    public void modifyRefundById(Integer id) {
        Refund refund = refundMapper.selectByPrimaryKey(id);
        Orders orders = ordersService.getOrderById(refund.getOrderId());
        if ("wxpay".equalsIgnoreCase(orders.getPayWay())) {
            Map<String, String> response = PayUtils.wxpayRefund(orders.getId(), orders.getPaymentAmount(),
                    orders.getPaymentAmount(), refund.getReason());
            if (response != null && "SUCCESS".equals(response.get("result_code"))) {
                refund.setWxpayRefundId(response.get("refund_id_0"));
                refund.setState(3);
            }
        } else if ("alipay".equalsIgnoreCase(orders.getPayWay())) {
            AlipayTradeRefundResponse response = PayUtils.alipayRefund(orders.getId(), orders.getPaymentAmount());
            if (response != null && response.isSuccess()) {
                refund.setAlipayRefundId(response.getTradeNo());
                refund.setState(3);
            }
        }
        if (refund.getState() != 1) {

        }

    }

}
