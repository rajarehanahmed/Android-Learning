package com.example.listfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TextFragment extends Fragment {
    TextView tv1;
    TextView tv2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text, container, false);
        tv1 = (TextView) view.findViewById(R.id.tvCntry);
        tv2 = (TextView) view.findViewById(R.id.tvCptl);
        return view;
    }
    public void change(String country, String capital){
        tv1.setText(country);
        tv2.setText(capital);
    }
}
