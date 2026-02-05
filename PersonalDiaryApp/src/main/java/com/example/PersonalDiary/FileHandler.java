package com.example.PersonalDiary;

import java.nio.file.*;
import java.io.IOException;
import java.util.List;

public class FileHandler {
    private static final Path PATH = Path.of("diary.txt");

    public static void saveEntry(String content) throws IOException {
        Files.writeString(PATH, content + System.lineSeparator(), 
            StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    public static List<String> readAllEntries() throws IOException {
        if (!Files.exists(PATH)) return List.of("No entries found.");
        return Files.readAllLines(PATH);
    }
}
