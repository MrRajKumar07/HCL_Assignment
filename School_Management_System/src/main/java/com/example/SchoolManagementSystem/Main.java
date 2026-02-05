package com.example.SchoolManagementSystem;

import java.util.Scanner;

import com.example.SchoolManagementSystem.model.Course;
import com.example.SchoolManagementSystem.model.Student;
import com.example.SchoolManagementSystem.model.Teacher;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Initial Setup
        Teacher profSmith = new Teacher(1, "Dr. AnthoniRaj", "Computer Science");
        Course javaCourse = new Course("Java Programming", profSmith);

        System.out.println("--- School Management System ---");
        
        while (true) {
            System.out.println("\n1. Enroll Student  2. View Course Info  3. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.print("Enter Student ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Student Name: ");
                String name = scanner.nextLine();

                Student s = new Student(id, name);
                javaCourse.enroll(s);
                System.out.println("Student enrolled successfully!");

            } else if (choice == 2) {
                javaCourse.showCourseDetails();
            } else {
                System.out.println("Closing System...");
                break;
            }
        }
        scanner.close();
    }
}
