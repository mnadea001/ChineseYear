package com.example.chineseyear.services;

import com.example.chineseyear.entities.Cart;
import com.example.chineseyear.entities.CartItem;
import com.example.chineseyear.entities.Product;
import com.example.chineseyear.repositories.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;

    public CartItem findCartItemById(Long id) {
        return cartItemRepository.findById(id).orElse(null);
    }

    public Optional<CartItem> findCartItemByCartAndProduct(Cart cart, Product product) {
        return cartItemRepository.findByCartAndProduct(cart, product);
    }

    public List<CartItem> findAllCartItemsByCart(Cart cart) {
        return cartItemRepository.findAllByCart(cart);
    }

    public void deleteCartItemById(Long id) {
        cartItemRepository.deleteById(id);
    }

    public void deleteAllCartItemsByCart(Cart cart) {
        cartItemRepository.deleteAllByCart(cart);
    }


}
