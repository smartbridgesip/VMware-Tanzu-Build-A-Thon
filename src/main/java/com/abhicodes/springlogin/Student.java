package com.abhicodes.springlogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {
	private int sid;
	private String sname;
	private String course;
	
	@Autowired
	Laptop laptop;
	
	public Student() {
		System.out.println("Object Student Created");
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public void display() {
		System.out.println("In student class, display method");
		laptop.compile();
	}

}
