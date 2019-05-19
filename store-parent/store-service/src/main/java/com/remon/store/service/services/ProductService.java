package com.remon.store.service.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.remon.store.common.dto.ProductDTO;
import com.remon.store.common.dto.ProductReportDTO;
import com.remon.store.common.query.ProductCriteriaFilter;
import com.remon.store.data.models.ProductEB;
import com.remon.store.service.base.CrudService;

public interface ProductService extends CrudService<ProductEB, ProductDTO, Long, ProductCriteriaFilter>{

	public List<ProductDTO> getProducts();
	
	public List<ProductReportDTO> getMonthlySoldProducts(Integer month, Integer year);
	
	public void exportPDFReport(Integer month, Integer year, HttpServletRequest request, HttpServletResponse response);
}
