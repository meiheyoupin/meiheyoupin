package com.meiheyoupin.service.Impl;

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
            //微信支付
            Map<String, String> wxpayRefundDetail = PayUtils.wxpayRefund(orders.getId(), orders.getPaymentAmount().doubleValue(),
                    orders.getPaymentAmount().doubleValue(), refund.getReason());
            if (wxpayRefundDetail != null && "SUCCESS".equals(wxpayRefundDetail.get("result_code"))) {
                String wxpayRefundId = wxpayRefundDetail.get("refund_id_0");
                if (wxpayRefundId != null) {
                    refund.setWxpayRefundId(wxpayRefundId);
                    refund.setState(1);
                    refundMapper.updateRefund(refund);
                }
            }
        } else if ("aliPay".equalsIgnoreCase(orders.getPayWay())) {
            //支付宝支付
            // TODO
        }
        if (refund.getState() != 1) {

        }

    }

}
