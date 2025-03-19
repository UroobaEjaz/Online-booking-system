package com.example.demo.Repository.JPA;

import com.example.demo.Repository.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingJpa extends JpaRepository<Booking,Integer> {
    Optional<Booking> findByBookingReference(String bookingReference);  // Custom query to find by reference number
}
