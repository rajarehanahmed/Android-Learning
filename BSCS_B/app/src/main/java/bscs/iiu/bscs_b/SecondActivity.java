package bscs.iiu.bscs_b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class SecondActivity extends AppCompatActivity {
    TextView tv;
    LinearLayout lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv = findViewById(R.id.tvSecond);
        lv = findViewById(R.id.lvSecond);
        tv.setText(getIntent().getExtras().getString("name"));
        Snackbar snackbar = Snackbar.make(lv, "Message deleted", BaseTransientBottomBar.LENGTH_SHORT);
        snackbar.show();
    }
}