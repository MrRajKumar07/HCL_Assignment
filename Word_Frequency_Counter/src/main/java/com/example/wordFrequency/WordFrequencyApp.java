package com.example.wordFrequency;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordFrequencyApp {

    public static Map<String, Integer> countWordFrequency(String text) {
        Map<String, Integer> counts = new HashMap<>();
        
        String cleanText = text.replaceAll("[^a-zA-Z ]", "").toLowerCase();

        String[] words = cleanText.split("\\s+");

        for (String word : words) {
            if (word.isEmpty()) continue;
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        return counts;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("--- Text Analytics: Word Frequency Counter ---");
        System.out.println("Enter your text below :");

        while (true) {
            System.out.print("\nInput: ");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("exit")) break;

            Map<String, Integer> result = countWordFrequency(input);

            System.out.println("\n--- Analysis Results ---");
            System.out.println("Unique Words: " + result.size());
            
            for (Map.Entry<String, Integer> entry : result.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
        
        sc.close();
        System.out.println("Analysis Complete.");
    }
}