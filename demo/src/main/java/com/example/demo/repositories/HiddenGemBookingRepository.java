package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.HiddenGemBooking;

public interface HiddenGemBookingRepository extends JpaRepository<HiddenGemBooking, Integer> {
    
}
