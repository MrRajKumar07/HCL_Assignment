package com.example.EcommerceCart.service;

import java.util.*;
import com.example.EcommerceCart.model.CartItem;
import com.example.EcommerceCart.model.Product;

public class ShoppingCart {
    private Map<Integer, CartItem> items = new HashMap<>();

    public void addProduct(Product product, int qty) {
        if (items.containsKey(product.getId())) {
            items.get(product.getId()).addQuantity(qty);
        } else {
            items.put(product.getId(), new CartItem(product, qty));
        }
    }

    public double calculateTotal() {
        return items.values().stream()
                    .mapToDouble(CartItem::getSubtotal)
                    .sum();
    }

    public void viewCart() {
        System.out.println("\n--- Current Shopping Cart ---");
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            items.values().forEach(System.out::println);
            System.out.printf("Total Amount to Pay: $%.2f\n", calculateTotal());
        }
        System.out.println("-----------------------------\n");
    }
}