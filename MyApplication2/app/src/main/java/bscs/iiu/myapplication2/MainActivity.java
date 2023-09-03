package bscs.iiu.myapplication2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    Button btnClickMe;
    LinearLayout LinLayout;
    //    ListView lview;
    Spinner spnCountries;
    AlertDialog.Builder alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnClickMe = findViewById(R.id.btnClick);
        LinLayout = findViewById(R.id.mainLayout);
        spnCountries = findViewById(R.id.spnCountries);
        alertDialog = new AlertDialog.Builder(this);

        alertDialog.setMessage("Are you sure to Exit?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        alertDialog.create();
        alertDialog.setTitle("Options to Exit");

        String[] cars = {"Audi", "BWM", "Mercedes", "Suzuki", "Toyota", "Honda", "MG", "Tesla", "Kia"};

        ArrayAdapter<String> spnAdpCountries = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.arrCountries));
        spnCountries.setAdapter(spnAdpCountries);

//        lview = findViewById(R.id.lvCars);


        ArrayAdapter<String> adpCars = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.arrCountries));
//        lview.setAdapter(adpCars);
//        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Snackbar snackbar = Snackbar.make(LinLayout, adpCars.getItem(i), BaseTransientBottomBar.LENGTH_LONG);
//                snackbar.show();
//            }
//        });
//
        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "You click the button", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//                intent.putExtra("my_uni_name", "International Islamic University Islamabad");
//                startActivity(intent);
                alertDialog.show();
//                Snackbar snackbar = Snackbar.make(LinLayout, "International Islamic University Islamabad", BaseTransientBottomBar.LENGTH_LONG)
//                        .setAction("Undo", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                Toast.makeText(MainActivity.this, "You clicked the UNDO button on Snackbar", Toast.LENGTH_SHORT).show();
//
//                            }
//                        });
//                snackbar.setActionTextColor(Color.YELLOW);
//                snackbar.show();

            }
        });
    }
}