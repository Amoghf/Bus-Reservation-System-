package com.ra.busBooking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String role;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	
}
//Design Principles Used:
//Single Responsibility Principle (SRP): The class seems to follow SRP by representing a single concept - a role. It encapsulates attributes and methods related to defining a role.
//SOLID Principles Used:
//Encapsulation: The class encapsulates its data by providing private fields and public getter/setter methods, promoting data integrity and control over access.
//Suggestions for Improvement:
//Dependency Inversion Principle (DIP): Currently, the class does not directly violate the Dependency Inversion Principle, as it doesn't have any dependencies. However, if the application grows and requires interaction with other components, it's important to ensure that dependencies are abstracted away to adhere to DIP.