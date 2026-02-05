package com.example.EcommerceCart;

import com.example.EcommerceCart.model.Product;
import com.example.EcommerceCart.service.ShoppingCart;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product(101, "Java Book", 50.0);
        Product p2 = new Product(102, "Laptop Bag", 30.0);

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(p1, 1);
        cart.addProduct(p2, 2);
        cart.addProduct(p1, 1); 

        cart.viewCart();
    }
}