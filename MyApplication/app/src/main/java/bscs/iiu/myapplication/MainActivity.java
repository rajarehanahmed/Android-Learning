package bscs.iiu.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    Button btnClickMe;
    ListView lv_Countries;
    LinearLayout LinLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnClickMe = findViewById(R.id.btnClick);
        lv_Countries = findViewById(R.id.lvCountries);
        LinLayout = findViewById(R.id.linlayout);
        String[] strCountries = {"Pakistan", "Poland", "Russia", "Czech"};

        ArrayAdapter<String> adpCountries = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Country_names));
        lv_Countries.setAdapter(adpCountries);
        lv_Countries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                Toast.makeText(MainActivity.this, adpCountries.getItem(position), Toast.LENGTH_SHORT).show();
                Snackbar snackbar = Snackbar.make(LinLayout, adpCountries.getItem(position), BaseTransientBottomBar.LENGTH_SHORT).setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "You clicked the UNDO Action Button", Toast.LENGTH_SHORT).show();
                    }
                });
                snackbar.setActionTextColor(Color.YELLOW);
                snackbar.show();
            }
        });

        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "You clicked this button", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("name", "International Islamic University Islamabad");
                startActivity(intent);
            }
        });

    }

    public void onStart() {
        super.onStart();

    }
}