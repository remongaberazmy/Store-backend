package com.remon.store.service.base;

import java.io.Serializable;

import com.remon.store.common.base.AbstractDTO;
import com.remon.store.common.query.AbstractCriteriaFilter;
import com.remon.store.data.base.AbstractEntity;
import com.remon.store.data.base.DAO;
import com.remon.store.service.mapping.StoreMapper;

public interface CrudService<E extends AbstractEntity<?>, D extends AbstractDTO<?> , S extends Serializable, Q extends AbstractCriteriaFilter> {

	public D createEntity(D dto);
	public D updateEntity(D dto);
	
	public void doBeforeValidation(D dto);
	
	public void doValidate(D dto);
	
	public void doBeforeTransformation(D dto);
	
	public void doAfterTransformation(E entity);
	
	public void doFeforePersist(E entity);
	
	public void doAfterPersist(E entity);
	
	public StoreMapper<E, D> getTransformater(); 
	
	public DAO<E, S, Q> getDAO();
}
