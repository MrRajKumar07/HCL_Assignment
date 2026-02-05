package com.example.htmlConverter;

import java.nio.file.*;
import java.io.IOException;

public class FileIO {
    public static String readMarkdown(String filePath) throws IOException {
        return Files.readString(Path.of(filePath));
    }

    public static void writeHtml(String filePath, String content) throws IOException {
        Files.writeString(Path.of(filePath), content);
    }
}