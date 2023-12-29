package com.aditya.hotelmanagement.service;

import com.aditya.hotelmanagement.model.Guest;
import com.aditya.hotelmanagement.repository.GuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class GuestService {

    private final GuestRepository guestRepository;

    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    public Optional<Guest> getGuestById(Long id) {
        return guestRepository.findById(id);
    }

    public List<Guest> getGuestsByFirstNameStartingWith(char firstLetter) {
        return guestRepository.findByFirstNameStartingWithIgnoreCase(firstLetter);
    }

    public Guest saveGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    public void deleteGuest(Long id) {
        guestRepository.deleteById(id);
    }

    public Page<Guest> getGuestPagination(Integer pagenumber, Integer pagesize) {
        Sort sort = Sort.by(Sort.Direction.ASC,"firstName");
        Pageable pageable = PageRequest.of(pagenumber,pagesize,sort);
        return guestRepository.findAll(pageable);
    }
}
