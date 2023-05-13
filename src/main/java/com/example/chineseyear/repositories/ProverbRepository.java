package com.example.chineseyear.repositories;

import com.example.chineseyear.entities.Proverb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProverbRepository extends JpaRepository<Proverb, Long> {
}
