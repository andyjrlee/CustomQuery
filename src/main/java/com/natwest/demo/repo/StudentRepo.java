package com.natwest.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.natwest.demo.domain.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

	
	// By standard convention, we use '?1' even when we have a single index (input parameter)
	// nativeQuery = true is 'Non-JPQL'
		@Query(value = "SELECT * FROM Student WHERE first_name =?1", nativeQuery = true)
	List<Student> findByName(String name);
	
	
	
	
}
