package com.example.demo6.request;

public class ProductRequestSave {

    private String name;
    private int count;
    private int price;

    public String getName() {
        return name;
    }

    public ProductRequestSave setName(String name) {
        this.name = name;
        return this;
    }

    public int getCount() {
        return count;
    }

    public ProductRequestSave setCount(int count) {
        this.count = count;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public ProductRequestSave setPrice(int price) {
        this.price = price;
        return this;
    }
}
