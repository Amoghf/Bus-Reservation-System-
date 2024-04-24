package com.ra.busBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ra.busBooking.model.Feedback;

public interface FeedbackRepo extends JpaRepository<Feedback, Integer>{

}
