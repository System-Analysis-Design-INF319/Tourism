package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.BusBooking;

public interface BusBookingRepository extends JpaRepository<BusBooking, Integer> {
    Boolean existsByUserId(Long id);
    int countByBusId(int id);

}
