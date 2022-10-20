package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Teacher;

public interface IService {

	public List<Teacher> getAllTeacher();

	public List<Teacher> saveAllTeacher(List<Teacher> teachers); 

	public void deleteByName(String name) ;
	
	public String updateByName (Integer id , String name );  // this is partial updATE so its PATCH
	
	public String update (Integer id , Teacher teacher );  // here we update complete object after fetching it 
															// Teacher means  complete object

	
}	