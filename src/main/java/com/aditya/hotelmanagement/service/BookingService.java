package com.aditya.hotelmanagement.service;

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

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public Optional<Booking> getBookingByCheckInDate(LocalDate date){
        return bookingRepository.findByCheckInDate(date);
    }

    public Page<Booking> getBookingPagination(Integer pagenumber, Integer pagesize) {
        Sort sort = Sort.by(Sort.Direction.ASC,"checkInDate");
        Pageable pageable = PageRequest.of(pagenumber,pagesize,sort);
        return bookingRepository.findAll(pageable);
    }

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }


}
