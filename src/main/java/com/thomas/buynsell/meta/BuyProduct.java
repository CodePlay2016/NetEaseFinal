package com.thomas.buynsell.meta;

public class BuyProduct {
    private int id;
    private int number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "BuyProduct{" +
                "id=" + id +
                ", number=" + number +
                '}';
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
