package com.greatlearning.students.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.students.entity.Student;
import com.greatlearning.students.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController 
{
	@Autowired
	private  StudentService studentService;

	@GetMapping(value="/list")
	public String listStudents(Model model)
	{
		List<Student> students = studentService.findAll();
		model.addAttribute("Students", students);

		return "list-students";
	}

	@GetMapping("/403")
	public ModelAndView accessDenied(Principal user)
	{
		ModelAndView modelAndView = new ModelAndView();
		String attributeValue = user != null ?
				"Hi "+ user.getName() + ", You do not have permission to access this page!!" : "You do not have permission to access this page!!";				

		modelAndView.addObject("msg", attributeValue);
		modelAndView.setViewName("403");

		return modelAndView;
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model)
	{
		Student student = new Student();

		model.addAttribute("Student", student);

		return "add-student-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id, Model model)
	{
		Student student = studentService.findById(id);

		model.addAttribute("Student", student);

		return "add-student-form";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id) 
	{
		studentService.deleteById(id);

		return "redirect:/student/list";

	}

	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id, 
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("course") String course,
			@RequestParam("country") String country)
	{
		System.out.println(id);
		Student student;

		if (id != 0) 
		{
			student = studentService.findById(id);
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setCourse(course);
			student.setCountry(country);
		}
		else 
		{
			System.out.println("Else Part!!");
			student = new Student(firstName, lastName, course, country);
		}

		studentService.save(student);

		return "redirect:/student/list";

	}
}
