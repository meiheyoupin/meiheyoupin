package com.meiheyoupin.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Goods {
    private Integer id;

    private String name;

    private Byte state;

    private Integer amount;

    private BigDecimal price;

    private BigDecimal pricePeople;

    private String content;

    private Byte grade;

    private Integer numOfPeople;

    private String occasion;

    private String pictureUrl;

    private String primaryPictureUrl;

    private Integer category;

    private Integer subject;

    private Integer stockAmount;

    private Integer recommended;

    private Integer sales;

    private Integer storeId;

    private Date createTime;

    private Date updateTime;

    public Goods() {
    }



    public Goods(Integer id, String name, Byte state, Integer amount, BigDecimal price, BigDecimal pricePeople, String content, Byte grade, Integer numOfPeople, String occasion, String pictureUrl, String primaryPictureUrl, Integer category, Integer subject, Integer stockAmount, Integer recommended, Integer sales, Integer storeId, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.amount = amount;
        this.price = price;
        this.pricePeople = pricePeople;
        this.content = content;
        this.grade = grade;
        this.numOfPeople = numOfPeople;
        this.occasion = occasion;
        this.pictureUrl = pictureUrl;
        this.primaryPictureUrl = primaryPictureUrl;
        this.category = category;
        this.subject = subject;
        this.stockAmount = stockAmount;
        this.recommended = recommended;
        this.sales = sales;
        this.storeId = storeId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPricePeople() {
        return pricePeople;
    }

    public void setPricePeople(BigDecimal pricePeople) {
        this.pricePeople = pricePeople;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Byte getGrade() {
        return grade;
    }

    public void setGrade(Byte grade) {
        this.grade = grade;
    }

    public Integer getNumOfPeople() {
        return numOfPeople;
    }

    public void setNumOfPeople(Integer numOfPeople) {
        this.numOfPeople = numOfPeople;
    }

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion == null ? null : occasion.trim();
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }

    public String getPrimaryPictureUrl() {
        return primaryPictureUrl;
    }

    public void setPrimaryPictureUrl(String primaryPictureUrl) {
        this.primaryPictureUrl = primaryPictureUrl == null ? null : primaryPictureUrl.trim();
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getSubject() {
        return subject;
    }

    public void setSubject(Integer subject) {
        this.subject = subject;
    }

    public Integer getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(Integer stockAmount) {
        this.stockAmount = stockAmount;
    }

    public Integer getRecommended() {
        return recommended;
    }

    public void setRecommended(Integer recommended) {
        this.recommended = recommended;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
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