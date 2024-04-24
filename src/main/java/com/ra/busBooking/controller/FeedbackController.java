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
