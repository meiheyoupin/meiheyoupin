package com.meiheyoupin.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Refund {
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