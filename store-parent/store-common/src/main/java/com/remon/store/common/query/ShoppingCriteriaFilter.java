package com.remon.store.common.query;

public class ShoppingCriteriaFilter extends AbstractCriteriaFilter{

private static final long serialVersionUID = 1L;
	
	private static final String FROM_CLAUSE = "FROM ShoppingEB shopping";
	
	public ShoppingCriteriaFilter() {
		super(FROM_CLAUSE, false, "shopping");
	}
}
