package com.example.SchoolManagementSystem.model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    private Teacher teacher;
    private List<Student> enrolledStudents;

    public Course(String courseName, Teacher teacher) {
        this.courseName = courseName;
        this.teacher = teacher;
        this.enrolledStudents = new ArrayList<>();
    }

    public void enroll(Student student) {
        enrolledStudents.add(student);
    }

    public void showCourseDetails() {
        System.out.println("\nCourse: " + courseName);
        System.out.println("Taught by: " + teacher.getName());
        System.out.println("Enrolled Students:");
        if (enrolledStudents.isEmpty()) {
            System.out.println("- No students yet.");
        } else {
            for (Student s : enrolledStudents) {
                System.out.println("- " + s.getName());
            }
        }
    }
}
