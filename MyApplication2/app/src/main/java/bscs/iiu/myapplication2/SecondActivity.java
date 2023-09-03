package bscs.iiu.myapplication2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class SecondActivity extends AppCompatActivity {
    TextView tvUniName;
    Button btnFirstFragment, btnSecondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
//        tvUniName = findViewById(R.id.tvUniversityText);
//        Intent intent = getIntent();
//        tvUniName.setText(intent.getStringExtra("my_uni_name"));
        btnFirstFragment = findViewById(R.id.btnFirstFragment);
        btnSecondFragment = findViewById(R.id.btnSecondFragment);

        btnFirstFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnSecondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}