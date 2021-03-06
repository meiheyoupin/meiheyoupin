package com.meiheyoupin.entity;

import java.util.Date;

/**
 * @author vincent
 */
public class Orders {
    //已下单
    public static final Integer ORDER_STATE_ORDERED = 1;
    //已付款
    public static final Integer ORDER_STATE_PAID = 2;
    //已接单
    public static final Integer ORDER_STATE_RECEIVED = 3;
    //已发货
    public static final Integer ORDER_STATE_DEPARTED = 4;
    //已交付
    public static final Integer ORDER_STATE_DELIVERED = 5;
    //已评价
    public static final Integer ORDER_STATE_COMMENTED = 6;
    //已申请退款
    public static final Integer ORDER_STATE_REFUNDING = 7;
    //已完成退款
    public static final Integer ORDER_STATE_REFUNDED = 8;
    //已备货
    public static final Integer ORDER_STATE_RAADIED = 9;
    //已提现
    public static final Integer ORDER_STATE_CASH = 10;

    private String id;

    private Integer userId;

    private Integer storeId;

    private Double paymentAmount;

    private Double totalAmount;

    private Integer state;

    private String name;

    private Integer count;

    private Integer addressId;

    private Integer deliveryDate;

    private Integer deliveryTime;

    private Integer hasInvoice;

    private Integer invoiceId;

    private String comment;

    private Double carriageAmount;

    private Double couponAmount;

    private Double redEnvelopeAmount;

    private String payWay;

    private Integer storeRejectReason;

    private Integer refundReason;

    private Date createTime;

    private Date updateTime;

    public Double getCarriageAmount() {
        return carriageAmount;
    }

    public void setCarriageAmount(Double carriageAmount) {
        this.carriageAmount = carriageAmount;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public Integer getStoreRejectReason() {
        return storeRejectReason;
    }

    public void setStoreRejectReason(Integer storeRejectReason) {
        this.storeRejectReason = storeRejectReason;
    }

    public Integer getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(Integer refundReason) {
        this.refundReason = refundReason;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Integer deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Integer getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Integer deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Integer getHasInvoice() {
        return hasInvoice;
    }

    public void setHasInvoice(Integer hasInvoice) {
        this.hasInvoice = hasInvoice;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Double getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(Double couponAmount) {
        this.couponAmount = couponAmount;
    }

    public Double getRedEnvelopeAmount() {
        return redEnvelopeAmount;
    }

    public void setRedEnvelopeAmount(Double redEnvelopeAmount) {
        this.redEnvelopeAmount = redEnvelopeAmount;
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

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", userId=" + userId +
                ", storeId=" + storeId +
                ", paymentAmount=" + paymentAmount +
                ", totalAmount=" + totalAmount +
                ", state=" + state +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", addressId=" + addressId +
                ", deliveryDate=" + deliveryDate +
                ", deliveryTime=" + deliveryTime +
                ", hasInvoice=" + hasInvoice +
                ", invoiceId=" + invoiceId +
                ", comment='" + comment + '\'' +
                ", couponAmount=" + couponAmount +
                ", redEnvelopeAmount=" + redEnvelopeAmount +
                ", payWay='" + payWay + '\'' +
                ", storeRejectReason=" + storeRejectReason +
                ", refundReason=" + refundReason +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}