package com.udacity.stockhawk.ui;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.udacity.stockhawk.R;
import com.udacity.stockhawk.data.History;
import com.udacity.stockhawk.data.HistoryEntry;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import timber.log.Timber;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class DetailActivity extends AppCompatActivity  {

    public final static String EXTRA_HISTORY = "historyAsString";
    public final static String EXTRA_STOCK = "stockName";

    private LineChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        chart = (LineChart) findViewById(R.id.chart);

        Intent intent = getIntent();

        if (intent.hasExtra(EXTRA_HISTORY)) {
            String historyAsString = (String) intent.getSerializableExtra(EXTRA_HISTORY);
            String stockName = (String) intent.getSerializableExtra(EXTRA_STOCK);

            History history = new History(historyAsString);
            paint(history.getEntryList(), stockName);

        }
    }

    private void paint (List<Entry> entries, String stock) {

        LineDataSet dataSet = new LineDataSet(entries, stock);

        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);

        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.TOP_INSIDE);
        xAxis.setTextColor(Color.WHITE);
        xAxis.setValueFormatter(new IAxisValueFormatter() {

            private SimpleDateFormat mFormat = new SimpleDateFormat("dd-MM-yyyy");

            @Override
            public String getFormattedValue(float value, AxisBase axis) {

                long millis = (long) value;
                return mFormat.format(new Date(millis));
            }
        });

    }

}
