package com.example.finalprep;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.w3c.dom.Text;

public class ListFragment extends Fragment {
    ListView lv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        lv = (ListView) view.findViewById(R.id.lv1);

        String[] countries = new String[]{"Pakistan", "China", "Russia", "Iran", "Afghanistan", "Saudi Arabia", "England", "USA", "Turkey"};
        String[] capitals = new String[]{"Islamabad", "Beijing", "Moscow", "Tehran", "Kabul", "Riyadh", "London", "Washington DC", "Ankara"};
        ArrayAdapter<String> adp = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, countries);
        lv.setAdapter(adp);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextFragment txtFrag = (TextFragment) getFragmentManager().findFragmentById(R.id.fragment2);
                txtFrag.change(countries[i], capitals[i]);
                lv.setSelector(android.R.color.holo_blue_light);
            }
        });

        return view;
    }

}