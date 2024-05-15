package com.example.demo.repositories;

import com.example.demo.models.LocalBusinessOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalBusinessOwnerRepository extends JpaRepository<LocalBusinessOwner, Long> {
    
}