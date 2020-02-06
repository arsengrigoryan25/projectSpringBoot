package com.shopping.cart.model.domain.dto;

import java.io.Serializable;

public class ShoppingCartDto implements Serializable {
	private static final long serialVersionUID = 7547305298716063920L;

	private Long id;
	private UserDto user;
	private CartItemDto cartItem;

	public ShoppingCartDto() { }
	public ShoppingCartDto(Long id, UserDto user, CartItemDto cartItem) {
		this.id = id;
		this.user = user;
		this.cartItem = cartItem;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}

	public CartItemDto getCartItem() {
		return cartItem;
	}
	public void setCartItem(CartItemDto cartItem) {
		this.cartItem = cartItem;
	}
}

