package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.models.user;

public interface userRepository extends JpaRepository<user,Long>{
    user findByUsername(String username);

    user findByEmail(String email);
}
