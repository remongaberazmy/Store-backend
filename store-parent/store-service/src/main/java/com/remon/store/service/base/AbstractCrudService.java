package com.remon.store.service.base;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.remon.store.common.base.AbstractDTO;
import com.remon.store.common.query.AbstractCriteriaFilter;
import com.remon.store.data.base.AbstractEntity;

@Transactional
public abstract class AbstractCrudService<E extends AbstractEntity<?>, D extends AbstractDTO<?> , S extends Serializable, Q extends AbstractCriteriaFilter> implements CrudService<E, D, S, Q>{

	public final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public D createEntity(D dto) {
		doBeforeValidation(dto);
		doValidate(dto);
		doBeforeTransformation(dto);
		logger.debug("Trying to persist {}, {}",dto.getClass(), dto);
		E entity = getTransformater().transformToEntity(dto);
		doFeforePersist(entity);
		getDAO().create(entity);
		getDAO().flush();
		doAfterPersist(entity);
		doAfterTransformation(entity);
		dto = getTransformater().transformToDTO(entity);
		logger.info("{} persisted successfully. ", dto.getClass());
		return dto;
	}

	@Override
	public D updateEntity(D dto) {
		doBeforeValidation(dto);
		doValidate(dto);
		doBeforeTransformation(dto);
		logger.debug("Trying to update {}, {}", dto.getClass(), dto);
		E entity = getTransformater().transformToEntity(dto);
		doFeforePersist(entity);
		getDAO().update(entity);
		getDAO().flush();
		doAfterPersist(entity);
		doAfterTransformation(entity);
		dto = getTransformater().transformToDTO(entity);
		logger.info("{} updated successfully. ", dto.getClass());
		return dto;
	}
	
	@Override
	public void doBeforeValidation(D dto) {}

	@Override
	public void doValidate(D dto) {}

	@Override
	public void doBeforeTransformation(D dto) {}

	@Override
	public void doAfterTransformation(E entity) {}

	@Override
	public void doFeforePersist(E entity) {}
	
	@Override
	public void doAfterPersist(E entity) {}
}

