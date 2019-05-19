package com.remon.store.service.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.remon.store.common.dto.ProductDTO;
import com.remon.store.common.dto.ProductReportDTO;
import com.remon.store.common.query.ProductCriteriaFilter;
import com.remon.store.data.base.DAO;
import com.remon.store.data.dao.ProductDAO;
import com.remon.store.data.models.ProductEB;
import com.remon.store.service.base.AbstractCrudService;
import com.remon.store.service.mapping.StoreMapper;
import com.remon.store.service.transformers.ProductReportTransformer;
import com.remon.store.service.transformers.ProductTransformer;
import com.remon.store.service.utils.DateUtils;
import com.remon.store.service.utils.PDFGenerator;

@Transactional
@Service("productService")
public class ProductServiceImpl extends AbstractCrudService<ProductEB, ProductDTO, Long, ProductCriteriaFilter> implements ProductService{

	@Autowired
	private ProductTransformer productTransformer;
	
	@Autowired
	private ProductReportTransformer productReportTransformer;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public List<ProductDTO> getProducts() {
		ProductCriteriaFilter cf = new ProductCriteriaFilter();
		List<ProductEB> products = productDAO.getEntityListByCriteriaQueryFilter(cf);
		return productTransformer.transformToDTO(products);
	}
	
	@Override
	public List<ProductReportDTO> getMonthlySoldProducts(Integer month, Integer year) {
		ProductCriteriaFilter cf = new ProductCriteriaFilter();
		productDAO.enableMonthlyFilter(month, year);
		List<ProductEB> products = productDAO.getEntityListByCriteriaQueryFilter(cf);
		return productReportTransformer.transformToDTO(products);
	}
	
	public void exportPDFReport(Integer month, Integer year, HttpServletRequest request, HttpServletResponse response) {
		List<ProductReportDTO> productReports = getMonthlySoldProducts(month, year);
		try {
			PDFGenerator.exportProductReport(productReports, DateUtils.formatDate(month, year), request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public StoreMapper<ProductEB, ProductDTO> getTransformater() {
		return productTransformer;
	}

	@Override
	public DAO<ProductEB, Long, ProductCriteriaFilter> getDAO() {
		return productDAO;
	}

}
