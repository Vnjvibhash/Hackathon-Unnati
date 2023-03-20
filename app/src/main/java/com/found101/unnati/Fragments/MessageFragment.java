package com.found101.unnati.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.found101.unnati.Adapters.MessageAdapter;
import com.found101.unnati.R;

public class MessageFragment extends Fragment {
    View view;
    RecyclerView message_recycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_message, container, false);

        message_recycler=view.findViewById(R.id.message_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        message_recycler.setLayoutManager(linearLayoutManager);

        MessageAdapter messageAdapter=new MessageAdapter(getContext());
        message_recycler.setAdapter(messageAdapter);

        return view;
    }
}