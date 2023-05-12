package com.example.chineseyear.repositories;


import com.example.chineseyear.entities.User;
import com.example.chineseyear.entities.Year;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface YearRepository extends JpaRepository<Year, Long> {

    List<Year> findByYearDateContaining(Integer yearDate);


}