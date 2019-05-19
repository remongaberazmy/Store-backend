package com.remon.store.common.query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.remon.store.common.enums.FieldOperatorEnum;
import com.remon.store.common.enums.LogicalOperatorsEnum;

public abstract class AbstractCriteriaFilter implements Serializable{

	private static final long serialVersionUID = 1L;

	private final String FROM_CLAUSE;
	private final String ALIAS;
	private final boolean DISTINCT;
	
	private LogicalOperatorsEnum logicalOperator;
	
	private List<CriteriaFilterComponent> criteriaComponents;
	
	public AbstractCriteriaFilter(final String FROM_CLAUSE,final boolean DISTINCT,final String ALIAS) {
		this.FROM_CLAUSE = FROM_CLAUSE;
		this.ALIAS = ALIAS;
		this.DISTINCT = DISTINCT;
		logicalOperator = LogicalOperatorsEnum.AND;
	}
	
	public void addCriteria(String attribute, FieldOperatorEnum fieldOperatorEnum, Serializable value) {
		addCriteriaComponent(new CriteriaFilterComponent(attribute, fieldOperatorEnum, value));
	}

	public String getFROM_CLAUSE() {
		return FROM_CLAUSE;
	}

	public String getALIAS() {
		return ALIAS;
	}
	
	public boolean isDISTINCT() {
		return DISTINCT;
	}

	public List<CriteriaFilterComponent> getCriteriaComponents() {
		if(criteriaComponents == null) {
			criteriaComponents = new ArrayList<CriteriaFilterComponent>();
		}
		return criteriaComponents;
	}

	public void setCriteriaComponents(List<CriteriaFilterComponent> criteriaComponents) {
		this.criteriaComponents = criteriaComponents;
	}
	
	public void addCriteriaComponent(CriteriaFilterComponent criteriaComponents) {
		getCriteriaComponents().add(criteriaComponents);
	}
	
	public LogicalOperatorsEnum getLogicalOperator() {
		return logicalOperator;
	}

	public void changeLogicalOperatorToOR() {
		logicalOperator = LogicalOperatorsEnum.OR;
	}
}
