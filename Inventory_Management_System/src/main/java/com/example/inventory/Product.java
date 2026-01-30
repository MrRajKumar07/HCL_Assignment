package com.example.inventory;

public class Product {
    private String productId;
    private String name;
    private int stockLevel;

    public Product(String productId, String name, int stockLevel) {
        this.productId = productId;
        this.name = name;
        this.stockLevel = stockLevel;
    }

    public String getProductId() { return productId; }
    public String getName() { return name; }
    public int getStockLevel() { return stockLevel; }
    
    public void setStockLevel(int stockLevel) { 
        this.stockLevel = stockLevel; 
    }

    @Override
    public String toString() {
        return String.format("ID: %-8s | Name: %-15s | Stock: %d", productId, name, stockLevel);
    }
}
