package com.example.demo.Service;

import com.example.demo.Repository.JPA.BookingJpa;
import com.example.demo.Repository.entity.Booking;
import com.example.demo.Repository.entity.Trains;
import com.example.demo.Repository.entity.Users;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookingService {


        private final BookingJpa bookingJpa;

        public BookingService(BookingJpa bookingJpa) {
            this.bookingJpa = bookingJpa;
        }

        // Method to generate a unique booking reference
        private String generateBookingReference(Users user, Trains train) {
            // Generate a unique UUID
            UUID uuid = UUID.randomUUID();
            String bookingReference = uuid + "-" + user.getUserId();
            return bookingReference;
        }

        // Create a booking
        public Booking createBooking(Users user, Trains train) {
            Booking booking = new Booking();
            booking.setUserId(user);
            booking.setTrainNumber(train);
            booking.setBookingDate(new Date());  // Set current date
            booking.setBookingReference(generateBookingReference(user, train));  // Generate unique reference

            return bookingJpa.save(booking);
        }

        // Get a booking by ID
        public Optional<Booking> getBookingById(int bookingId) {
            return bookingJpa.findById(bookingId);
        }

        // Get all bookings
        public List<Booking> getAllBookings() {
            return bookingJpa.findAll();
        }

        // Delete a booking
        public void deleteBooking(int bookingId) {
            bookingJpa.deleteById(bookingId);
        }

    // Get a booking by reference number
    public Optional<Booking> getBookingByReference(String referenceNum) {
        return bookingJpa.findByBookingReference(referenceNum);
    }

    //delete by reference Id

    public void deleteByReference(String referenceNum) {
        // Find the booking by reference number
        Booking booking = bookingJpa.findByBookingReference(referenceNum)
                .orElseThrow(() -> new RuntimeException("Booking not found for reference number: " + referenceNum));

        // Extract the booking ID from the found booking
        int bookingId = booking.getBookingId();

        // Delete the booking by its ID
        bookingJpa.deleteById(bookingId);

        System.out.println("Booking with reference number " + referenceNum + " has been deleted.");
    }

    // Method to handle booking not found exception
    public Booking getBookingOrThrow(String referenceNum) {
        return bookingJpa.findByBookingReference(referenceNum)
                .orElseThrow(() -> new RuntimeException("Booking not found for reference number: " + referenceNum));
    }
}
