package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.CreditCard;


public interface CreditCardRepository extends JpaRepository<CreditCard, String>{
    
}
