package com.ra.busBooking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Feedback")
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int rating;
	private String emailId;
	private String name;
	private String comments;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	

}
//Design Principles Used:
//Single Responsibility Principle (SRP): The class seems to adhere to the SRP by representing a single concept - feedback. It encapsulates attributes and methods related to feedback only.
//SOLID Principles Used:
//Encapsulation: The class encapsulates its data by providing private fields and public getter/setter methods, promoting data integrity and control over access.
//SOLID Principles Violated:
//Dependency Inversion Principle (DIP): The class directly depends on concrete types such as int and String for its attributes. It would be better to depend on abstractions or interfaces instead of concrete implementations.