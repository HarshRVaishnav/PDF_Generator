package com.example.demo.service;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Teacher;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
@Service
public class PdfGenerator {
	
	private List<Teacher> list;

	public PdfGenerator(List<Teacher> list) {
		this.list = list;
	}

	public void formattingPdf(PdfPTable pt) {

		PdfPCell pc = new PdfPCell();
		pc.setBackgroundColor(Color.DARK_GRAY);
		pc.setPadding(1);

		Font font = new Font();
		font.setColor(Color.black);

		pc.setPhrase(new Phrase("id", font));

		pt.addCell(pc);

		pc.setPhrase(new Phrase("Name", font));
		pt.addCell(pc);
		pc.setPhrase(new Phrase("Departent", font));
		pt.addCell(pc);
		pc.setPhrase(new Phrase("salary", font));
		pt.addCell(pc);

	}

	private void addtablefield(PdfPTable pt2) {
		for (Teacher t : list) {
			pt2.addCell(t.getDepartment());
			pt2.addCell(t.getName());
			pt2.addCell(String.valueOf(t.getId()));
			pt2.addCell(String.valueOf(t.getSalary()));
		}
	}

	public void exportpdf(HttpServletResponse response) throws IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
	         
		
		document.open();
        Font font = FontFactory.getFont(FontFactory.TIMES_BOLDITALIC);
        font.setSize(13);
        font.setColor(Color.BLACK);
        
        Paragraph pa = new Paragraph("list of Teachers",font);
        pa.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(pa);
        
        PdfPTable pTable = new PdfPTable(4);
        pTable.setWidthPercentage(100f);
        pTable.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f});
        pTable.setSpacingBefore(9);
        
        formattingPdf(pTable);
        addtablefield(pTable);
        document.add(pTable);
        document.close();
	}
	
}
