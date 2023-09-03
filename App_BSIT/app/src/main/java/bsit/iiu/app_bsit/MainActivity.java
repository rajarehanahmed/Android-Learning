package bsit.iiu.app_bsit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    ListView lv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().hide();
        lv = findViewById(R.id.lv);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.putExtra("name", "Muhammad Waheed Khan");
                startActivity(intent);
            }
        });
    }

    public void onStart() {
        super.onStart();
        //String[] countries = getResources().getStringArray(R.array.country_names);
        ArrayAdapter<String> adp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.country_names));
        lv.setAdapter(adp);
    }


}