package com.meiheyoupin.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Orders {
    private String id;

    private Integer userId;

    private BigDecimal paymentAmount;

    private BigDecimal totalAmount;

    private Byte state;

    private String name;

    private Integer count;

    private String addressInfo;

    private Byte deliveryDate;

    private Byte deliveryTime;

    private Byte hasInvoice;

    private Integer invoiceId;

    private String comment;

    private BigDecimal couponAmount;

    private BigDecimal redEnvelopeAmount;

    private Date createTime;

    private Date updateTime;

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

    public String getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(String addressInfo) {
        this.addressInfo = addressInfo == null ? null : addressInfo.trim();
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
}