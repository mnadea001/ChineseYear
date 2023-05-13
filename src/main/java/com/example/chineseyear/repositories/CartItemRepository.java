package com.example.chineseyear.repositories;

import com.example.chineseyear.entities.Cart;
import com.example.chineseyear.entities.CartItem;
import com.example.chineseyear.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    Optional<CartItem> findByCartAndProduct(Cart cart, Product product);
    List<CartItem> findAllByCart(Cart cart);

    List<CartItem> findAll();
    Optional<CartItem> findById(Long id);

    void deleteById(Long id);
    void deleteAllByCart(Cart cart);
}
