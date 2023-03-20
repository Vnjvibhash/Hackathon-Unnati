package com.found101.unnati.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.found101.unnati.Adapters.HomeAdapter;
import com.found101.unnati.R;
import com.found101.unnati.Utils.Session;

public class ProfileFragment extends Fragment {
    View view;
    LinearLayout profile_view1,profile_view2;
    Session session;
    RecyclerView new_pitches;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_profile, container, false);
        profile_view1=view.findViewById(R.id.profile_view1);
        profile_view2=view.findViewById(R.id.profile_view2);
        new_pitches=view.findViewById(R.id.new_pitches);
        session= new Session(getContext());
        if (session.getRole() == "4") {
            profile_view1.setVisibility(View.GONE);
            profile_view2.setVisibility(View.VISIBLE);
        } else if (session.getRole() == "3") {
            profile_view1.setVisibility(View.VISIBLE);
            profile_view2.setVisibility(View.GONE);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        new_pitches.setLayoutManager(linearLayoutManager);

        HomeAdapter messageAdapter = new HomeAdapter(getContext());
        new_pitches.setAdapter(messageAdapter);

        return view;
    }
}