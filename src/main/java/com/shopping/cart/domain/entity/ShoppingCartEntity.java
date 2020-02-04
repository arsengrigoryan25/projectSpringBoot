package com.shopping.cart.domain.entity;

import com.shopping.cart.BasketItemsStatus;
import com.shopping.cart.security.RoleName;

import javax.persistence.*;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private Long productId;
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private BasketItemsStatus status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private UserEntity users;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private ProductEntity product;

    public ShoppingCartEntity() { }
    public ShoppingCartEntity(Long userId, Long productId) {
    }
    public ShoppingCartEntity(Long userId, Long productId, Integer quantity, BasketItemsStatus status) {
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.status = status;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public UserEntity getUsers() {
        return users;
    }
    public void setUsers(UserEntity users) {
        this.users = users;
    }

    public ProductEntity getProduct() {
        return product;
    }
    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public BasketItemsStatus getStatus() {
        return status;
    }
    public void setStatus(BasketItemsStatus status) {
        this.status = status;
    }
}
