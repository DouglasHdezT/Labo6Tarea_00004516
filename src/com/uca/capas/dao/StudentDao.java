package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Student;

public interface StudentDao {
	
	//Todos los estudiantes
	public List<Student> findAll() throws DataAccessException;
	
	//Uno solo
	public Student findOne(Integer code) throws DataAccessException;
	
	//Guardar un student
	public int save(Student s, Integer newRow) throws DataAccessException;
	
	//Borrar uno
	public int delete(Student s) throws DataAccessException;
	
}
