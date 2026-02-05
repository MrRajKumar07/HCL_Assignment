package com.example.htmlConverter;

public class Converter {
    public static String process(String text) {
        return text
            .replaceAll("(?m)^# (.*)$", "<h1>$1</h1>") 
            .replaceAll("(?m)^## (.*)$", "<h2>$1</h2>")
            .replaceAll("\\*\\*(.*?)\\*\\*", "<b>$1</b>") 
            .replaceAll("(?m)^\\* (.*)$", "<li>$1</li>");
    }
}
