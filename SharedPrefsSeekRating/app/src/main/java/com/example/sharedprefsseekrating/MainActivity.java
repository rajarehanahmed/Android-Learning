package com.example.sharedprefsseekrating;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvFetch;
    EditText editText;
    Button btnSave, btnFetch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvFetch = findViewById(R.id.tvFetchText);
        editText = findViewById(R.id.edtText);
        btnSave = findViewById(R.id.btnSave);
        btnFetch = findViewById(R.id.btnFetch);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences spSave = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                spSave.edit().putString("name", editText.getText().toString()).commit();
                Toast.makeText(getApplicationContext(), "Data Saved", Toast.LENGTH_SHORT).show();
            }
        });
        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences spFetch = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                tvFetch.setText(spFetch.getString("name", null));
                Toast.makeText(getApplicationContext(), "Data Fetched Successfully", Toast.LENGTH_SHORT).show();

                spFetch.edit().clear().remove("name").commit();
            }
        });
    }
}