package com.example.finalprep;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TextFragment extends Fragment {
    TextView tvCountry;
    TextView tvCapital;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_text, container, false);

        tvCountry = (TextView) view.findViewById(R.id.tvCountry);
        tvCapital = (TextView) view.findViewById(R.id.tvCapital);

        return view;
    }
    public void change(String country, String capital){
        tvCountry.setText(country);
        tvCapital.setText(capital);
    }
}