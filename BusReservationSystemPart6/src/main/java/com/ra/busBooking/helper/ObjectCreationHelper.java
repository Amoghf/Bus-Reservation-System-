package com.ra.busBooking.helper;

import com.ra.busBooking.DTO.BookingsDTO;
import com.ra.busBooking.model.Bookings;
import com.ra.busBooking.model.BusData;

public class ObjectCreationHelper {
	
	public static  BookingsDTO createBookingsDTO(BusData busdata) {
		BookingsDTO bks = new BookingsDTO();
		
		bks.setBusName(busdata.getBusName());
		bks.setFilterDate(busdata.getFilterDate());
		bks.setFromDestination(busdata.getFromDestination());
		bks.setToDestination(busdata.getToDestination());
		bks.setPrice(busdata.getPrice());
		bks.setNoOfPersons(0);
		bks.setTime(busdata.getTime());
		bks.setTotalCalculated(0.0);
		
		return bks;
		
	
	}

	public static BookingsDTO createBookingsDTO(Bookings busdata) {
BookingsDTO bks = new BookingsDTO();
bks.setId(busdata.getId());
		
		bks.setBusName(busdata.getBusName());
		bks.setFilterDate(busdata.getFilterDate());
		bks.setFromDestination(busdata.getFromDestination());
		bks.setToDestination(busdata.getToDestination());
		bks.setNoOfPersons(busdata.getNoOfPersons());
		bks.setTime(busdata.getTime());
		bks.setTotalCalculated(busdata.getTotalCalculated());
		if(busdata.isTripStatus()==true) {
			bks.setTripStatus("Active");
		}else {
			bks.setTripStatus("Canceled");
		}
		
		return bks;
	}

}
//Design Principles Used:
//Single Responsibility Principle (SRP): The class adheres to the SRP as it has a single responsibility: creating BookingsDTO objects from BusData and Bookings entities. Each method is focused on a specific aspect of object creation, enhancing code readability and maintainability.
//Encapsulation: The methods encapsulate the creation logic for BookingsDTO objects and hide the implementation details. This encapsulation allows for easier maintenance and modification of the creation process.
//SOLID Principles Violated:
//Dependency Inversion Principle (DIP): The class directly depends on concrete implementations (BusData and Bookings entities), violating the DIP. It would be better to depend on abstractions (e.g., interfaces or abstract classes) to decouple the creation logic from specific implementations and improve flexibility and testability.