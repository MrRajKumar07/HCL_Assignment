package com.example.EcommerceCart.model;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void addQuantity(int qty) {
        this.quantity += qty;
    }

    public double getSubtotal() {
        return product.getPrice() * quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }

    @Override
    public String toString() {
        return String.format("%-15s | Qty: %d | Subtotal: $%.2f", 
                             product.getName(), quantity, getSubtotal());
    }
}