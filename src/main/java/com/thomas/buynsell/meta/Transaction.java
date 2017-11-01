package com.thomas.buynsell.meta;

import java.math.BigInteger;

public class Transaction {
    private int id;
    private int contentId; // contentID
    private int personId;
    private double price;
    private String time;
    private int buyNum;

    public int getId() {
        return id;
    }

    public int getProductId() {
        return contentId;
    }

    public int getPersonId() {
        return personId;
    }

    public double getPrice() {
        return price;
    }

    public String getBuyTime() {
        return time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBuyTime(String buyTime) {
        this.time = buyTime;
    }

    public int getBuyNum() {
        return buyNum;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", contentId=" + contentId +
                ", personId=" + personId +
                ", price=" + price +
                ", buyTime=" + time +
                ", buyNum=" + buyNum +
                '}';
    }

    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }
}
