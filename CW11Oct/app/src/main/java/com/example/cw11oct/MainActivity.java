package com.example.cw11oct;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.DigitalClock;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    TextView tvDatePicker;
    TextView tvTimePicker;
    TimePicker timePicker;
//    DatePicker datePicker;
    DigitalClock dClock;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int hour;
        int  minute;

//        datePicker = findViewById(R.id.datePicker);
//        tvDatePicker.setText(String.format(datePicker.getDayOfMonth() + "/" + (datePicker.getMonth()) + "/" + datePicker.getYear()));

        timePicker = findViewById(R.id.timePicker);
        tvTimePicker = findViewById(R.id.tvTime);
//        tvTimePicker.setText(Integer.toString(timePicker.getHour()));
//        tvTimePicker.setText(Integer.parseInt(timePicker.getCurrentHour() + ":" + timePicker.getCurrentMinute()));
//        tvTimePicker.setText(String.format(timePicker.getCurrentHour() + ":" + timePicker.getCurrentMinute()));
//        tvTimePicker.setText(String.format(timePicker.getHour() + ":" + timePicker.getMinute()));
    }
}