package com.example.fragmentexample;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TextFragment extends Fragment {
    TextView textCountry, textCapital;
    ImageView imgFlag;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.text_fragment, container, false);
        textCountry = (TextView) view.findViewById(R.id.Country);
        textCapital = (TextView) view.findViewById(R.id.Capital);
        return view;
    }

    public void change(String txtCountry, String strCapitals) {
        textCountry.setText(txtCountry);
        textCapital.setText(strCapitals);
    }
}
