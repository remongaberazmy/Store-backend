package com.remon.store.service.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.remon.store.common.dto.ProductReportDTO;

public class PDFGenerator {

	public static void exportProductReport(List<ProductReportDTO> productReports, String date, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Double totalPrice = 0.0;
		for(ProductReportDTO product : productReports) {
			totalPrice += product.getPrice() * product.getQuantity();
		}
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("productReport", productReports);
		model.put("totalPrice", totalPrice);
		model.put("date", date);
		PDFView pdf = new PDFView();
		pdf.render(model, request, response);
	}
}
