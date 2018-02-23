package com.meiheyoupin.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.aliyuncs.exceptions.ClientException;
import com.meiheyoupin.common.exception.RRException;
import com.meiheyoupin.common.pay.PayUtils;
import com.meiheyoupin.common.utils.R;
import com.meiheyoupin.dao.*;
import com.meiheyoupin.entity.*;
import com.meiheyoupin.service.OrdersService;
import com.meiheyoupin.service.RefundService;
import com.meiheyoupin.utils.SMSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @author vincent
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class RefundServiceImpl implements RefundService {

    @Autowired
    private RefundMapper refundMapper;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private OrderGoodsMapper orderGoodsMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 根据退款单状态遍历退款单
     * @return
     */
    @Override
    public R getRefundsByState() {
        Map<String, Object> params = new HashMap<>(16);
        Integer[] states = new Integer[]{Orders.ORDER_STATE_PAID};
        params.put("states",states);
        return R.ok().put("refunds",refundMapper.selectRefundsToAuditByAdmin(params));
    }

    /**
     * 退款单审核通过
     * @param id
     * @return
     */
    @Override
    public R auditRefund(Integer id) {
        if (id == null){
            return R.error("参数不正确");
        }
        Refund refund = refundMapper.selectByPrimaryKey(id);
        if (refund == null){
            return R.error("未找到对应实体类");
        }
        try {
            thirdPartyDealRefund(id);
        }catch (Exception e){
            throw new RRException("第三方退款异常");
        }
        //恢复库存
        Orders orders = ordersMapper.selectOrderById(refund.getOrderId());
        OrderGoods orderGoods = orderGoodsMapper.selectObjByOrderId(orders.getId());
        Goods goods = goodsMapper.selectGoodByGoodId(Integer.valueOf(orderGoods.getGoodsId()));
        log.error("被退款的商品Id为："+goods.getId());
        goods.setStockAmount(goods.getStockAmount()+orderGoods.getCount());
        if (goods.getLimitCount()!=null){
            goods.setStockAmount(goods.getStockAmount()+orderGoods.getCount());
            goodsMapper.updateGoods(goods);
        }
        //修改订单状态
        orders.setState(Orders.ORDER_STATE_REFUNDED);
        if (ordersMapper.updateOrderById(orders)==0){
            return R.error("修改订单状态失败");
        }
        //发布消息至rabbitmq
        String ordeToString = JSON.toJSONString(orders);
        try {
            rabbitTemplate.convertAndSend("sendToFront","frontKey1",ordeToString);
        }catch (Exception e){
            throw new RRException("rabbitmq消息发布失败");
        }
        //短信通知
        Optional<User> userOptional = Optional.ofNullable(userMapper.selectUserFromRefundId(id));
        log.error("退款单审核通过的用户id为"+userOptional.orElse(null).getId());
        userOptional.ifPresent( user -> new Thread(()->{
            try {
                SMSUtils.sendUserRefundSuccess(user.getTel(),user.getContactsName(),ordersMapper.selectOrderById(refund.getOrderId()).getName());
            } catch (ClientException e) {
                e.printStackTrace();
            }
        }).start());
        refund.setState(Refund.REFUND_STATE_AUDIT);
        refund.setUpdateTime(new Date());
        if (refundMapper.updateByPrimaryKeySelective(refund)==0){
            return R.error("数据库操作失败");
        }
        return R.ok("退款处理成功");
    }

    /**
     * 退款单审核不通过
     * @param id
     * @param reason
     * @return
     */
    @Override
    public R unAuditRefund(Integer id,String reason) {
        if (id == null || StringUtils.isEmpty(reason)){
            return R.error("参数不正确");
        }
        Refund refund = refundMapper.selectByPrimaryKey(id);
        if (refund == null){
            return R.error("未找到对应实体类");
        }
        Optional<User> userOptional = Optional.ofNullable(userMapper.selectUserFromRefundId(id));
        log.error("退款单审核不通过的用户id为"+userOptional.orElse(null).getId());
        //短信发送
        userOptional.ifPresent( user -> new Thread(()->{
            try {
                SMSUtils.sendUserRefundFail(user.getTel(),
                        user.getContactsName(),
                        ordersMapper.selectOrderById(refund.getOrderId()).getName(),reason);
            } catch (ClientException e) {
                e.printStackTrace();
            }
        }).start());
        refund.setState(Refund.REFUND_STATE_UNAUDIT);
        refund.setUpdateTime(new Date());
        if (refundMapper.updateByPrimaryKeySelective(refund)==0){
            return R.error("sql更新refund失败");
        }
        return R.ok("操作成功");
    }

    /**
     * 第三方申请退款中
     * @param id
     */
    private void thirdPartyDealRefund(Integer id) {
        Refund refund = refundMapper.selectByPrimaryKey(id);
        Orders orders = ordersService.getOrderById(refund.getOrderId());
        if ("wxpay".equalsIgnoreCase(orders.getPayWay())) {
            Map<String, String> response = PayUtils.wxpayRefund(orders.getId(), orders.getPaymentAmount(),
                    orders.getPaymentAmount(), refund.getReason());
            if (response != null && "SUCCESS".equals(response.get("result_code"))) {
                refund.setWxpayRefundId(response.get("refund_id_0"));
                refund.setState(Refund.REFUND_STATE_APPLICATION);
            }
        } else if ("alipay".equalsIgnoreCase(orders.getPayWay())) {
            AlipayTradeRefundResponse response = PayUtils.alipayRefund(orders.getId(), orders.getPaymentAmount());
            if (response != null && response.isSuccess()) {
                refund.setAlipayRefundId(response.getTradeNo());
                refund.setState(Refund.REFUND_STATE_APPLICATION);
            }
        }
        if (refund.getState() != 1) {

        }

    }

}
