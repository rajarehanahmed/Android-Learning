package com.example.finalprep;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class MainActivity extends AppCompatActivity {
    private RatingBar rtgBar;
    private SeekBar skBar;
    private TextView tv;
    private TextView name;
    private TextView email;
    private TextView contact;
    private Button btnFragment;
    private Button btnLogout;
    private FirebaseAuth fbAuth;
    private FirebaseFirestore fStore;
    private String userId;

    int seekbarStatus = 0;
    int ratingBarStatus = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rtgBar = findViewById(R.id.rtgBar);
        skBar = findViewById(R.id.skBar);
        tv = findViewById(R.id.tv3);
        name = findViewById(R.id.tv4);
        email = findViewById(R.id.tv5);
        contact = findViewById(R.id.tv6);
        btnFragment = findViewById(R.id.btnFragment);
        btnLogout = findViewById(R.id.btnLogout);
        fbAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        userId = fbAuth.getCurrentUser().getUid();

        DocumentReference documentRef = fStore.collection("users").document(userId);
        documentRef.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                name.setText(value.getString("name"));
                email.setText(value.getString("email"));
                contact.setText(value.getString("contactNo"));
            }
        });

        SharedPreferences spFetch = getSharedPreferences("rating", MODE_PRIVATE);
        skBar.setProgress(spFetch.getInt("seekbarStatus", 20));
        rtgBar.setProgress(spFetch.getInt("ratingbarStatus", '0'));


        skBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tv.setTextSize(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        rtgBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                ratingBarStatus = (int) v;
                switch((int) v){
                    case 1 :
                        tv.setText("Very Disappointed");
                        break;
                    case 2:
                        tv.setText("Disappointed");
                        break;
                    case 3:
                        tv.setText("Neutral");
                        break;
                    case 4:
                        tv.setText("Happy");
                        break;
                    case 5:
                        tv.setText("Very Happy");
                }
            }
        });

        btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Fragments.class));
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fbAuth.signOut();
                Toast.makeText(MainActivity.this, "Logged out Successfully.", Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this, Login.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.menuAboutUs:
                Intent intentSend = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intentSend);
        }
        return true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences spSave = getSharedPreferences("rating", MODE_PRIVATE);
        spSave.edit().putInt("seekbarStatus", seekbarStatus).commit();
        spSave.edit().putInt("ratingbarStatus", ratingBarStatus).commit();
    }
}