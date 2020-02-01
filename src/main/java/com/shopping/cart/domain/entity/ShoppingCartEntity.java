package com.shopping.cart.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer productId;
    private Integer quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private UserEntity users;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private ProductEntity product;

    public ShoppingCartEntity() {
    }

    public ShoppingCartEntity(Integer userId, Integer productId, Integer quantity) {
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
