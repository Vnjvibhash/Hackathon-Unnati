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
import com.found101.unnati.Adapters.MessageAdapter;
import com.found101.unnati.R;
import com.found101.unnati.Utils.Session;

public class HomeFragment extends Fragment {
    View view;
    Session session;
    RecyclerView pitch_recycler, pitch_recycler2;
    LinearLayout home_view1, home_view2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        home_view1 = view.findViewById(R.id.home_view1);
        home_view2 = view.findViewById(R.id.home_view2);

        pitch_recycler = view.findViewById(R.id.pitch_recycler);
        pitch_recycler2 = view.findViewById(R.id.pitch_recycler2);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext());
        pitch_recycler.setLayoutManager(linearLayoutManager);
        pitch_recycler2.setLayoutManager(linearLayoutManager2);

        HomeAdapter messageAdapter = new HomeAdapter(getContext());
        pitch_recycler.setAdapter(messageAdapter);
        pitch_recycler2.setAdapter(messageAdapter);

        session = new Session(getContext());
        if (session.getRole() == "4") {
            home_view2.setVisibility(View.VISIBLE);
            home_view1.setVisibility(View.GONE);
        } else if (session.getRole() == "3") {
            home_view1.setVisibility(View.VISIBLE);
            home_view2.setVisibility(View.GONE);
        }

        return view;
    }
}