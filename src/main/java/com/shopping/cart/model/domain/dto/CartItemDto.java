package com.shopping.cart.model.domain.dto;

import com.shopping.cart.model.domain.enums.BasketItemsStatus;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class CartItemDto {
	private Long id;
	private Long cartId;
	private Long productId;
	private Integer quantity;
	private BasketItemsStatus status;

	public CartItemDto() { }
	public CartItemDto(Long id,Long productId, Long cartId, Integer quantity, BasketItemsStatus status) {
		this.id = id;
		this.cartId = cartId;
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

	public Long getCartId() {
		return cartId;
	}
	public void setCartId(Long cartId) {
		this.cartId = cartId;
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

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(id)
										  	.append(cartId)
										  	.append(productId)
										  	.append(quantity)
										  	.append(status)
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
		
		final CartItemDto other = (CartItemDto) obj;
		return new EqualsBuilder().append(id, other.id)
									.append(cartId,other.cartId)
									.append(productId,other.productId)
									.append(quantity,other.quantity)
									.append(status,other.status)
								  	.append(quantity, other.quantity)
								  .isEquals();
	}
}
