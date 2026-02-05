package com.example.PersonalDiary;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Personal Diary App ---");
        
        while (true) {
            System.out.println("\n1. Write Entry  2. Read Diary  3. Exit");
            String choice = scanner.nextLine();

            try {
                if (choice.equals("1")) {
                    System.out.print("Enter your thoughts: ");
                    String note = scanner.nextLine();
                    FileHandler.saveEntry(EntryLogic.formatNote(note));
                    System.out.println("Saved!");
                } else if (choice.equals("2")) {
                    System.out.println("\n--- Your History ---");
                    FileHandler.readAllEntries().forEach(System.out::println);
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}