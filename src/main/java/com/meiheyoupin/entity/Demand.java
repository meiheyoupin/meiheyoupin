package com.meiheyoupin.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author vincent
 */
public class Demand {

    private Integer id;

    private String contactsTel;

    private String contactsName;

    private Byte state;

    private Date selectedDate;

    private String selectedTime;

    private Integer subjectId;

    private BigDecimal budget;

    private Integer numOfPeople;

    private String demand;

    private Integer userId;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContactsTel() {
        return contactsTel;
    }

    public void setContactsTel(String contactsTel) {
        this.contactsTel = contactsTel == null ? null : contactsTel.trim();
    }

    public String getContactsName() {
        return contactsName;
    }

    public void setContactsName(String contactsName) {
        this.contactsName = contactsName == null ? null : contactsName.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Date getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(Date selectedDate) {
        this.selectedDate = selectedDate;
    }

    public String getSelectedTime() {
        return selectedTime;
    }

    public void setSelectedTime(String selectedTime) {
        this.selectedTime = selectedTime == null ? null : selectedTime.trim();
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public Integer getNumOfPeople() {
        return numOfPeople;
    }

    public void setNumOfPeople(Integer numOfPeople) {
        this.numOfPeople = numOfPeople;
    }

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand == null ? null : demand.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        return "Demand{" +
                "id=" + id +
                ", contactsTel='" + contactsTel + '\'' +
                ", contactsName='" + contactsName + '\'' +
                ", state=" + state +
                ", selectedDate=" + selectedDate +
                ", selectedTime='" + selectedTime + '\'' +
                ", subjectId=" + subjectId +
                ", budget=" + budget +
                ", numOfPeople=" + numOfPeople +
                ", demand='" + demand + '\'' +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}