package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Admin;


public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findByName(String name);
}