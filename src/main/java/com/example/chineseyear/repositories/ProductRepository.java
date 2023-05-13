package com.example.chineseyear.repositories;

import com.example.chineseyear.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAll();

    Product findById(long id);
}
