package com.example.QuizApplication;

import java.util.*;

public class QuizService {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, String> questions = new LinkedHashMap<>();
        questions.put("What is the parent class of all Java classes?", "Object");
        questions.put("Which keyword is used for inheritance?", "extends");
        
        List<List<String>> options = Arrays.asList(
            Arrays.asList("A. Class", "B. Object", "C. JVM"),
            Arrays.asList("A. implements", "B. extends", "C. super")
        );

        Quiz javaSession = new Quiz("Java Basics", questions, options);

        int score = 0;
        int questionIndex = 0;
        
        System.out.println("--- Starting Session: " + javaSession.getSessionName() + " ---");

        for (String question : javaSession.getQuestionBank().keySet()) {
            System.out.println("\nQ: " + question);
            System.out.println("Options: " + javaSession.getOptions().get(questionIndex));
            
            System.out.print("Your Answer (type the full word): ");
            String userAnswer = sc.nextLine();
            
            if (userAnswer.equalsIgnoreCase(javaSession.getQuestionBank().get(question))) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! Correct answer was: " + javaSession.getQuestionBank().get(question));
            }
            questionIndex++;
        }

        System.out.println("\n--- Session Complete ---");
        System.out.println("Your Final Score: " + score + "/" + javaSession.getQuestionBank().size());
        
        sc.close();
    }
}
