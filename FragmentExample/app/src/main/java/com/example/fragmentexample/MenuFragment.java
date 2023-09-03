package com.example.fragmentexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;


public class MenuFragment extends ListFragment {
    String[] Countries = new String[]{"Pakistan", "India", "Iran", "China", "Afghanistan", "Russia", "Australia"};
    String[] Capitals = new String[]{"Islamabad", "Delhi", "Tehran", "Beijing", "Kabul", "Kremlin", "Sydney"};
//    Integer[] Flags=new Integer[]{R.drawable.pakistan_flag,R.drawable.pakistan_flag,R.drawable.pakistan_flag};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Countries);
        setListAdapter(adapter);

        return view;

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        TextFragment txt = (TextFragment) getFragmentManager().findFragmentById(R.id.fragment2);

        txt.change(Countries[position], Capitals[position]);
        getListView().setSelector(android.R.color.holo_blue_dark);
    }
}
