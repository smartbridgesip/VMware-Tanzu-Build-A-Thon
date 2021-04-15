package com.abhicodes.springlogin;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class
AppController {
	@Autowired 
	private UserRepository userRepo;
	@Autowired
	private JobsRepository jobRepo;
    @Autowired
    private JavaMailSender sender;
	
	@GetMapping("/")
	public String viewHomePage() {
		return "home";
	}
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
	    model.addAttribute("user", new User());
	     
	    return "register";
	}
	@PostMapping("/process_register")
	public String processRegister(User user) {
	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	    userRepo.save(user);
	    try {
	    	sendEmail(user.getEmail());
	    }
	    catch(Exception e) {
	    	System.out.println(e);
	    }
	    return "/dashboard";
	}
	@GetMapping("/dashboard")
	public String listUsers(Model model) {
	    return "dashboard";
	}
	@GetMapping("/apply")
	public String showForm(Model model) {
		model.addAttribute("jobs", new Jobs());
		return "apply";
	}
	@PostMapping("/process_apply")
	public String processApply(Jobs jobs) {
		jobRepo.save(jobs);
		return "display";
	}
	@GetMapping("/display")
	public String displayAppliedJobs(Model model) {
		model.addAttribute("jobs", jobRepo.findAll());
		return "display";
	}
	 private void sendEmail(String email) throws Exception{
	        MimeMessage message = sender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message);
	         
	        helper.setTo(email);
	        helper.setText("Welcome");
	        helper.setSubject("Thanks for Registering");
	         
	        sender.send(message);
	    }
}
