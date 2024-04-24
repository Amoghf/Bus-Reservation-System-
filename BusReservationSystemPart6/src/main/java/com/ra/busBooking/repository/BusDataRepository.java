package com.ra.busBooking.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ra.busBooking.DTO.BookingsDTO;
import com.ra.busBooking.model.BusData;

@Repository
public interface BusDataRepository extends JpaRepository<BusData, Integer>{
	@Query(value = "select * from Reservation  where reservation.to_destination =:to and reservation.from_destination =:from and reservation.filter_date =:date  order By reservation.filter_date desc " , nativeQuery = true)
	List<BusData> findByToFromAndDate(String to , String from, String date);
	
	

}
//Design Principles Used:
//Separation of Concerns (SoC): The repository interface separates concerns by solely focusing on database operations related to the BusData entity.
//SOLID Principles Used:
//Single Responsibility Principle (SRP): The interface adheres to SRP by defining methods responsible for querying BusData entities based on specific criteria.
//Suggestions for Improvement:
//Dependency Inversion Principle (DIP): The repository interface effectively relies on the JpaRepository abstraction, adhering to DIP. It abstracts away the details of database interaction, allowing clients to depend on the interface rather than concrete implementations.
//Interface Segregation Principle (ISP): Since the interface extends JpaRepository, which contains various methods for CRUD operations, ensure that only necessary methods are exposed to clients. If there are methods specific to the application's needs, consider segregating them into more focused interfaces.