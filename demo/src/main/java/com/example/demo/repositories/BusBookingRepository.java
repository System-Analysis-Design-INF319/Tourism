package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.BusBooking;

public interface BusBookingRepository extends JpaRepository<BusBooking, Integer> {
    Boolean existsByUserId(Long id);

    @Query(value = "SELECT count(*) FROM bus_booking WHERE bus_id = :busId", nativeQuery = true)
    int countByBusId(@Param("busId") int busId);

    List <BusBooking> findByUserId (Long userId);

}
 