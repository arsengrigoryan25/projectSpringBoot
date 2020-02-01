package com.shopping.cart.filter;

import java.io.Serializable;

public class SortFilter implements Serializable {
    private static final long serialVersionUID = 4354966073377771237L;

    private Integer page;
    private Integer size;
    private String sortedValue;

    public Integer getPage() {
        return page;
    }
    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }
    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSortedValue() {
        return sortedValue;
    }
    public void setSortedValue(String sortedValue) {
        this.sortedValue = sortedValue;
    }
}
