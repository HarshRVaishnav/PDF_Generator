package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Teacher;
@Repository
public interface IRepo extends JpaRepository<Teacher, Integer>{
	
	
	
	@Query(value ="delete from Teacher where name = :name", nativeQuery=true)
	public void deleteByName(@Param("name") String name);
    
	
}
