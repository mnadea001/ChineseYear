package com.example.chineseyear.repositories;

import com.example.chineseyear.entities.Proverb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProverbRepository extends JpaRepository<Proverb, Long> {
    @Query(value = "SELECT * FROM proverbs ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Proverb findRandomProverb();
}
