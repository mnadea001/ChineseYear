package com.example.chineseyear.services;

import com.example.chineseyear.entities.Cart;
import com.example.chineseyear.entities.CartItem;
import com.example.chineseyear.entities.Product;
import com.example.chineseyear.repositories.CartRepository;
import com.example.chineseyear.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {


    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;

    public Cart findCartById(Long id) {
        Optional<Cart> optionalCart = cartRepository.findById(id);
        if (optionalCart.isPresent()) {
            return optionalCart.get();
        }
        throw new EntityNotFoundException("Cart not found with id " + id);
    }

    public void addItemToCart(Cart cart, Product product) {
        CartItem cartItem = findCartItemByProduct(cart, product);
        if (cartItem != null) {
            cartItem.setQuantity(cartItem.getQuantity() + 1);
        } else {
            cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setQuantity(1);
            cartItem.setCart(cart);
            cart.getItems().add(cartItem);
        }
        cartRepository.save(cart);
    }

    public void removeItemFromCart(Cart cart, Product product) {
        CartItem cartItem = findCartItemByProduct(cart, product);
        if (cartItem != null) {
            cart.getItems().remove(cartItem);
            cartRepository.save(cart);
        }
    }

    public void updateItemQuantity(Cart cart, Product product, int quantity) {
        CartItem cartItem = findCartItemByProduct(cart, product);
        if (cartItem != null) {
            cartItem.setQuantity(quantity);
            cartRepository.save(cart);
        }
    }

    public double calculateCartTotal(Cart cart) {
        double total = 0;
        for (CartItem item : cart.getItems()) {
            double itemTotal = item.getProduct().getPrice() * item.getQuantity();
            total += itemTotal;
        }
        return total;
    }

    public void applyDiscount(Cart cart) {
        double total = calculateCartTotal(cart);
        if (total >= 50) {
            total -= 8;
            cart.setTotal(total);
            cartRepository.save(cart);
        }
    }

    public void addToCart(Long productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id " + productId));
        Cart cart = getCart();
        addItemToCart(product, quantity);
    }

    public Cart getCart() {
        List<Cart> carts = cartRepository.findAll();
        if (carts.isEmpty()) {
            Cart cart = new Cart();
            cartRepository.save(cart);
            return cart;
        }
        return carts.get(0);
    }
    private CartItem findCartItemByProduct(Cart cart, Product product) {
        List<CartItem> cartItems = cart.getItems();
        for (CartItem item : cartItems) {
            if (item.getProduct().getId().equals(product.getId())) {
                return item;
            }
        }
        return null;
    }


//    public Cart getCart() {
//        return cart;
//    }
//
//    public CartItem findCartItemByProduct(Cart cart, Product product) {
//        List<CartItem> cartItems = cart.getItems();
//        for (CartItem item : cartItems) {
//            if (item.getProduct().equals(product)) {
//                return item;
//            }
//        }
//        return null;
//    }
//    public void addToCart(Long productId, int quantity) {
//        Optional<Product> productOptional = productRepository.findById(productId);
//        if (productOptional.isPresent()) {
//            Product product = productOptional.get();
//
//            CartItem cartItem = findCartItemByProduct(cart, product);
//            if (cartItem != null) {
//                // Le produit est déjà dans le panier, on incrémente la quantité
//                cartItem.setQuantity(cartItem.getQuantity() + 1);
//            } else {
//                // Le produit n'est pas dans le panier, on l'ajoute avec une quantité de 1
//                cartItem = new CartItem();
//                cartItem.setProduct(product);
//                cartItem.setQuantity(1);
//                cartItem.setCart(cart);
//                cart.getItems().add(cartItem);
//            }
//
//            cartRepository.save(cart);
//        }
//    }
//
//    public void removeFromCart(Long cartItemId) {
//        cart.removeItem(cartItemId);
//    }
//
//    public double calculateTotal() {
////        double total = cart.getItems().stream()
////                .mapToDouble(item -> item.getQuantity() * item.getProduct().getPrice())
////                .sum();
////        if (total >= 50) {
////            total -= 8;
////        }
//        double total = 0;
//        for (CartItem item : cart.getItems()) {
//            total += item.getProduct().getPrice() * item.getQuantity();
//        }
//        if (total >= 50) {
//            total -= 8;
//        }
//        return total;
//    }
}
