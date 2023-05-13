package com.example.chineseyear.controllers;

import com.example.chineseyear.entities.Product;
import com.example.chineseyear.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    private List<Product> addedProducts = new ArrayList<>();

    @GetMapping("/products")
    public String listProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        model.addAttribute("addedProducts", addedProducts);
        model.addAttribute("totalPrice", calculateTotalPrice());
        return "products";
    }

    @GetMapping("/addProduct/{id}")
    public String addProduct(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        addedProducts.add(product);
        return "redirect:/products";
    }

    @GetMapping("/removeProduct/{id}")
    public String removeProduct(@PathVariable Long id) {
        addedProducts.removeIf(p -> p.getId().equals(id));
        return "redirect:/products";
    }

    private double calculateTotalPrice() {
        return addedProducts.stream().mapToDouble(Product::getPrice).sum();
    }

}
