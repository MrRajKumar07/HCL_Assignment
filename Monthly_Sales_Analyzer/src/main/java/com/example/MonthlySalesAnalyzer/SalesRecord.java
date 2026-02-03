package com.example.MonthlySalesAnalyzer;

public class SalesRecord {
    private String month;
    private double revenue;

    public SalesRecord(String month, double revenue) {
        this.month = month;
        this.revenue = revenue;
    }

    public String getMonth() { return month; }
    public double getRevenue() { return revenue; }
}
