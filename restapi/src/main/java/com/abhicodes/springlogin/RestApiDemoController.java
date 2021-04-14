package com.abhicodes.springlogin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class RestApiDemoController {
	private List<Student> students = new ArrayList<>();
	
	public RestApiDemoController() {
		students.add(new Student("234","Aravind"));
		students.add(new Student("324","Anil"));
	}
	
	@GetMapping("/all")
	Iterable<Student> getStudents(){
		return students;
	}
	@PostMapping("/add")
	Student addStudent(@RequestBody Student stu) {
		students.add(stu);
		return stu;
	}
	@PutMapping("/{rollno}")
	Student updateStudent(@PathVariable String rollno, @RequestBody Student stu) {
		int studentIndex = -1;

	    for (Student s: students) {
	        if (s.getRollno().equals(rollno)) {
	        	studentIndex = students.indexOf(s);
	            students.set(studentIndex, stu);
	        }
	    }

	    return (studentIndex == -1) ? addStudent(stu) : stu;
	}
	@DeleteMapping("/{rollno}")
	void deleteStudent(@PathVariable String rollno) {
		students.removeIf(stu->stu.getRollno().equals(rollno));
	}
}
