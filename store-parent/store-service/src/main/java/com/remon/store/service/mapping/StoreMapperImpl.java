package com.remon.store.service.mapping;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.remon.store.common.base.AbstractDTO;
import com.remon.store.data.base.AbstractEntity;

public abstract class StoreMapperImpl<E extends AbstractEntity<?>, D extends AbstractDTO<?>> implements StoreMapper<E, D>{
	
	@Autowired
	private Mapper mapper;
	
	private Class<E> entityClass;
	private Class<D> dtoClass;
	
	public StoreMapperImpl(Class<E> entityClass, Class<D> dtoClass) {
		this.entityClass = entityClass;
		this.dtoClass = dtoClass;
	}

	/*################## Entity ##################*/
	
	@Override
	public E transformToEntity(D dto) {
		return mapper.map(dto, entityClass);
	}

	@Override
	public void transformToEntity(D dto, E entity) {
		mapper.map(dto, entity);
	}
	@Override
	public List<E> transformToEntity(List<D> dtos) {
		List<E> entities = new ArrayList<E>();
		for(D dto : dtos) {
			entities.add(transformToEntity(dto));
		}
		return entities;
	}
	
	
	/*################## DTO ##################*/
	
	@Override
	public D transformToDTO(E entity) {
		return mapper.map(entity, dtoClass);
	}
	@Override
	public void transformToDTO(E entity, D dto) {
		mapper.map(entity, dto);
	}
	@Override
	public List<D> transformToDTO(List<E> entities) {
		List<D> dtos = new ArrayList<D>();
		for(E entity : entities) {
			dtos.add(transformToDTO(entity));
		}
		return dtos;
	}
	
	
}
