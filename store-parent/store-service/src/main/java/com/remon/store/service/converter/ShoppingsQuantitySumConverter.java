package com.remon.store.service.converter;

import java.util.List;

import org.dozer.CustomConverter;
import org.dozer.DozerConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.remon.store.data.models.ShoppingEB;

@Component("shoppingsQuantitySumConverter")
@Qualifier("dozerCustomConvertersWithId")
public class ShoppingsQuantitySumConverter extends DozerConverter<List<ShoppingEB>, Double> implements CustomConverter{

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ShoppingsQuantitySumConverter(){
		super((Class<List<ShoppingEB>>) (Class) List.class, Double.class);
	}

	@Override
	public Double convertTo(List<ShoppingEB> shoppings, Double quantity) {
		quantity = 0.0;
		for(ShoppingEB shopping : shoppings) {
			quantity += shopping.getQuantity();
		}
		return quantity;
	}

	@Override
	public List<ShoppingEB> convertFrom(Double source, List<ShoppingEB> destination) {
		return null;
	}

}
