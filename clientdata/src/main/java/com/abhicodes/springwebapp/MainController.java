package com.abhicodes.springwebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String form() {
		return "form";
	}
	@RequestMapping(value="/success",method=RequestMethod.POST)
	public ModelAndView success(User user) {
		ModelAndView mav = new ModelAndView("success");
		System.out.println(user.getId());
		System.out.println(user.getEmail());
		System.out.println(user.getName());
		mav.addObject(user);
		userRepo.save(user);
		return mav;
	}
}
