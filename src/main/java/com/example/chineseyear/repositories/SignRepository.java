package com.example.chineseyear.repositories;

import com.example.chineseyear.entities.Sign;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface SignRepository extends JpaRepository<Sign, Long> {

    List<Sign> findByNameContaining(String name);
}
