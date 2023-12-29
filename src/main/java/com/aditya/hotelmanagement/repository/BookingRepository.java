package com.aditya.hotelmanagement.repository;
import com.aditya.hotelmanagement.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    Optional<Booking> findByCheckInDate (LocalDate date);

}