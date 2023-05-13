package com.example.chineseyear.services;

import com.example.chineseyear.entities.Cart;
import com.example.chineseyear.entities.Product;
import com.example.chineseyear.repositories.CartRepository;
import com.example.chineseyear.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.chineseyear.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
    }

    public Cart getCartById(Long cartId) {
        if (cartId != null) {
            return cartRepository.findById(cartId)
                    .orElseThrow(() -> new ResourceNotFoundException("Cart not found with id " + cartId));
        } else {
            return new Cart();
        }
    }

    public void addProductToCart(Long productId, Long cartId) {
        Product product = getProductById(productId);
        Cart cart = getCartById(cartId);
        cart.addProduct(product);
        cartRepository.save(cart);
    }
}