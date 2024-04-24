package com.ra.busBooking.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name= "Reservation")
public class BusData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
    private String filterDate;
	
	private String toDestination;
	
	private String fromDestination;
	
	private Double price; 
	
	private String BusName;
	
	private String time;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getBusName() {
		return BusName;
	}

	public void setBusName(String busName) {
		BusName = busName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	
}
//Design Patterns Used:
//Entity-Attribute-Value (EAV) Pattern: Similar to the Bookings class, the BusData class follows the EAV pattern implicitly. It represents an entity with attributes such as filterDate, toDestination, fromDestination, etc., which can vary for each instance of the entity.
//SOLID Principles Used:
//Single Responsibility Principle (SRP): The class adheres to the SRP as it has a single responsibility: representing bus data for reservation. It contains only fields and getter/setter methods related to bus reservation information, maintaining a clear and focused class structure.
//open,close and dip are violated