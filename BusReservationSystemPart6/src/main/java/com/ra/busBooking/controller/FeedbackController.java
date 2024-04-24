package com.ra.busBooking.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ra.busBooking.DTO.FeedbackDTO;
import com.ra.busBooking.model.Feedback;
import com.ra.busBooking.model.User;
import com.ra.busBooking.repository.FeedbackRepo;
import com.ra.busBooking.repository.UserRepository;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	FeedbackRepo feedbackRepo;

	@GetMapping
	public String feedbackForm( Model model) {
		FeedbackDTO dto =new FeedbackDTO();
		dto.setEmailId(returnUsername().get("email"));
		dto.setName(returnUsername().get("name"));
		model.addAttribute("userDetails", returnUsername().get("name") );
		model.addAttribute("feedback", dto);
		return "feedback";
	}
	@PostMapping
	public String saveFeedback(@ModelAttribute("feedback") FeedbackDTO feedbackDTO) {
		Map<String , String> map= returnUsername();
    	Feedback feedback = new Feedback();
    	feedback.setComments(feedbackDTO.getComments());
    	feedback.setRating(feedbackDTO.getRating());
    	feedback.setName(map.get("name"));
    	feedback.setEmailId(map.get("email"));
    	feedbackRepo.save(feedback);
        return "redirect:/feedback?success";
	}
	
	private Map<String, String> returnUsername() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
        UserDetails user = (UserDetails) securityContext.getAuthentication().getPrincipal();
		User users = userRepository.findByEmail(user.getUsername());
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", users.getEmail());
		map.put("name", users.getName());
		return map;
	}
}
//Design Principles Used:
//Single Responsibility Principle (SRP): The class is responsible for handling feedback-related actions, such as displaying the feedback form and saving feedback.
//Dependency Injection: The controller uses dependency injection to inject instances of UserRepository and FeedbackRepo.
//SOLID Principles Violated:
//Open/Closed Principle (OCP): The class could be closed for modification by extracting the logic for retrieving the current user's details into a separate method or component. This would make it easier to extend the behavior without modifying existing code.
//Dependency Inversion Principle (DIP): The class directly depends on concrete implementations of UserRepository and FeedbackRepo, violating the DIP. It would be better to depend on abstractions (interfaces) instead.