package com.remon.store.service.transformers;

import org.springframework.stereotype.Component;

import com.remon.store.common.dto.ProductDTO;
import com.remon.store.data.models.ProductEB;
import com.remon.store.service.mapping.StoreMapperImpl;

@Component("productTransformer")
public class ProductTransformerImpl extends StoreMapperImpl<ProductEB, ProductDTO> implements ProductTransformer{

	public ProductTransformerImpl() {
		super(ProductEB.class, ProductDTO.class);
	}
}
