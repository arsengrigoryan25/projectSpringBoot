package com.shopping.cart.domain.dto;

import java.io.Serializable;
import java.util.Date;

public class ProductDto implements Serializable {

	private static final long serialVersionUID = 5776458177054327256L;
	private Integer id;
	private String name;
	private String type;
	private Integer price;
	private Date addedDate;
	private Date updatedDate;
	private Integer countInStock;

	public ProductDto() { }
	public ProductDto(Integer id, String name, String type, Integer price, Date addedDate, Date updatedDate, Integer countInStock) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.addedDate = addedDate;
		this.updatedDate = updatedDate;
		this.countInStock = countInStock;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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

	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
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
