package com.remon.store.service.mapping;

import java.util.List;

import com.remon.store.common.base.AbstractDTO;
import com.remon.store.data.base.AbstractEntity;

public interface StoreMapper<E extends AbstractEntity<?>, D extends AbstractDTO<?>>{

	E transformToEntity(D dto);
	void transformToEntity(D dto, E entity);
	List<E> transformToEntity(List<D> dtos);
	
	D transformToDTO(E entity);
	void transformToDTO(E entity, D dto);
	List<D> transformToDTO(List<E> entities);
	
}
