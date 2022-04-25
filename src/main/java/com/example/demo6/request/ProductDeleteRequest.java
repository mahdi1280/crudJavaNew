package com.example.demo6.request;

public class ProductDeleteRequest {

    private final int id;

    public ProductDeleteRequest(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
