package com.thomas.buynsell.meta;

import java.math.BigInteger;

public class Content {
    private int id;
    private double price;
    private String title;
    private String image;
    private String summary;
    private String text;
    private boolean isBuy;
    private boolean isSell;
    private int buyNum;
    private int sellNum;
    private long buyTime;
    private double buyPrice;

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getSummary() {
        return summary;
    }

    public String getText() {
        return text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean getIsBuy() {
        return isBuy;
    }

    public void setIsBuy(boolean buy) {
        isBuy = buy;
    }

    public boolean getIsSell() {
        return isSell;
    }

    public void setIsSell(boolean sell) {
        isSell = sell;
    }

    public int getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }

    public int getSellNum() {
        return sellNum;
    }

    public void setSellNum(int sellNum) {
        this.sellNum = sellNum;
    }

    public long getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(long buyTime) {
        this.buyTime = buyTime;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    @Override
    public String toString() {

        return "Content{" +
                "id=" + id +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", summary='" + summary + '\'' +
                ", text='" + text + '\'' +
                ", isBuy=" + isBuy +
                ", isSell=" + isSell +
                ", buyNum=" + buyNum +
                ", sellNum=" + sellNum +
                '}';
    }
}
