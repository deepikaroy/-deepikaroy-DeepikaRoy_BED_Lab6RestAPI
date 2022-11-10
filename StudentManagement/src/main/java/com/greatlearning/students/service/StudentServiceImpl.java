package com.greatlearning.students.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.students.entity.Student;
import com.greatlearning.students.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public List<Student> findAll()
	{
		return studentRepo.findAll();
	}

	@Override
	public Student findById(int id) 
	{
		return studentRepo.findById(id).get();
	}

	@Override
	public void save(Student newStudent) 
	{
		studentRepo.save(newStudent);
	}

	@Override
	public void deleteById(int id)
	{
		studentRepo.deleteById(id);
	}

	@Override
	public List<Student> searchBy(String name, String course)
	{
		List<Student> ll = new ArrayList<Student>();
		 ll.add(studentRepo.findById(1).get());
		 return ll;
	}

}
