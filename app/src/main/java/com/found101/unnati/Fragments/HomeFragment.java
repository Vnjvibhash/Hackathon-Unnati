package com.found101.unnati.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.found101.unnati.Adapters.HomeAdapter;
import com.found101.unnati.Adapters.MessageAdapter;
import com.found101.unnati.R;

public class HomeFragment extends Fragment {
    View view;

    RecyclerView pitch_recycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_home, container, false);

        pitch_recycler=view.findViewById(R.id.pitch_recycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        pitch_recycler.setLayoutManager(linearLayoutManager);

        HomeAdapter messageAdapter=new HomeAdapter(getContext());
        pitch_recycler.setAdapter(messageAdapter);

        return view;
    }
}