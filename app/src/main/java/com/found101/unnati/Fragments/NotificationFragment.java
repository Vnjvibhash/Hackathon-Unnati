package com.found101.unnati.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.found101.unnati.Adapters.HomeAdapter;
import com.found101.unnati.Adapters.NotificationAdapter;
import com.found101.unnati.R;

public class NotificationFragment extends Fragment {
    View view;

    RecyclerView notification_recycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_notification, container, false);

        notification_recycler=view.findViewById(R.id.notification_recycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        notification_recycler.setLayoutManager(linearLayoutManager);

        NotificationAdapter messageAdapter=new NotificationAdapter(getContext());
        notification_recycler.setAdapter(messageAdapter);

        return view;
    }
}