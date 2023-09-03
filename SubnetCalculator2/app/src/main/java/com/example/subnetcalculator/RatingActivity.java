package com.example.subnetcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class RatingActivity extends AppCompatActivity {
    RatingBar ratingBar;
    Button btnSubmit;
    TextView tvRating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvRating = findViewById(R.id.tv1);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvRating.setText("Rating : " + ratingBar.getRating());
            }
        });


    }
}