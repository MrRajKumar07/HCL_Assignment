package com.example.CsvToJsonConverter;

import java.io.*;
import java.util.*;

public class CsvToJsonConverter {
	
    public static String convert(String csvContent) {
        String[] lines = csvContent.split("\n");
        if (lines.length < 2) return "[]";

        String[] headers = lines[0].split(",");
        StringBuilder jsonBuilder = new StringBuilder("[\n");

        for (int i = 1; i < lines.length; i++) {
            String[] values = lines[i].split(",");
            jsonBuilder.append("  {\n");

            for (int j = 0; j < headers.length; j++) {
                jsonBuilder.append("    \"").append(headers[j].trim()).append("\": ");
                jsonBuilder.append("\"").append(values[j].trim()).append("\"");
                
                if (j < headers.length - 1) jsonBuilder.append(",");
                jsonBuilder.append("\n");
            }

            jsonBuilder.append("  }");
            if (i < lines.length - 1) jsonBuilder.append(",");
            jsonBuilder.append("\n");
        }

        jsonBuilder.append("]");
        return jsonBuilder.toString();
    }

    public static void main(String[] args) {
        String csvInput = "id,name,dept,grade\n" +
                          "101,Raj,IT,A\n" +
                          "102,Kumar,CS,B\n" +
                          "103,Amit,IT,A";

        System.out.println("--- CSV to JSON Converter ---");
        System.out.println("Input CSV:\n" + csvInput);

        String jsonOutput = convert(csvInput);

        System.out.println("\nConverted JSON Array:");
        System.out.println(jsonOutput);

    }
}
