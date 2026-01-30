package com.example.atm;

import java.util.Scanner;

public class AtmPinVerification {

    public static void verifyPin(UserAccount account, String enteredPin) {
        if (!enteredPin.matches("\\d{4}")) {
            System.out.println("Invalid PIN format! Please enter exactly 4 digits.");
            account.setAttempts(account.getAttempts() + 1);
            return;
        }

        if (enteredPin.equals(account.getPin())) {
            System.out.println("Access Granted! Welcome to ATM services.");
            account.setAccessGranted(true);
        } else {
            account.setAttempts(account.getAttempts() + 1);
            int remaining = account.getMaxAttempts() - account.getAttempts();
            System.out.println("Wrong PIN! Attempts left: " + remaining);
        }
    }

    public static void main(String[] args) {
        UserAccount account = new UserAccount();
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- ATM PIN Verification System ---");

        while (account.getAttempts() < account.getMaxAttempts() && !account.isAccessGranted()) {
            System.out.print("Enter 4-digit PIN: ");
            String enteredPin = scanner.nextLine();
            
            verifyPin(account, enteredPin);
        }

        if (!account.isAccessGranted()) {
            System.out.println("Account Blocked! Too many incorrect attempts.");
        }

    }
}