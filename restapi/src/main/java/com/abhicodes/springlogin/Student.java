package com.abhicodes.springlogin;

import java.util.UUID;

public class Student {
	private final String rollno;
	private String name;
	
	public Student(String rollno, String name) {
		this.rollno = rollno;
		this.name = name;
	}
	public Student(String name) {
		this.rollno = UUID.randomUUID().toString();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRollno() {
		return rollno;
	}
	
}
