package com.ra.busBooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ra.busBooking.DTO.UserRegisteredDTO;
import com.ra.busBooking.service.DefaultUserService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	 private DefaultUserService userService;

	    public RegistrationController(DefaultUserService userService) {
	        super();
	        this.userService = userService;
	    }

	    @ModelAttribute("user")
	    public UserRegisteredDTO userRegistrationDto() {
	        return new UserRegisteredDTO();
	    }

	    @GetMapping
	    public String showRegistrationForm() {
	        return "register";
	    }

	    @PostMapping
	    public String registerUserAccount(@ModelAttribute("user") 
	              UserRegisteredDTO registrationDto) {
	        userService.save(registrationDto);
	        return "redirect:/login";
	    }
}
//Design Principles Used:
//Single Responsibility Principle (SRP): The class is responsible for handling user registration-related actions, such as displaying the registration form and registering new users.
//Dependency Injection: The controller uses constructor injection to inject an instance of DefaultUserService.
//SOLID Principles Violated:
//Open/Closed Principle (OCP): The class could be closed for modification by extracting the logic for user registration into a separate service or component. This would make it easier to extend the behavior without modifying existing code.