package com.example.wordFrequency;

public class WordCount {
    private String word;
    private int frequency;

    public WordCount(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    public String getWord() { return word; }
    public int getFrequency() { return frequency; }

    @Override
    public String toString() {
        return String.format("%-15s : %d", word, frequency);
    }
}