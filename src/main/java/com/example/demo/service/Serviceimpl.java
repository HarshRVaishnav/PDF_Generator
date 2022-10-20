package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.IRepo;
import com.example.demo.entity.Teacher;
@Service
public class Serviceimpl implements IService, CommandLineRunner{

	private IRepo irepo;
	@Autowired
	public Serviceimpl(IRepo irepo) {
		this.irepo = irepo;
	}

	
	@Override
	public List<Teacher> getAllTeacher() {
		List<Teacher> findAll = irepo.findAll();
		return findAll;
	}

	@Override
	public List<Teacher> saveAllTeacher(List<Teacher> teachers) {
		return irepo.saveAll(teachers);
	}

	@Override
	public void deleteByName(String name) {
		irepo.deleteByName(name);
	}

	@Override
	public String updateByName(Integer id, String name) {
		Teacher findById = irepo.findById(id).get();
		findById.setName(name);
		irepo.save(findById);
		return "record updated";
	}

	@Override
	public String update(Integer id, Teacher teacher) {
		Teacher teacher2 = irepo.findById(id).get();
		teacher2.setName(teacher.getName());
		teacher2.setSalary(teacher.getSalary());
		teacher2.setDepartment(teacher.getDepartment());
		irepo.save(teacher2);
		return "Employee Updated";
	}


	@Override
	public void run(String... args) throws Exception {
		
//		List<Teacher> teacher = List.of(new Teacher().getName(),new Teacher().getDepartment("English"),
//				n
//		
		
		
		
	}

	
	
	
	
	
}
