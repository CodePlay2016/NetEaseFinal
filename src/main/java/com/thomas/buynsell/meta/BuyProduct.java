package com.thomas.buynsell.meta;

import java.io.Serializable;

public class BuyProduct implements Serializable {

    private static final long serialVersionUID = -5809782578272943999L;
    private int id;
    private int number;

    public BuyProduct(int id, int number) {
        this.id = id;
        this.number = number;
    }

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
