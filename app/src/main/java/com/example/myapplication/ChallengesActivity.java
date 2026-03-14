package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ChallengesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenges);

        TextView tvChallenges = findViewById(R.id.tvChallenges);
        tvChallenges.setText("Текущие челленджи:\n\n🏃 10 000 шагов в день\n🔥 Сжечь 500 калорий\n🚶 Пройти 5 км за день");
    }
}