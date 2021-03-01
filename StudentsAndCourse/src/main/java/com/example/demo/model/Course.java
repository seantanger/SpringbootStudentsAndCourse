package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="courses")
public class Course 
{
	@Id
	private int cid;
	private String subject;
	
	@OneToMany(mappedBy="course")
	@JsonBackReference
	private List<Student> students;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	
	public Course() {
		super();
	}
	public Course(int cid, String subject) {
		super();
		this.cid = cid;
		this.subject = subject;
	}
	
	
	
}
