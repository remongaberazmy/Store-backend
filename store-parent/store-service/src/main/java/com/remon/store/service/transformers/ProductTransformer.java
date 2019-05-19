package com.remon.store.service.transformers;

import com.remon.store.common.dto.ProductDTO;
import com.remon.store.data.models.ProductEB;
import com.remon.store.service.mapping.StoreMapper;

public interface ProductTransformer extends StoreMapper<ProductEB, ProductDTO>{

}
