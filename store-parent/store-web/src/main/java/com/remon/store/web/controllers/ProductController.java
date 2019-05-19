package com.remon.store.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.remon.store.common.dto.ProductDTO;
import com.remon.store.common.dto.ProductReportDTO;
import com.remon.store.service.services.ProductService;

@RestController
@RequestMapping(value = "/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ProductDTO> getProducts(){
		return productService.getProducts();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/monthly", method = RequestMethod.GET)
	public List<ProductReportDTO> getProductsForMonth(@RequestParam("month") Integer month, @RequestParam("year") Integer year){
		return productService.getMonthlySoldProducts(month, year);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/monthly/export", method = RequestMethod.GET)
	public void exportPDFProductsForMonth(@RequestParam("month") Integer month, @RequestParam("year") Integer year, 
			HttpServletRequest request, HttpServletResponse response){
		productService.exportPDFReport(month, year, request, response);
	}
}
