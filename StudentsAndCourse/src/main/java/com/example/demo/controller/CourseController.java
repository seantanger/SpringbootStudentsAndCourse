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

import com.example.demo.dao.CourseRepo;
import com.example.demo.model.Course;

@RestController
public class CourseController 
{
	@Autowired
	CourseRepo repo;
	
	@PostMapping("/addCourse")
	public Course addCourse(Course course)
	{
		repo.save(course);
		return course;
	}
	
	@GetMapping("/courses")
	public List<Course> getCourses()
	{
		return repo.findAll();
	}
	
	@GetMapping("/courses/{cid}")
	public Optional<Course> getCourse(@PathVariable("cid") int cid)
	{
		return repo.findById(cid);
	}
	
	@DeleteMapping("/deleteCourse/{cid}")
	public String deleteCourse(@PathVariable("cid") int cid)
	{
		repo.deleteById(cid);
		return "deleted";
	}
	
	@PutMapping("/updateCourse")
	public Course updateCourse(Course course)
	{
		repo.save(course);
		return course;
	}
	

}
