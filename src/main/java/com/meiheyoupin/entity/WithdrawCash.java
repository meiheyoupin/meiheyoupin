package com.meiheyoupin.entity;

/**
 * @author vincent
 */
public class WithdrawCash {

    private Integer storeId;
    private String storeTel;
    private String storeName;
    private Double cash;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public String getStoreTel() {
        return storeTel;
    }

    public void setStoreTel(String storeTel) {
        this.storeTel = storeTel;
    }

    @Override
    public String toString() {
        return "WithdrawCash{" +
                "storeId=" + storeId +
                ", storeTel='" + storeTel + '\'' +
                ", storeName='" + storeName + '\'' +
                ", cash=" + cash +
                '}';
    }
}
