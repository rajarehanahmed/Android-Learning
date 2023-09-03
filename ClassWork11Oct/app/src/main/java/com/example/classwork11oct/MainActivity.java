package com.example.classwork11oct;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textviewDatePicker;
    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textviewDatePicker = findViewById(R.id.tvDate);
        datePicker = findViewById(R.id.tvDatePicker);
        textviewDatePicker.setText(Integer.parseInt(datePicker.getDayOfMonth() + "/" + datePicker.getMonth() + "/" + datePicker.getYear()));
    }
}