package com.ra.busBooking.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Bookings")
public class Bookings {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int noOfPersons ;
	
	private Double totalCalculated ;
	
	private String filterDate;
	
	private String toDestination;
	
	private String fromDestination;
	
	private String BusName;
	
	private int userId;
	
	private String time;
	
	private String fileName;
	
	private boolean tripStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNoOfPersons() {
		return noOfPersons;
	}

	public void setNoOfPersons(int noOfPersons) {
		this.noOfPersons = noOfPersons;
	}

	public Double getTotalCalculated() {
		return totalCalculated;
	}

	public void setTotalCalculated(Double totalCalculated) {
		this.totalCalculated = totalCalculated;
	}

	public String getFilterDate() {
		return filterDate;
	}

	public void setFilterDate(String filterDate) {
		this.filterDate = filterDate;
	}

	public String getToDestination() {
		return toDestination;
	}

	public void setToDestination(String toDestination) {
		this.toDestination = toDestination;
	}

	public String getFromDestination() {
		return fromDestination;
	}

	public void setFromDestination(String fromDestination) {
		this.fromDestination = fromDestination;
	}

	public String getBusName() {
		return BusName;
	}

	public void setBusName(String busName) {
		BusName = busName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public boolean isTripStatus() {
		return tripStatus;
	}

	public void setTripStatus(boolean tripStatus) {
		this.tripStatus = tripStatus;
	}
	

}
//Design Patterns Used:
//Entity-Attribute-Value (EAV) Pattern: This pattern is used implicitly in the structure of the Bookings entity. Each instance of Bookings represents a single booking record with attributes such as noOfPersons, totalCalculated, filterDate, etc. This pattern is commonly used for modeling entities with a variable number of attributes.
//SOLID Principles Used:
//Single Responsibility Principle (SRP): The class adheres to the SRP as it has a single responsibility: representing a booking record. It contains only fields and getter/setter methods related to booking information, which helps maintain a clear and focused class structure.
//SOLID Principles Violated:
//Dependency Inversion Principle (DIP): The class directly depends on concrete types such as List and String. Ideally, it should depend on abstractions rather than concrete implementations to allow for greater flexibility and easier maintenance.