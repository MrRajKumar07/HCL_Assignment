package com.example.MonthlySalesAnalyzer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesAnalysisService {

    public static void generateReport(List<SalesRecord> records) {
        if (records.isEmpty()) return;
        
        Map<String, Double> monthlyTotals = new HashMap<>();

        for (SalesRecord record : records) {
            String month = record.getMonth();
            double currentTotal = monthlyTotals.getOrDefault(month, 0.0);
            monthlyTotals.put(month, currentTotal + record.getRevenue());
        }

        double totalYearlyRevenue = 0;
        double maxSales = Double.MIN_VALUE;
        double minSales = Double.MAX_VALUE;
        String bestMonth = "";
        String worstMonth = "";

        System.out.println("======= MONTHLY SALES PERFORMANCE =======");
        System.out.printf("%-15s | %-15s\n", "Month", "Revenue");
        System.out.println("-----------------------------------------");

        for (Map.Entry<String, Double> entry : monthlyTotals.entrySet()) {
            double revenue = entry.getValue();
            String month = entry.getKey();
            
            System.out.printf("%-15s | $%-15.2f\n", month, revenue);

            totalYearlyRevenue += revenue;

            if (revenue > maxSales) {
                maxSales = revenue;
                bestMonth = month;
            }
            if (revenue < minSales) {
                minSales = revenue;
                worstMonth = month;
            }
        }

        System.out.println("-----------------------------------------");
        System.out.printf("Total Revenue    : $%.2f\n", totalYearlyRevenue);
        System.out.printf("Average Monthly  : $%.2f\n", (totalYearlyRevenue / monthlyTotals.size()));
        System.out.println("Best Performer   : " + bestMonth + " ($" + maxSales + ")");
        System.out.println("Worst Performer  : " + worstMonth + " ($" + minSales + ")");
        System.out.println("=========================================");
    }

    public static void main(String[] args) {
        String csvData = "January,4500.00\n" +
                         "February,3800.50\n" +
                         "January,1200.00\n" + // Same month, will be aggregated
                         "March,5100.00\n" +
                         "February,2000.00\n" +
                         "April,4200.75";

        List<SalesRecord> list = new ArrayList<>();
        String[] rows = csvData.split("\n");

        for (String row : rows) {
            String[] cols = row.split(",");
            list.add(new SalesRecord(cols[0], Double.parseDouble(cols[1])));
        }

        generateReport(list);
    }
}
