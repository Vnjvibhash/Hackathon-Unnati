package com.found101.unnati.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.found101.unnati.Activities.ChatActivity;
import com.found101.unnati.R;
import com.found101.unnati.Utils.Session;


public class BusinessDetailsFragment extends Fragment {
View view;
Session session;
Button submit, chat;
LinearLayout investor_kam,user_work;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_business_details, container, false);
        session = new Session(getContext());
        submit = view.findViewById(R.id.submit);
        chat = view.findViewById(R.id.chat);
        investor_kam = view.findViewById(R.id.investor_kam);

        chat.setOnClickListener(v->{
            Intent intent = new Intent(getContext(), ChatActivity.class);
            startActivity(intent);
        });

        if(session.getRole().equals("4"))
            chat.setVisibility(View.GONE);

        return view;
    }
}