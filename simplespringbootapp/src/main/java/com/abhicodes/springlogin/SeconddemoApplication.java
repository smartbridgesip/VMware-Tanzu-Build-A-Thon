package com.abhicodes.springlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SeconddemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SeconddemoApplication.class, args);
		
		Student s = context.getBean(Student.class);
		s.display();
	}

}
