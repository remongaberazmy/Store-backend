package com.remon.store.common.dto;

import java.util.Date;

import com.remon.store.common.base.AbstractDTO;

public class ShoppingDTO extends AbstractDTO<Long>{

	private static final long serialVersionUID = 1L;

	private Long id;
	private ProductDTO product;
	private Double quantity;
	private Date shoppingOn;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ProductDTO getProduct() {
		return product;
	}
	public void setProduct(ProductDTO product) {
		this.product = product;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public Date getShoppingOn() {
		return shoppingOn;
	}
	public void setShoppingOn(Date shoppingOn) {
		this.shoppingOn = shoppingOn;
	}
	
	@Override
	public Long PK() {
		return getId();
	}

}
