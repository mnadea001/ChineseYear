package com.example.chineseyear.controllers;


import com.example.chineseyear.entities.Cart;
import com.example.chineseyear.entities.Product;
import com.example.chineseyear.repositories.CartRepository;
import com.example.chineseyear.repositories.ProductRepository;
import com.example.chineseyear.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller

public class CartController {

    private Cart cart = new Cart();
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;



    @PostMapping("/addProduct")
    public String addProduct(@RequestParam("productId") Long productId, @RequestParam(value = "cartId", required = false) Long cartId) {
        productService.addProductToCart(productId, cartId);
        return "redirect:/products";
    }

    @PostMapping("/checkout")
    public String checkout(@RequestParam(value = "cartId", required = false) Long cartId) {
        Cart cart = productService.getCartById(cartId);
        double total = cart.calculateTotal();
        cart.setTotal(total);
        cartRepository.save(cart);
        return "checkout";
    }
}
