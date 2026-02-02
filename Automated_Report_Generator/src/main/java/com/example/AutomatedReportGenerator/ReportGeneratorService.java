package com.example.AutomatedReportGenerator;

import java.util.ArrayList;
import java.util.List;

public class ReportGeneratorService {

    public static void generateSummary(List<TestResult> results) {
        if (results.isEmpty()) return;

        int totalTests = results.size();
        int passedCount = 0;
        double totalTime = 0;
        double maxTime = Double.MIN_VALUE;
        String slowestTest = "";

        for (TestResult r : results) {
            if (r.isPassed()) passedCount++;
            totalTime += r.getExecutionTime();
            
            if (r.getExecutionTime() > maxTime) {
                maxTime = r.getExecutionTime();
                slowestTest = r.getTestName();
            }
        }

        double avgTime = totalTime / totalTests;
        double passPercentage = ((double) passedCount / totalTests) * 100;

        System.out.println("======= PERFORMANCE SUMMARY REPORT =======");
        System.out.println("Total Tests Run    : " + totalTests);
        System.out.println("Passed             : " + passedCount);
        System.out.println("Failed             : " + (totalTests - passedCount));
        System.out.println("Pass Percentage    : " + String.format("%.2f%%", passPercentage));
        System.out.println("Average Exec Time  : " + String.format("%.2fs", avgTime));
        System.out.println("Slowest Test       : " + slowestTest + " (" + maxTime + "s)");
        System.out.println("Overall Status     : " + (passPercentage >= 75 ? "PASS" : "FAIL"));
        System.out.println("==========================================");
    }

    public static void main(String[] args) {
        String fileContent = "LoginTest,true,0.5\n" +
                             "PaymentTest,false,2.1\n" +
                             "SearchTest,true,1.2\n" +
                             "LogoutTest,true,0.3\n" +
                             "ProfileUpdate,true,1.8";

        List<TestResult> resultsList = new ArrayList<>();
        String[] lines = fileContent.split("\n");

        for (String line : lines) {
            String[] parts = line.split(",");
            resultsList.add(new TestResult(
                parts[0], 
                Boolean.parseBoolean(parts[1]), 
                Double.parseDouble(parts[2])
            ));
        }

        System.out.println("Reading performance data...\n");
        generateSummary(resultsList);
    }
}
