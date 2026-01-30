package com.example.contactBook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContactService {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Contact> contactBook = new HashMap<>();

        System.out.println("--- Secure Contact Book Application ---");

        while (true) {
            System.out.println("\n1. Add/Update | 2. Search | 3. Delete | 4. View All | 5. Exit");
            System.out.print("Choose option: ");
            String choice = sc.nextLine();

            if (choice.equals("5")) break;

            switch (choice) {
                case "1":
                    System.out.print("Enter Unique ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    contactBook.put(id, new Contact(id, name, phone, email));
                    System.out.println("Contact saved successfully.");
                    break;

                case "2":
                    System.out.print("Enter ID to search: ");
                    String searchId = sc.nextLine();
                    if (contactBook.containsKey(searchId)) {
                        System.out.println("Result: " + contactBook.get(searchId));
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case "3":
                    System.out.print("Enter ID to delete: ");
                    String deleteId = sc.nextLine();
                    if (contactBook.remove(deleteId) != null) {
                        System.out.println("Contact deleted.");
                    } else {
                        System.out.println("Error: ID not found.");
                    }
                    break;

                case "4":
                    System.out.println("\n--- All Contacts ---");
                    if (contactBook.isEmpty()) System.out.println("Contact book is empty.");
                    for (Contact c : contactBook.values()) {
                        System.out.println(c);
                    }
                    break;
            }
        }
        sc.close();
        System.out.println("Application closed.");
    }
}
