package com.aditya.hotelmanagement.repository;

import com.aditya.hotelmanagement.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {
}
