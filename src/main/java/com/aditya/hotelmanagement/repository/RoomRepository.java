package com.aditya.hotelmanagement.repository;
import com.aditya.hotelmanagement.model.Room;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Slf4j
@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}