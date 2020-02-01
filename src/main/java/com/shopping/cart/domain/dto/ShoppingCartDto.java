package com.shopping.cart.domain.dto;

import java.io.Serializable;

public class ShoppingCartDto implements Serializable {
	private static final long serialVersionUID = 7547305298716063920L;

	private Integer id;
	private Integer userId;
	private Integer productId;
	private Integer quantity;

	public ShoppingCartDto() { }
	public ShoppingCartDto(Integer id, Integer userId, Integer productId, Integer quantity) {
		this.id = id;
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
