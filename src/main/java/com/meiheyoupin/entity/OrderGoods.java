package com.meiheyoupin.entity;

import java.math.BigDecimal;

public class OrderGoods{

    private String orderId;

    private String goodsId;

    private String name;

    private BigDecimal price;

    private Integer count;

    private BigDecimal totalPrice;

    private String content;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        return "OrderGoods{" +
                "orderId='" + orderId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", totalPrice=" + totalPrice +
                ", content='" + content + '\'' +
                '}';
    }
}