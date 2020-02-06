package com.shopping.cart.model.domain.entity;

import com.shopping.cart.model.domain.enums.BasketItemsStatus;

import javax.persistence.*;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@Entity
@Table(name = "cart_item")
public class CartItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id = null;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private BasketItemsStatus status;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "shopping_cart_id", nullable = false, updatable = false)
    private ShoppingCartEntity shoppingCart;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    public CartItemEntity() {
    }

    public CartItemEntity(ProductEntity product) {
        this.product = product;
    }

    public CartItemEntity(ShoppingCartEntity shoppingCart, ProductEntity product, Integer quantity, BasketItemsStatus status) {
        this.product = product;
        this.shoppingCart = shoppingCart;
        this.quantity = quantity;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BasketItemsStatus getStatus() {
        return status;
    }

    public void setStatus(BasketItemsStatus status) {
        this.status = status;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public ShoppingCartEntity getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCartEntity shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(quantity)
                .append(status)
                .append(shoppingCart)
                .append(product)
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

        final CartItemEntity other = (CartItemEntity) obj;
        return new EqualsBuilder()
                .append(id, other.id)
                .append(quantity, other.quantity)
                .append(status, other.status)
                .append(shoppingCart, other.shoppingCart)
                .append(product, other.product)
                .isEquals();
    }
}
