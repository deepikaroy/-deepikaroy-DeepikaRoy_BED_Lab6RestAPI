package com.greatlearning.students.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.students.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>
{
	//List<Student> findByNameAndCourse(String name, String course);
}
