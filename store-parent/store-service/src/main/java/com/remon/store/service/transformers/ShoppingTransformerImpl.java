package com.remon.store.service.transformers;

import org.springframework.stereotype.Component;

import com.remon.store.common.dto.ShoppingDTO;
import com.remon.store.data.models.ShoppingEB;
import com.remon.store.service.mapping.StoreMapperImpl;

@Component("shoppingTransformer")
public class ShoppingTransformerImpl extends StoreMapperImpl<ShoppingEB, ShoppingDTO> implements ShoppingTransformer{

	public ShoppingTransformerImpl() {
		super(ShoppingEB.class, ShoppingDTO.class);
	}
}
