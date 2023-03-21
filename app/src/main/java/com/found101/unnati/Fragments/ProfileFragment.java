package com.found101.unnati.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.found101.unnati.Adapters.HomeAdapter;
import com.found101.unnati.R;
import com.found101.unnati.Utils.Session;

public class ProfileFragment extends Fragment {
    View view;
    LinearLayout profile_view1,profile_view2;
    Session session;
    RecyclerView new_pitches;
    Button setting,logout,setting1,logout1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_profile, container, false);
        profile_view1=view.findViewById(R.id.profile_view1);
        profile_view2=view.findViewById(R.id.profile_view2);
        new_pitches=view.findViewById(R.id.new_pitches);
        setting=view.findViewById(R.id.setting);
        logout=view.findViewById(R.id.logout);
        setting1=view.findViewById(R.id.setting1);
        logout1=view.findViewById(R.id.logout1);
        session= new Session(getContext());
        if (session.getRole().equals("4")) {
            profile_view1.setVisibility(View.GONE);
            profile_view2.setVisibility(View.VISIBLE);
        } else {
            profile_view1.setVisibility(View.VISIBLE);
            profile_view2.setVisibility(View.GONE);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        new_pitches.setLayoutManager(linearLayoutManager);

        HomeAdapter messageAdapter = new HomeAdapter(getContext());
        new_pitches.setAdapter(messageAdapter);

        logout.setOnClickListener(v->{
            LogoutFragment logoutFragment = new LogoutFragment();
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, logoutFragment)
                    .addToBackStack(null)
                    .commit();
        });
        logout1.setOnClickListener(v->{
            LogoutFragment logoutFragment = new LogoutFragment();
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, logoutFragment)
                    .addToBackStack(null)
                    .commit();
        });

        return view;
    }
}