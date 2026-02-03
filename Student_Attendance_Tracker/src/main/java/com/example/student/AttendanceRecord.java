package com.example.student;

public class AttendanceRecord {
    private String studentName;
    private String status;
    private String date;

    public AttendanceRecord(String studentName, String status, String date) {
        this.studentName = studentName;
        this.status = status;
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("%-20s | %-10s | %s", studentName, status, date);
    }
}
