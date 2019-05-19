package com.remon.store.common.query;

import java.io.Serializable;

import com.remon.store.common.enums.FieldOperatorEnum;

public class CriteriaFilterComponent implements Serializable{

	private static final long serialVersionUID = 1L;

	private String attribute;
	private FieldOperatorEnum fieldTypeEnum;
	private Serializable value;
	
	public CriteriaFilterComponent(String attribute, FieldOperatorEnum fieldTypeEnum, Serializable value) {
		this.attribute = attribute;
		this.fieldTypeEnum = fieldTypeEnum;
		this.value = value;
	}
	
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public FieldOperatorEnum getFieldTypeEnum() {
		return fieldTypeEnum;
	}
	public void setFieldTypeEnum(FieldOperatorEnum fieldTypeEnum) {
		this.fieldTypeEnum = fieldTypeEnum;
	}
	public Serializable getValue() {
		return value;
	}
	public void setValue(Serializable value) {
		this.value = value;
	}
}
