package com.meiheyoupin.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.aliyuncs.exceptions.ClientException;
import com.meiheyoupin.common.pay.PayUtils;
import com.meiheyoupin.dao.*;
import com.meiheyoupin.entity.*;
import com.meiheyoupin.service.OrdersService;
import com.meiheyoupin.service.RefundService;
import com.meiheyoupin.utils.SMSUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author vincent
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RefundServiceImpl implements RefundService {

    @Autowired
    RefundMapper refundMapper;

    @Autowired
    OrdersService ordersService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    OrdersMapper ordersMapper;

    @Autowired
    OrderGoodsMapper orderGoodsMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    RabbitTemplate rabbitTemplate;

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
    public Map<String, Object> auditRefund(Integer id) {
        Map<String, Object> map = new HashMap<>();
        Refund refund = refundMapper.selectByPrimaryKey(id);
        User user = userMapper.selectUserFromRefundId(id);
        try {
            thirdPartyDealRefund(id);
        }catch (Exception e){
            map.put("error","第三方退款申请API失败");
            return map;
        }
        //恢复库存
        Orders orders = ordersMapper.selectOrderById(refund.getOrderId());
        OrderGoods orderGoods = orderGoodsMapper.selectObjByOrderId(orders.getId());
        Goods goods = goodsMapper.selectGoodByGoodId(Integer.valueOf(orderGoods.getGoodsId()));
        goods.setStockAmount(goods.getStockAmount()+orderGoods.getCount());
        if (goods.getLimitCount()!=null){
            goods.setStockAmount(goods.getStockAmount()+orderGoods.getCount());
            goodsMapper.updateGoods(goods);
        }
        //修改订单状态
        orders.setState((byte) 8);
        ordersMapper.updateOrderById(orders);
        //发布消息至rabbitmq
        String ordeToString = JSON.toJSONString(orders);
        try {
            rabbitTemplate.convertAndSend("sendToFront","frontKey1",ordeToString);
        }catch (Exception e){
            map.put("error","rabbitmq消息发布失败");
            return map;
        }
        //短信通知
        new Thread(()->{
            try {
                SMSUtils.sendUserRefundSuccess(user.getTel(),user.getContactsName(),ordersMapper.selectOrderById(refund.getOrderId()).getName());
            } catch (ClientException e) {
                e.printStackTrace();
            }
        }).start();
        refund.setState(2);
        refund.setUpdateTime(new Date());
        if (refundMapper.updateByPrimaryKeySelective(refund)<=0){
            map.put("error","数据库操作失败");
            return map;
        }
        map.put("ok","退款处理成功");
        return map;
    }

    /*
    退款单审核不通过
     */
    @Override
    public int unAuditRefund(Integer id,String reason) {
        Refund refund = refundMapper.selectByPrimaryKey(id);
        refund.setState(6);
        refund.setUpdateTime(new Date());
        User user = userMapper.selectUserFromRefundId(id);
        new Thread(()->{
            try {
                SMSUtils.sendUserRefundFail(user.getTel(),user.getContactsName(),ordersMapper.selectOrderById(refund.getOrderId()).getName(),reason);
            } catch (ClientException e) {
                e.printStackTrace();
            }
        }).start();
        return refundMapper.updateByPrimaryKeySelective(refund);
    }

    /*
    第三方申请退款中
     */
    private void thirdPartyDealRefund(Integer id) {
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
