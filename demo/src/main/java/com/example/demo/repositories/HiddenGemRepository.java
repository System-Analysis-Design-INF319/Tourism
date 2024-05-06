package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.HiddenGem;

public interface HiddenGemRepository extends JpaRepository<HiddenGem, Integer> {
    
}
