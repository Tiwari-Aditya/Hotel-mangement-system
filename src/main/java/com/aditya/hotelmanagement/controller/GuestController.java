package com.aditya.hotelmanagement.controller;

import com.aditya.hotelmanagement.model.Guest;
import com.aditya.hotelmanagement.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/guests")
@RequiredArgsConstructor
public class GuestController {

    private final GuestService guestService;

    @GetMapping
    public List<Guest> getAllGuests() {
        return guestService.getAllGuests();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guest> getGuestById(@PathVariable Long id) {
        Optional<Guest> guest = guestService.getGuestById(id);
        return ResponseEntity.of(guest);
    }

    @GetMapping("/by-first-name")
    public ResponseEntity<List<Guest>> getGuestsByFirstNameStartingWith(@RequestParam("firstLetter") char firstLetter) {
        List<Guest> guests = guestService.getGuestsByFirstNameStartingWith(firstLetter);
        return ResponseEntity.ok(guests);
    }

    @PostMapping
    public ResponseEntity<Guest> saveGuest(@RequestBody Guest guest) {
        Guest savedGuest = guestService.saveGuest(guest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGuest);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuest(@PathVariable Long id) {
        guestService.deleteGuest(id);
        return ResponseEntity.noContent().build();
    }
}
