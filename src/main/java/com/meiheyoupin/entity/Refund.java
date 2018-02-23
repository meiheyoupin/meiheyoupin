package com.meiheyoupin.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author vincent
 */
public class Refund {

    //待审核
    public static final Integer REFUND_STATE_TOBEAUDIT = 1;
    //审核通过
    public static final Integer REFUND_STATE_AUDIT = 2;
    //第三方申请退款中
    public static final Integer REFUND_STATE_APPLICATION = 3;
    //第三方申请退款成功
    public static final Integer REFUND_STATE_APPLICATION_SUCCESS = 4;
    //第三方申请退款失败
    public static final Integer REFUND_STATE_APPLICATION_FAIL = 5;
    //审核不通过
    public static final Integer REFUND_STATE_UNAUDIT = 6;

    private Integer id;

    private String orderId;

    private BigDecimal paymentAmount;

    private BigDecimal refundAmount;

    private Integer state;

    private String reason;

    private String description;

    private String wxpayRefundId;

    private String alipayRefundId;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getWxpayRefundId() {
        return wxpayRefundId;
    }

    public void setWxpayRefundId(String wxpayRefundId) {
        this.wxpayRefundId = wxpayRefundId == null ? null : wxpayRefundId.trim();
    }

    public String getAlipayRefundId() {
        return alipayRefundId;
    }

    public void setAlipayRefundId(String alipayRefundId) {
        this.alipayRefundId = alipayRefundId == null ? null : alipayRefundId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}