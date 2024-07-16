package fr.diginamic.hello.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import fr.diginamic.hello.dto.DepartmentDto;
import fr.diginamic.hello.entities.City;
import fr.diginamic.hello.entities.Department;
import fr.diginamic.hello.services.DepartmentService;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentServ;
	//Envoyer un fichier PDF
	
	@GetMapping("/{code}/file")
	public void fileCityPdf(@PathVariable String code, HttpServletResponse response) throws IOException, DocumentException {
		response.setHeader("Content-Disposition", "attachment; filename=\"fichierPdf.pdf\"");
		Department department = departmentServ.findByCode(code);
		
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		document.addTitle("Department : "+ code);
		document.newPage();
		BaseFont baseFont = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.EMBEDDED);
		Phrase p1 =  new Phrase("Code departement : "  + department.getCode() + "\n Liste des villes  \n", new Font(baseFont, 32.0f, 1, new BaseColor(0, 51, 80)));
		List<City> cities = department.getCities();
		Phrase p2 = new Phrase(" Nom de la ville | Population \n" , new Font(baseFont, 32.0f, 1, new BaseColor(0, 51, 80)));
		for(City c : cities) {
			Phrase p3 = new Phrase(c.getName() + " | "+ c.getPopulation()+"\n", new Font(baseFont, 32.0f, 1, new BaseColor(0, 51, 80)));
		}
		
		document.add(p1);
		document.close();
		
		response.flushBuffer();
	}
}
