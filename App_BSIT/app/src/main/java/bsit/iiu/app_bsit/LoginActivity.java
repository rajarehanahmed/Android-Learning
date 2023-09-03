package bsit.iiu.app_bsit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    TextView tvReceive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void onStart() {
        super.onStart();
        tvReceive =  findViewById(R.id.tvReceive);
        Intent intent = getIntent();
        tvReceive.setText(intent.getStringExtra("name"));
    }
}