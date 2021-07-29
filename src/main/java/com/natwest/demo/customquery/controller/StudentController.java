package com.natwest.demo.customquery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natwest.demo.customquery.domain.Student;
import com.natwest.demo.customquery.service.StudentService;

@RestController // Handles our requests/responses
@RequestMapping("/student") // http://localhost:9002/student/..
public class StudentController {

	@Autowired
	private StudentService service;
	
	@GetMapping("/test")
	public String testRequest() {
		return "This is our test api..!";
	}
	
	// create
	@PostMapping("/create")
	public ResponseEntity<Student> create(@RequestBody Student student ) {
		return new ResponseEntity<Student>(this.service.create(student), HttpStatus.CREATED);
	}
	
	//read
	@GetMapping("/read")
	public ResponseEntity<List<Student>> read() {
		return new ResponseEntity<List<Student>>(this.service.read(), HttpStatus.OK);
	}
	
	//read id
	@GetMapping("/read/{id}")
	public ResponseEntity<Student> readById(@PathVariable Long id) {
		return new ResponseEntity<Student>(this.service.readById(id), HttpStatus.OK);
		
	}
	
	//update	
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student) {
		return new ResponseEntity<Student>(this.service.update(id, student), HttpStatus.ACCEPTED);
	}
	
	//delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id){
		return new ResponseEntity<Boolean>(this.service.delete(id), HttpStatus.NO_CONTENT);
	}
	
	// Find by name
	@GetMapping("/readName/{name}")
	public ResponseEntity<List<Student>> findByName(@PathVariable String name){
		return new ResponseEntity<List<Student>>(this.service.readByName(name), HttpStatus.OK);
	}
}
