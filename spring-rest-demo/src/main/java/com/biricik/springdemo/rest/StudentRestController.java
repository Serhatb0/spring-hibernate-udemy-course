package com.biricik.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.PostConstruct;
import com.biricik.springdemo.entity.Student;
import com.github.javafaker.Faker;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students;

	@PostConstruct
	public void loadData() {
		Faker faker = new Faker();
		students = new ArrayList<Student>();

		for (int i = 0; i < 10; i++) {
			students.add(new Student(faker.name().firstName(), faker.name().lastName()));
		}
	}

	@GetMapping("/students")
	public List<Student> getStudents() {

		return students;
	}
	
	// define endpoint for "/studetns/{studentId}" - return student at index
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		if(studentId >= students.size() || studentId < 0) {
			throw new StudentNotFoundException("Student id not Found " + studentId);
		}
		return students.get(studentId);
	}
	
	
	
	
	

}
