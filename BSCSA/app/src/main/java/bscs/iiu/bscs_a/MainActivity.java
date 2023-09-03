package bscs.iiu.bscs_a;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner spnCountries;
    String tag = "Life cycle step";
    private TextView tv;
    private Button btnClickMe;
    private ListView lview;
    AlertDialog.Builder alertDialog;
    AutoCompleteTextView autoComTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] items = new String[]{"BMW", "Mercedes", "Toyota", "Suzuki"};
        tv = findViewById(R.id.txtview1);
        btnClickMe = findViewById(R.id.btnClickMe);

        autoComTV = findViewById(R.id.autoCompleteTV);

        spnCountries = findViewById(R.id.spnCountries);

        //lview = findViewById(R.id.lv);
        ArrayAdapter<String> AdplistItems = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.countires));
        spnCountries.setAdapter(AdplistItems);
        ArrayAdapter<String> AdpAutoTV = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, getResources().getStringArray(R.array.countires));
        autoComTV.setThreshold(1);
        autoComTV.setAdapter(AdpAutoTV);
        autoComTV.setTextColor(Color.RED);

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage("Do you really want to Exit?")
                .setCancelable(true)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
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

        alertDialog.setTitle("Confirmation");
//        alertDialog.show();
        //lview.setAdapter(AdplistItems);
//        btnClickMe.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//                startActivity(intent);
//            }
//        });

    }
}