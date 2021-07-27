package com.natwest.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.natwest.demo.domain.Student;
import com.natwest.demo.service.StudentService;

public class StudentController {

	@Autowired
	private StudentService service;
	
	@GetMapping("/test")
	public String testRequest() {
		return "This is our test api..!";
	}
	
	// create
	@PostMapping("/create")
	public ResponseEntity<List<Student>> create(@RequestBody ) {
		return new ResponseEntity<Student>(this.service.create(student), HttpStatus.CREATED);
	}
	
	//read
	@GetMapping("/read")
	public ResponseEntity<List<Student>> read() {
		return new ResponseEntity<List<Student>>(this.service.read(), HttpStatus.OK);
		
	}
	
	//read id
	@GetMapping("/read/{id}")
	public ResponseEntiry<Student> readById(@PathVariable Long id) {
		return new ResponseEntity<Student>(this.readById(Long id), HttpStatus.OK);
		
	}
}
