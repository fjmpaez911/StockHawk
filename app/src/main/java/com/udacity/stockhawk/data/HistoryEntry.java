package com.udacity.stockhawk.data;


import com.github.mikephil.charting.data.Entry;

public class HistoryEntry {

    public static final String DELIMITER = ",";

    private String timestamp;
    private String value;

    public HistoryEntry(String timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }

    public HistoryEntry(String entry) {

        String[] values = entry.split(DELIMITER);

        this.timestamp = values[0];
        this.value = values[1];
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Entry getEntry () {
        return new Entry(Long.valueOf(this.timestamp), Float.valueOf(this.value));
    }

    @Override
    public String toString() {
        return timestamp + DELIMITER + value;
    }

}
