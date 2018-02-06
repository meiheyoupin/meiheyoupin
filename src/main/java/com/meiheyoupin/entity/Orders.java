package com.meiheyoupin.entity;

import java.math.BigDecimal;
import java.util.Date;

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

    private String id;

    private Integer userId;

    private Integer storeId;

    private BigDecimal paymentAmount;

    private BigDecimal totalAmount;

    private Byte state;

    private String name;

    private Integer count;

    private Integer addressId;

    private Byte deliveryDate;

    private Byte deliveryTime;

    private Byte hasInvoice;

    private Integer invoiceId;

    private String comment;

    private Double carriageAmount;

    private BigDecimal couponAmount;

    private BigDecimal redEnvelopeAmount;

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

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
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

    public Byte getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Byte deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Byte getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Byte deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Byte getHasInvoice() {
        return hasInvoice;
    }

    public void setHasInvoice(Byte hasInvoice) {
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

    public BigDecimal getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(BigDecimal couponAmount) {
        this.couponAmount = couponAmount;
    }

    public BigDecimal getRedEnvelopeAmount() {
        return redEnvelopeAmount;
    }

    public void setRedEnvelopeAmount(BigDecimal redEnvelopeAmount) {
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