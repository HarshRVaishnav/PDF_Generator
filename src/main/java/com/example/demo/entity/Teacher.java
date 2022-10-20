package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Teacher {
@Id
@GeneratedValue ( strategy = GenerationType.AUTO ) 
@Column
  	private Integer id;
@Column	
	private String name;
@Column	
	private Integer salary;
@Column	
	private String Department;

	public Teacher(String name, Integer salary, String department) {
		super();
		this.name = name;
		this.salary = salary;
		Department = department;
	}
	
	public Teacher () {
		
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}
	
}
