package ru.job4j.solid.lcp.foodstore;

import java.util.Calendar;

public class Food {
    private String name;
    private Calendar expirityDate;
    private Calendar createDate;
    private double price;
    private double discount;

    public Food(String name, Calendar createDate,
                Calendar expirityDate, double price, double discount) {
        this.name = name;
        this.createDate = createDate;
        this.expirityDate = expirityDate;
        this.price = price;
        this.discount = discount;
    }

    public Calendar getExpirityDate() {
        return expirityDate;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Food{name='%s', price=%s}", name, price);
    }

    public String getName() {
        return name;
    }
}
