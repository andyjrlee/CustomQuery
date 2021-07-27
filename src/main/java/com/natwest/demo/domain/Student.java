package com.natwest.demo.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String First_Name;
	private String Last_Name;
	private int Age;
	private String Email;

	public Student() {
		super();
	}

	public Student(long id, String first_Name, String last_Name, @NotNull int age,
			@javax.validation.constraints.Email String email) {
		super();
		this.id = id;
		First_Name = first_Name;
		Last_Name = last_Name;
		Age = age;
		Email = email;
	}

	public Student(String first_Name, String last_Name, @NotNull int age,
			@javax.validation.constraints.Email String email) {
		super();
		First_Name = first_Name;
		Last_Name = last_Name;
		Age = age;
		Email = email;
	}

	private long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}

	public String getFirst_Name() {
		return First_Name;
	}

	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}

	public String getLast_Name() {
		return Last_Name;
	}

	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", First_Name=" + First_Name + ", Last_Name=" + Last_Name + ", Age=" + Age
				+ ", Email=" + Email + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Age, Email, First_Name, Last_Name, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Age == other.Age && Objects.equals(Email, other.Email) && Objects.equals(First_Name, other.First_Name)
				&& Objects.equals(Last_Name, other.Last_Name) && id == other.id;
	}
	
	
	
	
}
