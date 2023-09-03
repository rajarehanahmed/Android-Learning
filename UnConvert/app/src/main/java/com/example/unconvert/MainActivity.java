package com.example.unconvert;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;

public class MainActivity extends AppCompatActivity {
    Button btnClickMe;
//    ListView lv_Countries;
    Spinner spnCountries;
    AlertDialog.Builder alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnClickMe = findViewById(R.id.btnClick);
//        lv_Countries = findViewById(R.id.lvCountries);
        String[] cars = {"Toyota", "Honda", "Suzuki", "MG", "Kia", "Tesla"};
        spnCountries = findViewById(R.id.spnCountries);
        alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage("Are you sure to Exit?").setCancelable(true).setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });


//        ArrayAdapter<String> spnAdpCountries = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spnCountries)
//        ArrayAdapter<String> adpCountries = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, strCountries);

//        lv_Countries.setAdapter(adpCountries);
//        lv_Countries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                Toast.makeText(MainActivity.this, adpCountries.getItem(position),shor).show();
    }
//        });

//        btnClickMe.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//                intent.putExtra("name", "International Islamic University Islamabad");
//                startActivity(intent);
//            }
//        });
    //}
    public void onStart(){
        super.onStart();
    }
}