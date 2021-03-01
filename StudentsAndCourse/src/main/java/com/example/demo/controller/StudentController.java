package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.StudentRepo;
import com.example.demo.model.Student;

@RestController
public class StudentController
{
	@Autowired
	StudentRepo repo;
	
	@PostMapping("/addStudent")
	public Student addStudent(Student student)
	{
		repo.save(student);
		return student;
	}
	
	@GetMapping("/students")
	public List<Student> getStudents()
	{
		return repo.findAll();
	}
	
	@GetMapping("/students/{sid}")
	public Optional<Student> getStudent(@PathVariable("sid") int sid)
	{
		return repo.findById(sid);
	}
	
	@DeleteMapping("/deleteStudent/{sid}")
	public String deleteStudent(@PathVariable("sid") int sid)
	{
		repo.deleteById(sid);
		return "deleted";
	}
	
	@PutMapping("/updateStudent")
	public Student updateStudent(Student student)
	{
		repo.save(student);
		return student;
	}

}
