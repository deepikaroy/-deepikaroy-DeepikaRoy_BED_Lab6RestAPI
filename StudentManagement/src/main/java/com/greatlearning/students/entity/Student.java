package com.greatlearning.students.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="student")
public class Student 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	private String firstName;

	private String lastName;

	private String country;

	private String course;
	
	public Student(String firstName,  String lastName, String country, String course)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.country = course;
	}


}
