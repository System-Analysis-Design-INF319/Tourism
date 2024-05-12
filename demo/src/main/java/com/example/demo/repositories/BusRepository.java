package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Bus;

public interface BusRepository extends JpaRepository<Bus, Integer> {

}
