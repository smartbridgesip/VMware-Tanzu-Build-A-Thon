package com.abhicodes.springlogin;

import org.springframework.stereotype.Component;

@Component
public class Bag {
	private String model;
	private String color;
	public Bag(){
		System.out.println("Bag Object Created");
	}
}
