package com.example.chineseyear.repositories;

import com.example.chineseyear.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByNameContaining(String name);
}
