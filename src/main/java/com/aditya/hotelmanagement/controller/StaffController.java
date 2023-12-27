package com.aditya.hotelmanagement.controller;

import com.aditya.hotelmanagement.model.Staff;
import com.aditya.hotelmanagement.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/staff")
@RequiredArgsConstructor
public class StaffController {

    private final StaffService staffService;

    @GetMapping
    public List<Staff> getAllStaff() {
        return staffService.getAllStaff();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable Long id) {
        Optional<Staff> staff = staffService.getStaffById(id);
        return ResponseEntity.of(staff);
    }

    @PostMapping
    public ResponseEntity<Staff> saveStaff(@RequestBody Staff staff) {
        Staff savedStaff = staffService.saveStaff(staff);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStaff);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStaff(@PathVariable Long id) {
        staffService.deleteStaff(id);
        return ResponseEntity.noContent().build();
    }
}
