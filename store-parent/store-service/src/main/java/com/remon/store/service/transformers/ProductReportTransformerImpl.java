package com.remon.store.service.transformers;

import org.springframework.stereotype.Component;

import com.remon.store.common.dto.ProductReportDTO;
import com.remon.store.data.models.ProductEB;
import com.remon.store.service.mapping.StoreMapperImpl;

@Component("productReportTransformer")
public class ProductReportTransformerImpl extends StoreMapperImpl<ProductEB, ProductReportDTO> implements ProductReportTransformer{

	public ProductReportTransformerImpl() {
		super(ProductEB.class, ProductReportDTO.class);
	}
}
