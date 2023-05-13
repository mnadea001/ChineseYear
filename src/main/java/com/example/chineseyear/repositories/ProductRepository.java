package com.example.chineseyear.repositories;

import com.example.chineseyear.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
