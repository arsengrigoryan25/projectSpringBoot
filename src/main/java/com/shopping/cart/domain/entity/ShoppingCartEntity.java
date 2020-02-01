package com.shopping.cart.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String userId;
    private String productId;
    private String quantity;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id", insertable = false, updatable = false,  foreignKey = @ForeignKey(name="id"))
//    private UserEntity users;

//    @OneToOne(mappedBy = "shoppingCart", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private ProductEntity productEntity;

    public ShoppingCartEntity() {
    }

    public ShoppingCartEntity(String userId, String productId, String quantity) {
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
