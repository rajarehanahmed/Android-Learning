package com.example.classassessment29nov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lv1;
    String[] countries = new String[]{"Pakistan", "China", "India", "Russia", "Afghanistan", "Iran", "Azerbaijan", "Nepal", "Bangladesh", "Sri Lanka", "USA", "Canada", "Saudi Arabia", "Iraq", "UK", "Germany", "Japan", "Brazil", "South Africa", "Namibia"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv1 = findViewById(R.id.lv);
        ArrayAdapter<String> adpCountries = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countries);
        lv1.setAdapter(adpCountries);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intentSend = new Intent(MainActivity.this, SecondActivity.class);
                intentSend.putExtra("country", countries[i]);
                startActivity(intentSend);
            }
        });
     }
}