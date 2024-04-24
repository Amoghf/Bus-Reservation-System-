package com.ra.busBooking.DTO;

import java.util.Collection;
import java.util.Set;

import com.ra.busBooking.model.Role;

public class UserRegisteredDTO {

	
    private String name;
	
	private String email_id;
	
	private String password;
	
	private String role;
	
	

	public UserRegisteredDTO() {
		super();
	}

	public UserRegisteredDTO(String role) {
		super();
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPassword() {
		return password;
	}

	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
//Design Principles Used:
//Encapsulation: The class encapsulates user registration data fields (name, email, password, role) and provides getter and setter methods to access and modify them. This encapsulation helps maintain data integrity and hides internal implementation details.
//SOLID Principles Violated:
//Single Responsibility Principle (SRP): The class slightly violates the SRP because it contains multiple data fields representing different aspects of user registration. While it's common for DTOs to represent multiple related pieces of data, having too many responsibilities within a single class can lead to maintainability issues.