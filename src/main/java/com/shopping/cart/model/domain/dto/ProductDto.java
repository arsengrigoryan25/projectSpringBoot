package com.shopping.cart.model.domain.dto;

import java.io.Serializable;
import java.util.Date;

public class ProductDto implements Serializable {
	private static final long serialVersionUID = -112542938323603979L;

	private Long id;
	private String name;
	private String type;
	private Integer price;
	private Date createdDate;
	private Date updatedDate;
	private Integer countInStock;

	public ProductDto() { }
	public ProductDto(Long id, String name, String type, Integer price, Date createdDate, Date updatedDate, Integer countInStock) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.countInStock = countInStock;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}

	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Integer getCountInStock() {
		return countInStock;
	}
	public void setCountInStock(Integer countInStock) {
		this.countInStock = countInStock;
	}
}
