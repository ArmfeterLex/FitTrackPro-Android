package com.example.myapplication;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class WorkoutActivity extends AppCompatActivity {

    private TextView tvTimer, tvWorkoutType;
    private Button btnStartStop, btnPauseResume;
    private CountDownTimer timer;
    private boolean isRunning = false;
    private long timeLeft = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        tvTimer = findViewById(R.id.tvTimer);
        tvWorkoutType = findViewById(R.id.tvWorkoutType);
        btnStartStop = findViewById(R.id.btnStartStop);
        btnPauseResume = findViewById(R.id.btnPauseResume);

        btnStartStop.setOnClickListener(v -> toggleTimer());
        btnPauseResume.setOnClickListener(v -> pauseResumeTimer());

        updateTimerDisplay();
    }

    private void toggleTimer() {
        if (!isRunning) {
            startTimer();
        } else {
            stopTimer();
        }
    }

    private void startTimer() {
        if (timeLeft == 0) {
            timeLeft = 30 * 60 * 1000;
        }

        timer = new CountDownTimer(timeLeft, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeft = millisUntilFinished;
                updateTimerDisplay();
            }

            @Override
            public void onFinish() {
                isRunning = false;
                timeLeft = 0;
                updateTimerDisplay();
                btnStartStop.setText("Старт");
                btnPauseResume.setEnabled(false);
            }
        }.start();

        isRunning = true;
        btnStartStop.setText("Стоп");
        btnPauseResume.setEnabled(true);
        btnPauseResume.setText("Пауза");
    }

    private void stopTimer() {
        if (timer != null) {
            timer.cancel();
        }
        isRunning = false;
        timeLeft = 0;
        updateTimerDisplay();
        btnStartStop.setText("Старт");
        btnPauseResume.setEnabled(false);
    }

    private void pauseResumeTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
            isRunning = false;
            btnPauseResume.setText("Продолжить");
        } else {
            startTimer();
        }
    }

    private void updateTimerDisplay() {
        int minutes = (int) (timeLeft / 1000) / 60;
        int seconds = (int) (timeLeft / 1000) % 60;
        tvTimer.setText(String.format("%02d:%02d", minutes, seconds));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
        }
    }
}