package com.aditya.hotelmanagement.controller;

import com.aditya.hotelmanagement.customresponse.ApiResponse;
import com.aditya.hotelmanagement.model.Booking;
import com.aditya.hotelmanagement.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @GetMapping
    public ResponseEntity<ApiResponse> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        ApiResponse response = new ApiResponse("success", "All Bookings", bookings);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getBookingById(@PathVariable Long id) {
        Booking booking = bookingService.getBookingById(id);
        ApiResponse response = new ApiResponse("success", "Booking found", booking);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/by-checkin-date")
    public ResponseEntity<ApiResponse> getBookingByCheckInDate(@RequestParam(name = "checkinDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkinDate) {
        Booking booking = bookingService.getBookingByCheckInDate(checkinDate);
        ApiResponse response = new ApiResponse("success", "Booking found", booking);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/pageing-and-sorting-booking/{pagenumber}/{pagesize}")
    public Page<Booking> bookingPagination(@PathVariable Integer pagenumber, @PathVariable Integer pagesize) {
        return bookingService.getBookingPagination(pagenumber, pagesize);
    }

    @PostMapping
    public ResponseEntity<Booking> saveBooking(@RequestBody Booking booking) {
        Booking savedBooking = bookingService.saveBooking(booking);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBooking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }


}
