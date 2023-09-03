package bscs.iiu.bscs_b;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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

import java.util.List;


public class MainActivity extends AppCompatActivity {
    Button btn, btnAlertDialog;
    ListView lvCountries;
    AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        btnAlertDialog = findViewById(R.id.btnAlertDialog);
//        Toast.makeText(this, "Created", Toast.LENGTH_SHORT).show();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSend = new Intent(MainActivity.this, SecondActivity.class);
                intentSend.putExtra("name", "Islamic Republic of Pakistan");
                startActivity(intentSend);
            }
        });

        alertDialogBuilder = new AlertDialog.Builder(this);
        btnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialogBuilder.setMessage("This is Alert Dialog").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        Toast.makeText(getApplicationContext(), "You choose YES button", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        Toast.makeText(getApplicationContext(), "You choose NO button", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alert = alertDialogBuilder.create();
                alert.setTitle("Important Message");
                alert.show();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        lvCountries = findViewById(R.id.lvCountries);
        String[] arrCountries = {"Pakistan", "England", "USA", "Malaysia", "United Kingdom"};
        ArrayAdapter<String> adpCountries = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,R.string.arrCountries);
        lvCountries.setAdapter(adpCountries);
        lvCountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, adpCountries.getItem(i), Toast.LENGTH_SHORT).show();
                LinearLayout linLayout;
                linLayout = findViewById(R.id.linlayout);
                Snackbar snackbar = Snackbar.make(linLayout, adpCountries.getItem(i), BaseTransientBottomBar.LENGTH_LONG).setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar snackbar1 = Snackbar.make(linLayout, "Message is deleted", BaseTransientBottomBar.LENGTH_SHORT);
                        snackbar1.show();
                    }
                });
                snackbar.setActionTextColor(Color.RED);
                snackbar.show();
            }
        });
//        Toast.makeText(this, "Started", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRestart() {
        super.onRestart();
//       Toast.makeText(this, "Restarted", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
//        Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        super.onPause();
//        Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        super.onStop();
//        Toast.makeText(this, "Stopped", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        Toast.makeText(this, "Destroyed", Toast.LENGTH_SHORT).show();
    }
}