package bscs.iiu.myapplication3;

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
    LinearLayout linlayout;
    ListView lvCountries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnClickMe = findViewById(R.id.btnClick);
        linlayout = findViewById(R.id.LinLayout);
        lvCountries = findViewById(R.id.lvCountries);


        String[] strCountries = {"Pakistan", "Malaysia", "Russia", "China", "Somalia"};
        ArrayAdapter<String> adpCountries = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.str_Countries));
        lvCountries.setAdapter(adpCountries);
        lvCountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Snackbar snackbar = Snackbar.make(linlayout, adpCountries.getItem(i), BaseTransientBottomBar.LENGTH_LONG);
                snackbar.show();
            }
        });
        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "Button is clicked", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//                intent.putExtra("my_uni_name","International Islamic University Islamabad");
//                startActivity(intent);

                Snackbar snackbar = Snackbar.make(linlayout, "This is Snackbar", BaseTransientBottomBar.LENGTH_LONG)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this, "You clicked the Undo Action button", Toast.LENGTH_SHORT).show();
                            }
                        });
                snackbar.setActionTextColor(Color.YELLOW);
                snackbar.show();
            }
        });
    }
}