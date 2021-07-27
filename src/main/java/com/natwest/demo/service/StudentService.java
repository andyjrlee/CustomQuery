package com.natwest.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.natwest.demo.domain.Student;
import com.natwest.demo.repo.StudentRepo;

@Service
public class StudentService {

	private StudentRepo repo;
	
	
	
	
	public StudentService(StudentRepo repo) {
		this.repo = repo;
	}
	
	// create
	public Student create(Student student) {
		return this.repo.saveAndFlush(student);
		}

	// read
	
	public List<Student> read(){
		return this.repo.findAll();
	}

	public Student readById(Long id) {
		return this.repo.getById(id);
		
	}
	// update
	public Student update(Long id, Student student) {
		//firstname, lastname, age, email
		Student existing = this.repo.getById(id);
		existing.setFirstName(Student.getFirstName());
		existing.setLastName(Student.getLastName());
		existing.setAge(Student.getAge());
		existing.setEmail(Student.getEmail());
		
	}
}
