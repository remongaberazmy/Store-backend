package com.remon.store.common.query;

public class ProductCriteriaFilter extends AbstractCriteriaFilter{

	private static final long serialVersionUID = 1L;
	
	private static final String FROM_CLAUSE = "FROM ProductEB product";
	
	public ProductCriteriaFilter() {
		super(FROM_CLAUSE, false, "product");
	}
}
