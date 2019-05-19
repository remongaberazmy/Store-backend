package com.remon.store.data.dao;

import com.remon.store.common.query.ProductCriteriaFilter;
import com.remon.store.data.base.DAO;
import com.remon.store.data.models.ProductEB;

public interface ProductDAO extends DAO<ProductEB, Long, ProductCriteriaFilter>{

	public void enableMonthlyFilter(Integer month, Integer year);
}
