package bscs.iiu.myapplication4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner spnCountries;
    AutoCompleteTextView autoCompTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spnCountries = findViewById(R.id.spinnerCountries);
        autoCompTV = findViewById(R.id.autoCompleteTV);
        getSupportActionBar().hide();

        ArrayAdapter<String> adpSpnCountries = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.arrCountries));

        ArrayAdapter<String> adpAutoCompCountries = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.arrCountries));

        spnCountries.setAdapter(adpSpnCountries);

        autoCompTV.setAdapter(adpAutoCompCountries);
        autoCompTV.setThreshold(1);

    }
}