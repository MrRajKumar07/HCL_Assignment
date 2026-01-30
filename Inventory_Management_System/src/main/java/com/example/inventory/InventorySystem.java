package com.example.inventory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventorySystem {

    public static void updateStock(Map<String, Product> inventory, String id, int change) {
        if (inventory.containsKey(id)) {
            Product p = inventory.get(id);
            int newLevel = p.getStockLevel() + change;
            
            if (newLevel < 0) {
                System.out.println("Error: Stock cannot be negative.");
            } else {
                p.setStockLevel(newLevel);
                System.out.println("Stock updated for " + p.getName() + ". New Level: " + newLevel);
            }
        } else {
            System.out.println("Error: Product ID not found.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Product> inventory = new HashMap<>();

        System.out.println("Warehouse Inventory Management System");

        while (true) {
            System.out.println("\n1. Add Product | 2. Update Stock | 3. Check Product | 4. View All | 5. Exit");
            System.out.print("Action: ");
            String choice = sc.nextLine();

            if (choice.equals("5")) break;

            switch (choice) {
                case "1":
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Initial Stock: ");
                    int stock = Integer.parseInt(sc.nextLine());
                    inventory.put(id, new Product(id, name, stock));
                    break;

                case "2":
                    System.out.print("Enter Product ID: ");
                    String updateId = sc.nextLine();
                    System.out.print("Enter change amount: ");
                    int change = Integer.parseInt(sc.nextLine());
                    updateStock(inventory, updateId, change);
                    break;

                case "3":
                    System.out.print("Search ID: ");
                    String searchId = sc.nextLine();
                    if (inventory.containsKey(searchId)) {
                        System.out.println(inventory.get(searchId));
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case "4":
                    System.out.println("\n--- Current Inventory ---");
                    for (Product p : inventory.values()) {
                        System.out.println(p);
                    }
                    break;
            }
        }
        sc.close();
    }
}