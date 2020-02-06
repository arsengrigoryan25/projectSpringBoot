package com.shopping.cart.model.filter;

import java.io.Serializable;

public class ProductFilter implements Serializable {
    private static final long serialVersionUID = 5776458177054327256L;

    private String name;
    private String type;
    private Integer fromPrice;
    private Integer toPrice;
    private boolean isAscending;

    public ProductFilter() {
    }

    public ProductFilter(String name, String type, Integer fromPrice, Integer toPrice, boolean isAscending) {
        this.name = name;
        this.type = type;
        this.fromPrice = fromPrice;
        this.toPrice = toPrice;
        this.isAscending = isAscending;
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getFromPrice() {
        return fromPrice;
    }

    public void setFromPrice(Integer fromPrice) {
        this.fromPrice = fromPrice;
    }

    public Integer getToPrice() {
        return toPrice;
    }

    public void setToPrice(Integer toPrice) {
        this.toPrice = toPrice;
    }

    public boolean isAscending() {
        return isAscending;
    }

    public void setAscending(boolean ascending) {
        isAscending = ascending;
    }
}