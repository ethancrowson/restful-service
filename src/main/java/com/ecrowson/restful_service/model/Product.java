package com.ecrowson.restful_service.model;

import java.math.BigDecimal;

public class Product {

    private final String id;
    private final String desc;
    private final BigDecimal price;


    public Product(String id, String desc, BigDecimal price) {
        this.id = id;
        this.desc = desc;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                ", price=" + price +
                '}';
    }
}
