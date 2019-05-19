package com.remon.store.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.remon.store.common.dto.ShoppingDTO;
import com.remon.store.common.query.ShoppingCriteriaFilter;
import com.remon.store.data.base.DAO;
import com.remon.store.data.dao.ShoppingDAO;
import com.remon.store.data.models.ShoppingEB;
import com.remon.store.service.base.AbstractCrudService;
import com.remon.store.service.mapping.StoreMapper;
import com.remon.store.service.transformers.ShoppingTransformer;

@Transactional
@Service("shoppingService")
public class ShoppingServiceImpl extends AbstractCrudService<ShoppingEB, ShoppingDTO, Long, ShoppingCriteriaFilter> implements ShoppingService{

	@Autowired
	private ShoppingDAO shoppingDAO;
	
	@Autowired
	private ShoppingTransformer shoppingTransformer;
	
	@Override
	public StoreMapper<ShoppingEB, ShoppingDTO> getTransformater() {
		return shoppingTransformer;
	}

	@Override
	public DAO<ShoppingEB, Long, ShoppingCriteriaFilter> getDAO() {
		return shoppingDAO;
	}

}
