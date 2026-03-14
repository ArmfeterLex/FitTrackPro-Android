package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView tvDate, tvSteps, tvCalories, tvDistance, tvHeartRate;
    private Button btnStartWorkout, btnHistory, btnProfile, btnStatistics, btnChallenges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        setupClickListeners();
        updateDailyStats();
    }

    private void initializeViews() {
        tvDate = findViewById(R.id.tvDate);
        tvSteps = findViewById(R.id.tvSteps);
        tvCalories = findViewById(R.id.tvCalories);
        tvDistance = findViewById(R.id.tvDistance);
        tvHeartRate = findViewById(R.id.tvHeartRate);

        btnStartWorkout = findViewById(R.id.btnStartWorkout);
        btnHistory = findViewById(R.id.btnHistory);
        btnProfile = findViewById(R.id.btnProfile);
        btnStatistics = findViewById(R.id.btnStatistics);
        btnChallenges = findViewById(R.id.btnChallenges);

        String currentDate = new SimpleDateFormat("EEEE, d MMMM", new Locale("ru")).format(new Date());
        tvDate.setText(currentDate);
    }

    private void setupClickListeners() {
        btnStartWorkout.setOnClickListener(v -> startActivity(new Intent(this, WorkoutActivity.class)));
        btnHistory.setOnClickListener(v -> startActivity(new Intent(this, HistoryActivity.class)));
        btnProfile.setOnClickListener(v -> startActivity(new Intent(this, ProfileActivity.class)));
        btnStatistics.setOnClickListener(v -> startActivity(new Intent(this, StatisticsActivity.class)));
        btnChallenges.setOnClickListener(v -> startActivity(new Intent(this, ChallengesActivity.class)));
    }

    private void updateDailyStats() {
        tvSteps.setText("8 542");
        tvCalories.setText("420");
        tvDistance.setText("5,2 км");
        tvHeartRate.setText("72");
    }
}