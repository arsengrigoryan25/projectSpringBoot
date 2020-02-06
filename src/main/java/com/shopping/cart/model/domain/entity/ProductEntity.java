package com.shopping.cart.model.domain.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private Integer price;
    private Date createdDate;
    private Date updatedDate;
    private Integer countInStock;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CartItemEntity> cartItem = new HashSet<>();

    public ProductEntity() {
    }

    public ProductEntity(String name, String type, Integer price, Date createdDate, Integer countInStock) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.createdDate = createdDate;
        this.countInStock = countInStock;
    }

    public ProductEntity(String name, String type, Integer price, Date createdDate, Date updatedDate, Integer countInStock) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.countInStock = countInStock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Integer getCountInStock() {
        return countInStock;
    }

    public void setCountInStock(Integer countInStock) {
        this.countInStock = countInStock;
    }

    public Set<CartItemEntity> getCartItem() {
        return cartItem;
    }

    public void setCartItem(Set<CartItemEntity> cartItem) {
        this.cartItem = cartItem;
    }
}