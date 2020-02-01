package com.shopping.cart.filter;

import java.io.Serializable;

public class ProductFilter implements Serializable {

    private static final long serialVersionUID = 5776458177054327256L;

    private String name;
    private String type;
    private Integer price;

    public ProductFilter() { }
    public ProductFilter(String name, String type, Integer price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
}