package com.remon.store.data.dao;

import org.hibernate.Filter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.remon.store.common.query.ProductCriteriaFilter;
import com.remon.store.data.base.AbstractHibernateDAO;
import com.remon.store.data.models.ProductEB;

@Transactional
@Repository("productDAO")
public class ProductDAOImpl extends AbstractHibernateDAO<ProductEB, Long, ProductCriteriaFilter> implements ProductDAO{

	public ProductDAOImpl() {
		super(ProductEB.class);
	}

	@Override
	public void enableMonthlyFilter(Integer month, Integer year) {
		Filter filter = getSession().enableFilter("SHOPPING_MONTH_FILTER");
		filter.setParameter("month", month);
		filter.setParameter("year", year);
	}
}
