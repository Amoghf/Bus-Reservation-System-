package com.ra.busBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ra.busBooking.DTO.UserLoginDTO;

import com.ra.busBooking.service.DefaultUserService;

@Controller
@RequestMapping("/login")
public class LoginController {
@Autowired
	private DefaultUserService userService;

    @ModelAttribute("user")
    public UserLoginDTO userLoginDTO() {
        return new UserLoginDTO();
    }
    
	@GetMapping
	public String login() {
		return "login";
	}
	
	@PostMapping
	public void  loginUser(@ModelAttribute("user") 
	UserLoginDTO userLoginDTO) {
	 userService.loadUserByUsername(userLoginDTO.getUsername());
	}
}
//Design Principles Used:
//Single Responsibility Principle (SRP): The class is responsible for handling user login-related actions, such as displaying the login page and authenticating users.
//Dependency Injection: The controller uses dependency injection to inject instances of DefaultUserService.
//SOLID Principles Violated:
//Single Responsibility Principle (SRP): The loginUser method should ideally delegate the responsibility of authenticating the user to a service or component dedicated to user authentication. Currently, it directly invokes the loadUserByUsername method of the DefaultUserService within the controller, violating SRP. Controllers should primarily be responsible for handling HTTP requests and responses, not business logic like user authentication.
