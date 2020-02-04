package com.shopping.cart.domain.dto;

import com.shopping.cart.BasketItemsStatus;
import java.io.Serializable;

public class ShoppingCartDto implements Serializable {
	private static final long serialVersionUID = 7547305298716063920L;

	private Long id;
	private Long userId;
	private Long productId;
	private Integer quantity;
	private BasketItemsStatus status;

	public ShoppingCartDto() { }
	public ShoppingCartDto(Long id, Long userId, Long productId, Integer quantity, BasketItemsStatus status) {
		this.id = id;
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

	public BasketItemsStatus getStatus() {
		return status;
	}
	public void setStatus(BasketItemsStatus status) {
		this.status = status;
	}
}
