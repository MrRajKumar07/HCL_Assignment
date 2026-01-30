package com.example.BankAccount;

import java.util.Scanner;

public class BankSimulatorApp {

    public static void deposit(BankAccount account, double amount) {
        if (amount > 0) {
            double newBalance = account.getBalance() + amount;
            account.setBalance(newBalance);
            System.out.println("Successfully deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public static void withdraw(BankAccount account, double amount) {
        if (amount > 0 && amount <= account.getBalance()) {
            double newBalance = account.getBalance() - amount;
            account.setBalance(newBalance);
            System.out.println("Successfully withdrawn: " + amount);
        } else if (amount > account.getBalance()) {
            System.out.println("Insufficient funds! Current balance: " + account.getBalance());
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount myAccount = new BankAccount("Raj Kumar","Raj-810", 1000.0); 

        System.out.println("Welcome to the Bank Simulator: " + myAccount.getAccountNumber());
        
        boolean running = true;
        while (running) {
            System.out.println("\n1. Check Balance | 2. Deposit | 3. Withdraw | 4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: " + myAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    deposit(myAccount, scanner.nextDouble());
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    withdraw(myAccount, scanner.nextDouble());
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using our bank!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}