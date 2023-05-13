package com.example.chineseyear.controllers;

import com.example.chineseyear.entities.Product;
import com.example.chineseyear.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @GetMapping
    public String getProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        model.addAttribute("cart", cartService.getCart());
        return "products";
    }

    @PostMapping("/addToCart/{productId}")
    public String addToCart(@PathVariable Long productId, @RequestParam("quantity") int quantity) {
        cartService.addToCart(productId, quantity);
        return "redirect:/products";
    }

    @PostMapping("/removeFromCart/{cartItemId}")
    public String removeFromCart(@PathVariable Long cartItemId) {
        cartService.removeFromCart(cartItemId);
        return "redirect:/products";
    }

}
