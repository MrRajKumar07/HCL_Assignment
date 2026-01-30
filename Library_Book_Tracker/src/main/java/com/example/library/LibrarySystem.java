package com.example.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibrarySystem {
	
    public static void issueBook(List<Book> available, List<Book> issued, String title) {
        Book foundBook = null;
        for (Book b : available) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                foundBook = b;
                break;
            }
        }

        if (foundBook != null) {
            available.remove(foundBook);
            issued.add(foundBook);
            System.out.println("Success: You have issued " + foundBook.getTitle());
        } else {
            System.out.println("Error: Book not found or already issued.");
        }
    }

    public static void returnBook(List<Book> available, List<Book> issued, String title) {
        Book foundBook = null;
        for (Book b : issued) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                foundBook = b;
                break;
            }
        }

        if (foundBook != null) {
            issued.remove(foundBook);
            available.add(foundBook);
            System.out.println("Success: You have returned " + foundBook.getTitle());
        } else {
            System.out.println("Error: This book was not marked as issued.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Book> availableBooks = new ArrayList<>();
        List<Book> issuedBooks = new ArrayList<>();

        availableBooks.add(new Book("Java Programming", "James Gosling"));
        availableBooks.add(new Book("Clean Code", "Robert Martin"));
        availableBooks.add(new Book("SQL Basics", "E.F. Codd"));

        while (true) {
            System.out.println("\n--- Library Tracker ---");
            System.out.println("Available: " + availableBooks);
            System.out.println("Issued: " + issuedBooks);
            System.out.print("\nOptions: 1. Issue | 2. Return | 3. Exit: ");
            
            String choice = sc.nextLine();
            if (choice.equals("3")) break;

            System.out.print("Enter Book Title: ");
            String title = sc.nextLine();

            if (choice.equals("1")) {
                issueBook(availableBooks, issuedBooks, title);
            } else if (choice.equals("2")) {
                returnBook(availableBooks, issuedBooks, title);
            }
        }
        sc.close();
        System.out.println("Library closed.");
    }
}