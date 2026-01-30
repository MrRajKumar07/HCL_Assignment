package com.example.studentGradeSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GradeManagementSystem {
    public static void calculateStats(Map<String, Student> records) {
        if (records.isEmpty()) {
            System.out.println("No records found to calculate statistics.");
            return;
        }

        int sum = 0;
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        for (Student s : records.values()) {
            int g = s.getGrade();
            sum += g;
            if (g > highest) highest = g;
            if (g < lowest) lowest = g;
        }

        System.out.println("\n--- Class Statistics ---");
        System.out.println("Average Grade: " + (double) sum / records.size());
        System.out.println("Highest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Student> gradeMap = new HashMap<>();

        System.out.println("Student Grade Management System");

        while (true) {
            System.out.println("\n1. Add/Update | 2. Retrieve | 3. Display All | 4. Stats | 5. Exit");
            System.out.print("Select an option: ");
            String choice = sc.nextLine();

            if (choice.equals("5")) break;

            switch (choice) {
                case "1":
                    System.out.print("Enter Student ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Grade: ");
                    int grade = Integer.parseInt(sc.nextLine());
                    
                    Student newStudent = new Student(id, grade);
                    
                    System.out.print("Enter Name: ");
                    newStudent.setName(sc.nextLine());
                    System.out.print("Enter Department: ");
                    newStudent.setDept(sc.nextLine());

                    gradeMap.put(id, newStudent);
                    System.out.println("Record successfully saved.");
                    break;

                case "2":
                    System.out.print("Enter Student ID to search: ");
                    String searchId = sc.nextLine();
                    if (gradeMap.containsKey(searchId)) {
                        Student found = gradeMap.get(searchId);
                        System.out.println("Result: " + found.getName() + " from " + found.getDept() + " scored " + found.getGrade());
                    } else {
                        System.out.println("Error: Student ID not found.");
                    }
                    break;

                case "3":
                    System.out.println("\n--- All Student Records ---");
                    for (Student s : gradeMap.values()) {
                        System.out.println("ID: " + s.getId() + " | Name: " + s.getName() + " | Dept: " + s.getDept() + " | Grade: " + s.getGrade());
                    }
                    break;

                case "4":
                    calculateStats(gradeMap);
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        sc.close();
        System.out.println("System closed.");
    }
}