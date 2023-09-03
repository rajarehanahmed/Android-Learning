package com.example.classassessment29nov;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

public class SecondActivity extends AppCompatActivity {
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    TextView tv6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv1 = findViewById(R.id.tvCountry);
        tv2 = findViewById(R.id.tvPopulation);
        tv3 = findViewById(R.id.tvArea);
        tv4 = findViewById(R.id.tvCapital);
        tv5 = findViewById(R.id.tvLanguage);
        tv6 = findViewById(R.id.tvPresident);

        String country = getIntent().getExtras().getString("country");
        String[] values = {"", "", "", "", ""};
        switch (country.toLowerCase()){
            case "pakistan":
                values = getResources().getStringArray(R.array.pakistan);
                break;
            case "china":
                values = getResources().getStringArray(R.array.china);
                break;
            case "india":
                values = getResources().getStringArray(R.array.india);
                break;
            case "russia":
                values = getResources().getStringArray(R.array.russia);
                break;
            case "afghanistan":
                values = getResources().getStringArray(R.array.afghanistan);
                break;
            case "iran":
                values = getResources().getStringArray(R.array.iran);
                break;
            case "azerbaijan":
                values = getResources().getStringArray(R.array.azerbaijan);
                break;
            case "nepal":
                values = getResources().getStringArray(R.array.nepal);
                break;
            case "bangladesh":
                values = getResources().getStringArray(R.array.bangladesh);
                break;
            case "sri lanka":
                values = getResources().getStringArray(R.array.sri_lanka);
                break;
            case "usa":
                values = getResources().getStringArray(R.array.usa);
                break;
            case "canada":
                values = getResources().getStringArray(R.array.canada);
                break;
            case "saudi arabia":
                values = getResources().getStringArray(R.array.saudi_arabia);
                break;
            case "iraq":
                values = getResources().getStringArray(R.array.iraq);
                break;
            case "uk":
                values = getResources().getStringArray(R.array.uk);
                break;
            case "germany":
                values = getResources().getStringArray(R.array.germany);
                break;
            case "japan":
                values = getResources().getStringArray(R.array.japan);
                break;
            case "brazil":
                values = getResources().getStringArray(R.array.brazil);
                break;
            case "south africa":
                values = getResources().getStringArray(R.array.south_africa);
                break;
            case "namibia":
                values = getResources().getStringArray(R.array.namibia);
        }
        tv1.setText(country);
        tv2.setText(values[0]);
        tv3.setText(values[1]);
        tv4.setText(values[2]);
        tv5.setText(values[3]);
        tv6.setText(values[4]);
    }
}