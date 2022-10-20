package com.example.demo.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Teacher;
import com.example.demo.service.PdfGenerator;
import com.example.demo.service.Serviceimpl;

@RestController
@RequestMapping("/teacher")

public class Tcontroller {
  @Autowired
	private Serviceimpl serviceimpl;
  
   @GetMapping("/findbyname")
	public List<Teacher> findAllByName(@PathVariable(name="c") String name){
		List<Teacher> allTeacher = serviceimpl.getAllTeacher();
		return allTeacher;
	}
	@PostMapping("/saveAll")
	public String saveAllTeacher(@RequestBody List<Teacher> teachers) {
		if(teachers!=null) {
			serviceimpl.saveAllTeacher(teachers);
        return "Record saved";
		}else {
			return "Record not added please check";
		}	
	}
	@DeleteMapping("/deletename")
	public void deleteByName(@RequestParam String name) {
		serviceimpl.deleteByName(name);
	}
	@PatchMapping("/updatename/{id}")
	public String updateByName(@PathVariable Integer id,@RequestParam String name) {
		return serviceimpl.updateByName(id, name);	
	}
	@PutMapping("/update/{id}")
	public String update(@PathVariable Integer id,@RequestParam Teacher teacher) {
		return serviceimpl.update(id, teacher);
		
	}
	@GetMapping ("/export/pdf")
	public void exportToPdf (HttpServletResponse response) throws IOException {
		response.setContentType("application/pdf");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		df.format(new Date());
		 String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=zzz" + headerKey + ".pdf";
	        response.setHeader(headerKey, headerValue);
	        
	        List<Teacher> list = serviceimpl.getAllTeacher();
	        PdfGenerator pg = new PdfGenerator(list);
	        pg.exportpdf(response);
	        
	}
	
}
