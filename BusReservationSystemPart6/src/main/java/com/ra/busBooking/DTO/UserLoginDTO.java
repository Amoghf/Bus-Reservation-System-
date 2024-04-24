package com.ra.busBooking.DTO;

public class UserLoginDTO {
	
private String username;
	
	private String password;

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
//Design Principles Used:
//Encapsulation: The class encapsulates the login credentials (username and password) and provides getter and setter methods to access and modify them. This encapsulation helps maintain data integrity and hides internal implementation details.
//SOLID Principles Violated:
//Single Responsibility Principle (SRP): The class adheres to the SRP as it has a single responsibility: representing user login credentials. It does not have multiple responsibilities or concerns.
//Open/Closed Principle (OCP): The class is not designed to be open for extension but rather for modification. If new requirements arise that necessitate changes to the DTO structure or behavior, the class would need to be modified directly.