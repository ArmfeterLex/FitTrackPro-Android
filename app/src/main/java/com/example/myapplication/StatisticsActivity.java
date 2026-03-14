package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class StatisticsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        TextView tvStats = findViewById(R.id.tvStats);
        tvStats.setText("Статистика за неделю:\n\nШаги: 59 794\nКалории: 2 940\nДистанция: 36,4 км");
    }
}