package com.remon.store.common.enums;

public enum FieldOperatorEnum implements StringEnum{

	eq("="),
	nq("<>"),
	gt(">"),
	geq(">="),
	lt("<"),
	leq("leq"),
	like("like");
	
	private String value;
	
	private FieldOperatorEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
