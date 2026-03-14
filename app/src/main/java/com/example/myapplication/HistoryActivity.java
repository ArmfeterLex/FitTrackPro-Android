package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Arrays;

public class HistoryActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        listView = findViewById(R.id.listView);

        ArrayList<String> workouts = new ArrayList<>(Arrays.asList(
                "Бег - 5,2 км - 30 мин",
                "Ходьба - 3,1 км - 45 мин",
                "Велосипед - 15,7 км - 60 мин",
                "Бег - 4,8 км - 28 мин",
                "Ходьба - 2,9 км - 40 мин"
        ));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, workouts);
        listView.setAdapter(adapter);
    }
}