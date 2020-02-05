package com.shopping.cart.model.domain.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="user_id")
    private Long userId;
    @Column(name="cart_id")
    private Long cartId;

    @OneToOne(mappedBy="shoppingCart", optional = false )
    public UserEntity user;

    @OneToMany(mappedBy="cart", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CartItemEntity> shoppingCart = new HashSet<>();

    public ShoppingCartEntity() {  }
    public ShoppingCartEntity(Long userId,Long cartId) {
        this.userId = userId;
        this.cartId = cartId;
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

    public Long getCartId() {
        return cartId;
    }
    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public UserEntity getUser() {return user;}
    public void setUser(UserEntity user) {this.user = user;}

    public Set<CartItemEntity> getShoppingCart() {
        return shoppingCart;
    }
    public void setShoppingCart(Set<CartItemEntity> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
