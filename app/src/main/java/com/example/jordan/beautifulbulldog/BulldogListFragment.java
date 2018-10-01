package com.example.jordan.beautifulbulldog;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BulldogListFragment extends Fragment {

    private RecyclerView bulldog_list;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter bulldogAdapter;

    public BulldogListFragment() {
       //empty constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bulldog_list_fragement, container, false);

        ArrayList<Bulldog> bulldogs = new ArrayList<Bulldog>();
        bulldog_list = (RecyclerView)view.findViewById(R.id.bulldog_list);

        Bulldog bulldog1 = new Bulldog();
        bulldog1.setAge("9");
        bulldog1.setName("Porterhouse");

        Bulldog bulldog2 = new Bulldog();
        bulldog2.setAge("2");
        bulldog2.setName("Drake");

        bulldogs.add(bulldog1);
        bulldogs.add(bulldog2);

        layoutManager = new LinearLayoutManager(getContext());
        bulldog_list.setLayoutManager(layoutManager);

        bulldogAdapter = new BulldogAdapter(getContext(), bulldogs);
        bulldog_list.setAdapter(bulldogAdapter);

        return view;
    }

}
