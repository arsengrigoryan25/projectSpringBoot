package com.shopping.cart.model.domain.dto;

import com.shopping.cart.model.domain.enums.BasketItemsStatus;
import java.io.Serializable;

public class CartItemDto implements Serializable {
	private static final long serialVersionUID = -3025972883975859631L;
	private Long id;
	private Integer quantity;
	private BasketItemsStatus status;
	private ShoppingCartDto shoppingCart;
	private ProductDto product;

	public CartItemDto() { }
	public CartItemDto(Long id, ShoppingCartDto shoppingCart, ProductDto product,  Integer quantity, BasketItemsStatus status) {
		this.id = id;
		this.shoppingCart = shoppingCart;
		this.product = product;
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

	public ShoppingCartDto getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(ShoppingCartDto shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public ProductDto getProduct() {
		return product;
	}
	public void setProduct(ProductDto product) {
		this.product = product;
	}
}
