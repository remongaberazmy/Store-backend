package com.remon.store.service.utils;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.decimal4j.util.DoubleRounder;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.remon.store.common.dto.ProductReportDTO;

public class PDFView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		@SuppressWarnings("unchecked")
		List<ProductReportDTO> productReport = (List<ProductReportDTO>) model.get("productReport");
		Double totalPrice = (Double) model.get("totalPrice");
		String date = (String) model.get("date");
		
		Font paragraphBoldFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 14, BaseColor.BLACK);
		Font headerFont = FontFactory.getFont(FontFactory.COURIER, 10, BaseColor.WHITE);
		Font contentFont = FontFactory.getFont(FontFactory.COURIER, 10, BaseColor.BLACK);
		
		Paragraph titleParagraph = new Paragraph("Product price percentage report for month " + date, paragraphBoldFont);
		
		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100);
		table.setPaddingTop(0);
		
		Stream.of("Name", "Description", "Price", "Quantity", "Price Percentage")
	      .forEach(columnTitle -> {
	        addCell(table, columnTitle, PdfPCell.NO_BORDER, headerFont, BaseColor.GRAY);
	    });
		
		for(ProductReportDTO product : productReport) {
			Stream.of(product.getName(), product.getDescription(), product.getPrice().toString(), product.getQuantity().toString(), pricePercentage(product, totalPrice))
			.forEach(columnTitle -> {
				addCell(table, columnTitle, PdfPCell.BOX, contentFont, BaseColor.WHITE);
			});
		}
		
		document.add(titleParagraph);
		document.add(Chunk.NEWLINE);
		document.add(table);
		
	}
	
	private String pricePercentage(ProductReportDTO product, Double totalPrice) {
		Double percentage = ((product.getPrice() * product.getQuantity()) / totalPrice) * 100;
		if(percentage > 0)
			return String.valueOf(DoubleRounder.round(percentage, 2)) + "%";
		else
			return "0.0%";
	}

	private void addCell(PdfPTable table, String title, int border, Font font, BaseColor backgroundColor) {
    	PdfPCell cell = new PdfPCell();
    	cell.setBorder(border);
    	cell.setBorderWidthBottom(0.5F);
    	cell.setPhrase(new Phrase(title, font));
    	cell.setBackgroundColor(backgroundColor);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setPaddingTop(10);
    	cell.setPaddingBottom(10);
        table.addCell(cell);
    }

}
