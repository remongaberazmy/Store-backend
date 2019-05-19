package com.remon.store.data.query;

import static com.remon.store.common.query.SQLQuery.*;
import org.hibernate.query.Query;
import com.remon.store.common.query.AbstractCriteriaFilter;
import com.remon.store.common.query.CriteriaFilterComponent;
import com.remon.store.data.base.AbstractEntity;

public class CriteriaQueryGeneratorHolder {

	public static <T extends AbstractCriteriaFilter> String generateQuery(T cf) {
		StringBuilder builder = new StringBuilder();
		builder.append(SELECT);
		if(cf.isDISTINCT()) {
			builder.append(DISTINCT);
		}
		builder.append(SPACE);
		builder.append(cf.getALIAS());
		builder.append(SPACE);
		builder.append(cf.getFROM_CLAUSE());
		if(!cf.getCriteriaComponents().isEmpty()) {
			builder.append(WHERE);
		}
		for(CriteriaFilterComponent criteriaFilterComponent : cf.getCriteriaComponents()) {
			builder.append(SPACE);
			builder.append(criteriaFilterComponent.getAttribute());
			builder.append(SPACE);
			builder.append(criteriaFilterComponent.getFieldTypeEnum().getValue());
			builder.append(SPACE);
			builder.append(COLON);
			builder.append(removeSpecialCharacters(criteriaFilterComponent.getAttribute()));
			builder.append(SPACE);
			builder.append(cf.getLogicalOperator().getValue());
		}
		if(!cf.getCriteriaComponents().isEmpty()) {
			builder.delete(builder.lastIndexOf(cf.getLogicalOperator().getValue()), builder.length());
		}
		return builder.toString().trim();
	}
	
	public static <E extends AbstractEntity<?>, T extends AbstractCriteriaFilter> Query<E> setParameters(Query<E> query, T cf) {
		
		cf.getCriteriaComponents().stream().forEach(component -> {
			query.setParameter(removeSpecialCharacters(component.getAttribute()), component.getValue());
		});
		return query;
	}
	
	private static String removeSpecialCharacters(String parameter) {
		return parameter.replaceAll("[^a-zA-Z0-9_-]", "");
	}
	
}
