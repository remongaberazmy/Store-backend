package com.remon.store.common.enums;

public enum LogicalOperatorsEnum implements StringEnum{

	AND("AND"),
	OR("OR");
	
	private String value;
	
	private LogicalOperatorsEnum(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return this.value;
	}
}
