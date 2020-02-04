package com.shopping.cart.domain.dto;

import java.io.Serializable;

public class ShoppingCartDto implements Serializable {
	private static final long serialVersionUID = 7547305298716063920L;

	private Long id;
	private Long userId;
	private Long productId;
	private Integer quantity;

	public ShoppingCartDto() { }
	public ShoppingCartDto(Long id, Long userId, Long productId, Integer quantity) {
		this.id = id;
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
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
}
