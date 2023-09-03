package com.example.practice9oct;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class SecondActivity extends AppCompatActivity {
    TextView tv;
    Spinner spnCountries;
    LinearLayout linL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv = findViewById(R.id.tvSecond);
        spnCountries = findViewById(R.id.countriesSpinner);
        linL = findViewById(R.id.linlayout);
        tv.setText(getIntent().getExtras().getString("name"));
        ArrayAdapter<String> spnAdpCountries = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.arrCountries));
        spnCountries.setAdapter(spnAdpCountries);
        Snackbar snackbar = Snackbar.make(linL, "Message Deleted", BaseTransientBottomBar.LENGTH_SHORT);
        snackbar.show();

    }
}