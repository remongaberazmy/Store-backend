package com.remon.store.service.services;

import com.remon.store.common.dto.ShoppingDTO;
import com.remon.store.common.query.ShoppingCriteriaFilter;
import com.remon.store.data.models.ShoppingEB;
import com.remon.store.service.base.CrudService;

public interface ShoppingService extends CrudService<ShoppingEB, ShoppingDTO, Long, ShoppingCriteriaFilter>{

}
