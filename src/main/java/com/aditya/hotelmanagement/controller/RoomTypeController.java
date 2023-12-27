package com.aditya.hotelmanagement.controller;

import com.aditya.hotelmanagement.model.RoomType;
import com.aditya.hotelmanagement.service.RoomTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/room-types")
@RequiredArgsConstructor
public class RoomTypeController {

    private final RoomTypeService roomTypeService;

    @GetMapping
    public List<RoomType> getAllRoomTypes() {
        return roomTypeService.getAllRoomTypes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomType> getRoomTypeById(@PathVariable Long id) {
        Optional<RoomType> roomType = roomTypeService.getRoomTypeById(id);
        return ResponseEntity.of(roomType);
    }

    @PostMapping
    public ResponseEntity<RoomType> saveRoomType(@RequestBody RoomType roomType) {
        RoomType savedRoomType = roomTypeService.saveRoomType(roomType);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRoomType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoomType(@PathVariable Long id) {
        roomTypeService.deleteRoomType(id);
        return ResponseEntity.noContent().build();
    }
}

