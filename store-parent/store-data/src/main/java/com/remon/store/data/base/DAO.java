package com.remon.store.data.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import com.remon.store.common.query.AbstractCriteriaFilter;

public interface DAO<E extends AbstractEntity<?>, S extends Serializable, Q extends AbstractCriteriaFilter> {

	public void create(E entity);
	public void update(E entity);
	public E getById(S id);
	public E getEntityByCriteriaQueryFilter(Q criteria);
	public List<E> getEntityListByCriteriaQueryFilter(Q criteria);
	
	public void flush();
	public Session getSession();
}
