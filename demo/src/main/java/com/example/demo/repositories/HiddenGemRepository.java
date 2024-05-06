package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.HiddenGem;

public interface HiddenGemRepository extends JpaRepository<HiddenGem, Integer> {
    @Query("SELECT h FROM HiddenGem h WHERE LOWER(h.name) LIKE LOWER(CONCAT(?1, '%'))")
    List<HiddenGem> findByNameStartingWithIgnoreCase(String prefix);
}
