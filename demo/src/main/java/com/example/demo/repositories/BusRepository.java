package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Bus;

public interface BusRepository extends JpaRepository<Bus, Integer> {
    @Query(value = "SELECT * FROM `bus` WHERE full = 0", nativeQuery = true)
    List<Bus> findByFullCapacity();
}