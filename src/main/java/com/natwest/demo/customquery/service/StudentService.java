package com.natwest.demo.customquery.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.natwest.demo.customquery.domain.Student;
import com.natwest.demo.customquery.repo.StudentRepo;

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
	public List<Student> read() {
		return this.repo.findAll();
	}

	// read id
	public Student readById(Long id) {
		final Student FOUND = this.repo.findById(id).orElseThrow(() -> {
			return new ResponseStatusException(HttpStatus.NOT_FOUND,
					String.format("No Student found with id: %d ", id));

		});
		return FOUND;

	}

	// update
	public Student update(Long id, Student student) {
		// First_Name, Last_Name, Age, Email
		Student existing = this.repo.getById(id);
		existing.setFirstName(student.getFirstName());
		existing.setLastName(student.getLastName());
		existing.setEmail(student.getEmail());
		existing.setAge(student.getAge());
		Student updated = this.repo.save(existing);
		return updated;

	}

	// Delete
	public Boolean delete(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}

	// Find by name
	public List<Student> readByName(String name) { 
		return this.repo.findByName(name);
	}
}
