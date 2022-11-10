package com.greatlearning.students.service;

import java.util.List;

import com.greatlearning.students.entity.Student;

public interface StudentService
{
	List<Student> findAll();

	Student findById(int id);
	
	void save(Student newStudent);
	
	void deleteById(int id);
	
	List<Student> searchBy(String name, String course);
}
