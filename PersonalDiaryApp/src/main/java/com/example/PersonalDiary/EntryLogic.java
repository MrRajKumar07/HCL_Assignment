package com.example.PersonalDiary;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EntryLogic {
    public static String formatNote(String note) {
        String timestamp = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return "[" + timestamp + "] " + note;
    }
}