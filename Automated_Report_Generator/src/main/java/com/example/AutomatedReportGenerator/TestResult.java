package com.example.AutomatedReportGenerator;

public class TestResult {
    private String testName;
    private boolean isPassed;
    private double executionTime;

    public TestResult(String testName, boolean isPassed, double executionTime) {
        this.testName = testName;
        this.isPassed = isPassed;
        this.executionTime = executionTime;
    }

    // Getters
    public boolean isPassed() { return isPassed; }
    public double getExecutionTime() { return executionTime; }
    public String getTestName() { return testName; }
}