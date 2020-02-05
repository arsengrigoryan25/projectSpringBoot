package com.shopping.cart.model.domain.dto;

import com.shopping.cart.model.domain.enums.BasketItemsStatus;
import java.io.Serializable;

public class ShoppingCartDto implements Serializable {
	private static final long serialVersionUID = 7547305298716063920L;

	private Long id;
	private Long userId;
	private Long cartId;

	public ShoppingCartDto() { }
	public ShoppingCartDto(Long id, Long userId, Long cartId) {
		this.id = id;
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
}
