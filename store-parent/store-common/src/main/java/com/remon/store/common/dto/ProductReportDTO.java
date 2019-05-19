package com.remon.store.common.dto;

public class ProductReportDTO extends ProductDTO{

	private static final long serialVersionUID = 1L;
	
	private Double quantity;
	
	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
}
