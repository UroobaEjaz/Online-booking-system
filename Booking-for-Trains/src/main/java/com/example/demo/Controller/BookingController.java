package com.example.demo.Controller;

import com.example.demo.Repository.entity.Booking;
import com.example.demo.Repository.entity.Trains;
import com.example.demo.Repository.entity.Users;
import com.example.demo.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.PanelUI;
import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {
    @Autowired
    private BookingService bookingService;

    // Create a new booking
    @PostMapping("/createBooking")
    public Booking createBooking(@RequestBody Booking bookingRequest) {
        // Assuming `userId` and `trainNumber` are part of the request body
        Users user = bookingRequest.getUserId();
        Trains train = bookingRequest.getTrainNumber();

        return bookingService.createBooking(user, train);
    }

    // Get a booking by ID
    @GetMapping("/{bookingId}")
    public Optional<Booking> getBookingById(@PathVariable int bookingId) {
        return bookingService.getBookingById(bookingId);
    }

    // Get all bookings
    @GetMapping("/all")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/viewBooking/{referenceNum}")
    public Optional<Booking> getByReference(@PathVariable String referenceNum){
        return bookingService.getBookingByReference(referenceNum);
    }

//     Delete a booking by ID
//    @DeleteMapping("delete/{bookingId}")
//    public void deleteBooking(@PathVariable int bookingId) {
//        bookingService.deleteBooking(bookingId);
//    }

    // Delete a booking by reference number
//    @DeleteMapping("/delete/{referenceNum}")
//    public String deleteBookingByReference(@PathVariable String referenceNum) {
//        bookingService.deleteByReference(referenceNum);
//        return "Booking deleted";
//    }

    @DeleteMapping("/deleteByReference")
    public String deleteByReference(@RequestBody Booking booking){
        bookingService.deleteByReference(booking.getBookingReference());
        return "Booking deleted successfully";
    }
}

