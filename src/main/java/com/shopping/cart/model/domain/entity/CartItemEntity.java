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
	@Column(name="id")
	protected Long id = null;
	@Column(name="cart_id")
	private Long cartId;
	@Column(name="product_id")
	private Long productId;
	@Column(name="quantity")
	private Integer quantity;
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private BasketItemsStatus status;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_cart", nullable=false)
	private ShoppingCartEntity cart;

	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "id_product", nullable = false)
	private ProductEntity product;

	public CartItemEntity() { }
	public CartItemEntity( Long cartId,Long productId) {
		this.cartId = cartId;
		this.productId = productId;
	}
	public CartItemEntity( Long cartId,Long productId, Integer quantity, BasketItemsStatus status) {
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

	public ShoppingCartEntity getCart() {
		return cart;
	}
	public void setCart(ShoppingCartEntity cart) {
		this.cart = cart;
	}

	public ProductEntity getProduct() { return product; }
	public void setProduct(ProductEntity product) { this.product = product; }

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(id)
				.append(cartId)
				.append(productId)
				.append(quantity)
				.append(status)
				.append(cart)
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
				.append(cartId,other.cartId)
				.append(productId,other.productId)
				.append(quantity,other.quantity)
				.append(status,other.status)
				.append(cart, other.cart)
				.append(product, other.product)
				.append(quantity, other.quantity)
				.isEquals();
	}
}
