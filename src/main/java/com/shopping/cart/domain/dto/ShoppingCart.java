package com.shopping.cart.domain.dto;

import java.io.Serializable;

public class ShoppingCart implements Serializable {

	private Integer id;
	private String userId;
	private String productId;
	private String quantity;

	public ShoppingCart() { }
	public ShoppingCart(Integer id, String userId, String productId, String quantity) {
		this.id = id;
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
}
