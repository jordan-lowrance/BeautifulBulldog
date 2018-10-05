package com.example.jordan.beautifulbulldog;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.realm.Realm;
import io.realm.RealmResults;


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

        Realm realm = Realm.getDefaultInstance();
        final RealmResults<Bulldog> bulldogs = realm.where(Bulldog.class).findAll();

        layoutManager = new LinearLayoutManager(getContext());
        bulldog_list.setLayoutManager(layoutManager);

        final MainActivity mainActivity = (MainActivity) this.getActivity();

        RecyclerViewClickListener listener = new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Bulldog bulldog = bulldogs.get(position);
                Intent intent = new Intent(view.getContext(), BulldogActivity.class);
                intent.putExtra("username", mainActivity.user.getUsername());
                intent.putExtra("bulldog", bulldog.getId());
                startActivity(intent);
            }
        };


        bulldogAdapter = new BulldogAdapter(getContext(), bulldogs, listener);
        bulldog_list.setAdapter(bulldogAdapter);

        return view;
    }

}
