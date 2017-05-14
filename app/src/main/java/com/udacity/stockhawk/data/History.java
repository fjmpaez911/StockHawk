package com.udacity.stockhawk.data;


import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class History {

    public static final String DELIMITER = ";";

    private List<HistoryEntry> history;

    public History() {
        this.history = new ArrayList<>();
    }

    public History(List<HistoryEntry> history) {
        this.history = history;
    }

    public History(String history) {

        String[] entries = history.split(DELIMITER);

        this.history = new ArrayList<>();

        for (String entry : entries) {
            HistoryEntry historyEntry = new HistoryEntry(entry);
            this.history.add(historyEntry);
        }
    }

    public List<HistoryEntry> getHistory() {
        return history;
    }

    public void setHistory(List<HistoryEntry> history) {
        this.history = history;
    }

    public void add (HistoryEntry entry) {
        this.history.add(entry);
    }

    public List<Entry> getEntryList() {

        List<Entry> list = new ArrayList<>();

        for (HistoryEntry entry : this.history) {
            list.add(entry.getEntry());
        }

        sort(list);

        return list;
    }

    @Override
    public String toString() {

        StringBuilder list = new StringBuilder();

        for (HistoryEntry entry : history) {

            list.append(entry.toString());
            list.append(DELIMITER);

        }

        return list.toString();
    }

    private void sort(List<Entry> list) {
        Collections.sort(list, new Comparator<Entry>() {
            @Override
            public int compare(Entry o1, Entry o2) {
                int compare = 0;

                if (o1.getX() > o2.getX()) {
                    compare = 1;
                } else if (o1.getX() < o2.getX()){
                    compare = -1;
                }

                return compare;
            }
        });
    }
}
