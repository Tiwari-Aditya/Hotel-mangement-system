package com.aditya.hotelmanagement.service;

import com.aditya.hotelmanagement.exception.BadRequestException;
import com.aditya.hotelmanagement.exception.NotFoundException;
import com.aditya.hotelmanagement.model.Booking;
import com.aditya.hotelmanagement.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        if (id == null || id <= 0) {
            throw new BadRequestException("400", "Invalid booking ID: " + id);
        }
       Optional<Booking> booking = bookingRepository.findById(id);
        if(booking.isEmpty()){
            throw new NotFoundException("404", "Booking not found with id: " + id);
        }
//        return bookingRepository.findById(id).orElseThrow(() -> new NotFoundException("404", "Booking not found with id: " + id));
        return booking.get();
    }

    public Booking getBookingByCheckInDate(LocalDate date) {
        return bookingRepository.findByCheckInDate(date).orElseThrow(() -> new NotFoundException("404", "Booking not found with Check In Date: " + date));
    }

    public Page<Booking> getBookingPagination(Integer pagenumber, Integer pagesize) {
        Sort sort = Sort.by(Sort.Direction.ASC, "checkInDate");
        Pageable pageable = PageRequest.of(pagenumber, pagesize, sort);
        return bookingRepository.findAll(pageable);
    }

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }


}
