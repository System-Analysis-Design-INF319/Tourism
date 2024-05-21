package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.HistoricalPlace;

public interface HistoricalPlaceRepository extends JpaRepository<HistoricalPlace, Integer>{

    HistoricalPlace findById(int id);
}
