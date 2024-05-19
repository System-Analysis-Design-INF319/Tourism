package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.HiddenGemBooking;

public interface HiddenGemBookingRepository extends JpaRepository<HiddenGemBooking, Integer> {
    Boolean existsByUserId (Long userId);
    List <HiddenGemBooking> findByUserId (Long userId);
}
   