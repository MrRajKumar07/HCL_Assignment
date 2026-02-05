package com.example.htmlConverter;

public class Main {
    public static void main(String[] args) {
        String inputPath = "E:\\HclAssessment\\Markdown_to_HTML_Converter\\input.md";
        String outputPath = "E:\\HclAssessment\\Markdown_to_HTML_Converter\\output.html";

        try {
            String markdownContent = FileIO.readMarkdown(inputPath);
            String htmlContent = Converter.process(markdownContent);
            FileIO.writeHtml(outputPath, htmlContent);
            
            System.out.println("Success! File saved at: " + outputPath);
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
}

