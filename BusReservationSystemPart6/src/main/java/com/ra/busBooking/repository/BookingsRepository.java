package com.ra.busBooking.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ra.busBooking.model.Bookings;




public interface BookingsRepository extends JpaRepository<Bookings, Integer> {

	List<Bookings> findByUserId(int userId);
	
}
//Design Principles Used:
//Separation of Concerns (SoC): The repository interface separates concerns by handling database operations related to the Bookings entity. It focuses solely on persistence-related tasks.
//SOLID Principles Used:
//Single Responsibility Principle (SRP): The interface adheres to SRP by defining methods solely responsible for querying Bookings entities from the database.
//dependency Inversion Principle (DIP): The repository interface relies on the JpaRepository abstraction, adhering to DIP. It doesn't depend on concrete implementations but instead depends on abstractions provided by Spring Data JPA.
//Suggestions for Improvement:
//Interface Segregation Principle (ISP): Since the interface extends JpaRepository, which contains a wide range of methods for CRUD operations, ensure that only necessary methods are exposed to clients. If there are methods specific to the application's needs, consider segregating them into more focused interfaces.