package com.meiheyoupin.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Goods {
    private Integer id;

    private String name;

    /*
    0   未审核
    1   审核通过\已上架
    2   审核未通过
    3   已下架
    4   被删除
     */
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

    private Integer limitCount;

    private Integer stockAmount;

    private Integer recommended;

    private Integer sales;

    private Integer storeId;

    private Date createTime;

    private Date updateTime;

    private String description;

    private String specification;


    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public Integer getLimitCount() {
        return limitCount;
    }

    public void setLimitCount(Integer limitCount) {
        this.limitCount = limitCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state=" + state +
                ", amount=" + amount +
                ", price=" + price +
                ", pricePeople=" + pricePeople +
                ", content='" + content + '\'' +
                ", grade=" + grade +
                ", numOfPeople=" + numOfPeople +
                ", occasion='" + occasion + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", primaryPictureUrl='" + primaryPictureUrl + '\'' +
                ", category=" + category +
                ", subject=" + subject +
                ", limitCount=" + limitCount +
                ", stockAmount=" + stockAmount +
                ", recommended=" + recommended +
                ", sales=" + sales +
                ", storeId=" + storeId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", description='" + description + '\'' +
                ", specification='" + specification + '\'' +
                '}';
    }
}