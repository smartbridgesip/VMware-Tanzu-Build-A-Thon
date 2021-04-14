package com.abhicodes.springlogin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
}
