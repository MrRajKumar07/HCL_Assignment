package com.example.SchoolManagementSystem.model;

public class Teacher {
    private int id;
    private String name;
    private String subject;

    public Teacher(int id, String name, String subject) {
        this.id = id;
        this.name = name;
        this.subject = subject;
    }

    public String getName() { return name; }
    public String getSubject() { return subject; }
    
    @Override
    public String toString() { return "Teacher: " + name + " (" + subject + ")"; }
}
