package com.example.QuizApplication;

import java.util.List;
import java.util.Map;

public class Quiz {
    private String sessionName;
    private Map<String, String> questionBank; 
    private List<List<String>> options;

    public Quiz(String sessionName, Map<String, String> questionBank, List<List<String>> options) {
        this.sessionName = sessionName;
        this.questionBank = questionBank;
        this.options = options;
    }

    public String getSessionName() { return sessionName; }
    public Map<String, String> getQuestionBank() { return questionBank; }
    public List<List<String>> getOptions() { return options; }
}
