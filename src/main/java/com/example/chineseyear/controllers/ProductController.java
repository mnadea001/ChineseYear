package com.example.chineseyear.controllers;

import com.example.chineseyear.entities.Product;
import com.example.chineseyear.entities.Proverb;
import com.example.chineseyear.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public String getAllProducts(Model model) {

        List<Product> products = new ArrayList<Product>();

        productRepository.findAll().forEach(products::add);

        model.addAttribute("products", products);

        return "products";
    }

}
