package com.found101.unnati.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.found101.unnati.Adapters.FinancialAdapter;
import com.found101.unnati.Adapters.MessageAdapter;
import com.found101.unnati.R;
import com.found101.unnati.Utils.Session;

public class FinancialFragment extends Fragment {
    View view;
    RecyclerView message_recycler;
    TextView title;
    Session session;
    String head;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_financial, container, false);
        session = new Session(getContext());
        if (!session.getRole().equals("4"))
            head = "All Messages";
        else
            head = getArguments().getString("Title");

        message_recycler = view.findViewById(R.id.message_list);
        title = view.findViewById(R.id.title);
        title.setText(head);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        message_recycler.setLayoutManager(linearLayoutManager);

        FinancialAdapter messageAdapter = new FinancialAdapter(getContext());
        message_recycler.setAdapter(messageAdapter);

        return view;
    }
}