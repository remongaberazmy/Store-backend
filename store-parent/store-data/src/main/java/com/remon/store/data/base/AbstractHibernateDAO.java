package com.remon.store.data.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.remon.store.common.query.AbstractCriteriaFilter;
import com.remon.store.data.exceptions.StoreHibernateException;
import com.remon.store.data.query.CriteriaQueryGeneratorHolder;

@Transactional
public abstract class AbstractHibernateDAO <E extends AbstractEntity<?>, S extends Serializable, Q extends AbstractCriteriaFilter> implements DAO<E, S, Q>{

	private Class<E> entityClass;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public AbstractHibernateDAO(Class<E> entityClass) {
		this.entityClass = entityClass;
	}
	
	public void create(E entity){
		try {
			getSession().persist(entity);
		}catch(RuntimeException e) {
			throw new StoreHibernateException(e);
		}
	}
	
	public void update(E entity){
		try {
			getSession().update(entity);
		}catch(RuntimeException e) {
			throw new StoreHibernateException(e);
		}
	}
	
	public E getById(S id){
		try {
			return (E) getSession().get(entityClass, id);
		}catch(RuntimeException e) {
			throw new StoreHibernateException(e);
		}
	}
	
	public E getEntityByCriteriaQueryFilter(Q criteria){
		try {
			Query<E> query = getSession().createQuery(CriteriaQueryGeneratorHolder.generateQuery(criteria), entityClass);
			query = CriteriaQueryGeneratorHolder.setParameters(query, criteria);
			return query.getSingleResult();
		}catch(RuntimeException e) {
			throw new StoreHibernateException(e);
		}
	}
	
	@Override
	public List<E> getEntityListByCriteriaQueryFilter(Q criteria) {
		try {
			Query<E> query = getSession().createQuery(CriteriaQueryGeneratorHolder.generateQuery(criteria), entityClass);
			query = CriteriaQueryGeneratorHolder.setParameters(query, criteria);
			return query.list();
		}catch(RuntimeException e) {
			throw new StoreHibernateException(e);
		}
	}

	public void flush() {
		getSession().flush();
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}