package com.example.chineseyear.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "cart")
    private List<Product> products = new ArrayList<>();

    @Column(name = "total")
    private double total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }



    public Cart() {
    }

    public Cart(Long id, List<Product> products, double total) {
        this.id = id;
        this.products = products;
        this.total = total;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void setTotal(double total) {
        this.total = total;
    }
    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice().doubleValue();
        }
        return total;
    }
}
