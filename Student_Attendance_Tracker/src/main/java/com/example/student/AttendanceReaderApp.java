package com.example.student;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AttendanceReaderApp {

    public static List<AttendanceRecord> readAttendanceData(String fileName) {
        List<AttendanceRecord> records = new ArrayList<>();
        
        InputStream is = AttendanceReaderApp.class.getClassLoader().getResourceAsStream(fileName);
        
        if (is == null) {
            System.err.println("Error: File '" + fileName + "' not found in src/main/resources");
            return records;
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 3) {
                    records.add(new AttendanceRecord(values[0], values[1], values[2]));
                }
            }
        } catch (Exception e) {
            System.err.println("Error processing CSV: " + e.getMessage());
        }
        
        return records;
    }

    public static void main(String[] args) {
        String targetFile = "students.csv"; 
        
        List<AttendanceRecord> history = readAttendanceData(targetFile);

        System.out.println("Reading data from: " + targetFile);
        System.out.println("----------------------------------------------");
        
        if (history.isEmpty()) {
            System.out.println("No records found. Check if the file has data.");
        } else {
            for (AttendanceRecord record : history) {
                System.out.println(record);
            }
        }
    }
}