package com.found101.unnati.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.found101.unnati.R;
import com.found101.unnati.Utils.Session;


public class BusinessDetailsFragment extends Fragment {
View view;
Session session;
Button submit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_business_details, container, false);
        session = new Session(getContext());
        submit = view.findViewById(R.id.submit);

        if(session.getRole().equals("1")||session.getRole().equals("2"))
            submit.setText("Start Chat");


        return view;
    }
}