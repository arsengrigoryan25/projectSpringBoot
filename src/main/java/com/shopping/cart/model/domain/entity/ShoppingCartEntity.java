package com.shopping.cart.model.domain.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.*;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    private UserEntity user;

    @OneToOne(mappedBy = "shoppingCart")
    public CartItemEntity cartItem;

    public ShoppingCartEntity() {
    }

    public ShoppingCartEntity(UserEntity user, CartItemEntity cartItem) {
        this.user = user;
        this.cartItem = cartItem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public CartItemEntity getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartItemEntity cartItem) {
        this.cartItem = cartItem;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(user)
                .append(cartItem)
                .append(user)
                .append(cartItem)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final ShoppingCartEntity other = (ShoppingCartEntity) obj;
        return new EqualsBuilder()
                .append(id, other.id)
                .append(user, other.user)
                .append(cartItem, other.cartItem)
                .append(user, other.user)
                .append(cartItem, other.cartItem)
                .isEquals();
    }
}
