package com.ra.busBooking.DTO;

import java.sql.Date;

public class ReservationDTO {

	
	private String filterDate;
	
	private String to;
	
	private String from;


	public String getFilterDate() {
		return filterDate;
	}

	public void setFilterDate(String filterDate) {
		this.filterDate = filterDate;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}
	
	
	
}
//Design Principles Used:
//Encapsulation: Both classes encapsulate their data fields and provide getter and setter methods to access and modify them. This encapsulation helps maintain data integrity and hides internal implementation details.
//Separation of Concerns: Each class focuses solely on representing a specific type of data (feedback or reservation) and does not contain any business logic. This separation of concerns enhances code readability and maintainability.
//SOLID Principles Violated:
//Single Responsibility Principle (SRP): Both classes violate the SRP slightly because they contain multiple data fields representing different aspects of feedback or reservation. While it's common for DTOs to represent multiple related pieces of data, having too many responsibilities within a single class can lead to maintainability issues.
//Open/Closed Principle (OCP): These classes are not designed to be open for extension but rather for modification. If new requirements arise that necessitate changes to the DTO structure or behavior, the classes would need to be modified directly.