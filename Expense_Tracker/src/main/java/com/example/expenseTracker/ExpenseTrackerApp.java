package com.example.expenseTracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpenseTrackerApp {
	
    public static List<Expense> getFiltered(List<Expense> allExpenses, String category) {
        List<Expense> filteredList = new ArrayList<>();
        for (Expense e : allExpenses) {
            if (e.getCategory().equalsIgnoreCase(category)) {
                filteredList.add(e);
            }
        }
        return filteredList;
    }

    public static double getTotal(List<Expense> expenses) {
        double total = 0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }
        return total;
    }

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        List<Expense> allExpenses = new ArrayList<>();
        
        System.out.println("--- Welcome to Daily Expense Tracker ---");

        while (true) {
            System.out.print("Enter Description (or 'done' to finish): ");
            String desc = sc.nextLine();
            if (desc.equalsIgnoreCase("done")) break;

            System.out.print("Enter Amount: ");
            double amt = Double.parseDouble(sc.nextLine());

            System.out.print("Enter Category (Food/Travel/Shopping): ");
            String cat = sc.nextLine();

            allExpenses.add(new Expense(desc, amt, cat));
            System.out.println("Expense added!\n");
        }

        System.out.println("\n--- Summary ---");
        System.out.println("Total Overall Spending: " + getTotal(allExpenses));

        System.out.print("\nEnter a category to filter by: ");
        String filterCat = sc.nextLine();
        
        List<Expense> filteredResults = getFiltered(allExpenses, filterCat);
        
        System.out.println("\nItems in " + filterCat + ":");
        for (Expense e : filteredResults) {
            System.out.println(e);
        }
        System.out.println("Subtotal for " + filterCat + ": " + getTotal(filteredResults));
    }
}