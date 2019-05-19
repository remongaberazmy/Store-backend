package com.remon.store.data.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.remon.store.common.query.ShoppingCriteriaFilter;
import com.remon.store.data.base.AbstractHibernateDAO;
import com.remon.store.data.models.ShoppingEB;

@Transactional
@Repository("shoppingDAO")
public class ShoppingDAOImpl extends AbstractHibernateDAO<ShoppingEB, Long, ShoppingCriteriaFilter> implements ShoppingDAO{

	public ShoppingDAOImpl() {
		super(ShoppingEB.class);
	}
}
