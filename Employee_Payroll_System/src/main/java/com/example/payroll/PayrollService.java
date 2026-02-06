package com.example.payroll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PayrollService {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> payroll = new ArrayList<>();

        System.out.println("--- Employee Payroll Management ---");

        while (true) {
            System.out.println("\nOptions: 1. Add Full-Time | 2. Add Part-Time | 3. Generate Report | 4. Exit");
            System.out.print("Select: ");
            String choice = sc.nextLine();

            if (choice.equals("4")) break;

            if (choice.equals("3")) {
                generateReport(payroll);
                continue;
            }

            System.out.print("Enter ID: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            if (choice.equals("1")) {
                System.out.print("Enter Monthly Salary: ");
                double sal = Double.parseDouble(sc.nextLine());
                payroll.add(new FullTimeEmployee(name, id, sal));
            } 
            else if (choice.equals("2")) {
                System.out.print("Enter Hours Worked: ");
                int hours = Integer.parseInt(sc.nextLine());
                System.out.print("Enter Hourly Rate: ");
                double rate = Double.parseDouble(sc.nextLine());
                payroll.add(new PartTimeEmployee(name, id, hours, rate));
            }
            System.out.println("Employee added successfully!");
        }
        sc.close();
    }

    public static void generateReport(List<Employee> list) {
        if (list.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        System.out.println("\n--- FINAL PAYROLL REPORT ---");
        System.out.printf("%-5s | %-15s | %-16s | %-10s\n", "ID", "Name", "Type", "Net Pay");
        System.out.println("---------------------------------------------------------");
        
        double totalPayout = 0;
        for (Employee e : list) {
            double salary = e.calculateSalary();
            System.out.printf("%-5d | %-15s | %-12s | %.2f\n", 
                               e.getId(), e.getName(), e.getClass().getSimpleName(), salary);
            totalPayout += salary;
        }
        System.out.println("---------------------------------------------------------");
        System.out.printf("Total Company Payout: %.2f\n", totalPayout);
    }
}
