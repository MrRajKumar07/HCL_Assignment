package com.example.CsvToJsonConverter;

import java.util.Map;

public class DataRecord {
    private Map<String, String> data;

    public DataRecord(Map<String, String> data) {
        this.data = data;
    }

    public Map<String, String> getData() {
        return data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
