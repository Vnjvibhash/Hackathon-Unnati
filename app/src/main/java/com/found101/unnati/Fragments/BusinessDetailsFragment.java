package com.found101.unnati.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.found101.unnati.R;
import com.found101.unnati.Utils.Session;


public class BusinessDetailsFragment extends Fragment {
View view;
Session session;
Button submit;
LinearLayout investor_kam,user_work;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_business_details, container, false);
        session = new Session(getContext());
        submit = view.findViewById(R.id.submit);
        investor_kam = view.findViewById(R.id.investor_kam);
        user_work = view.findViewById(R.id.user_work);

        if(session.getRole().equals("1")||session.getRole().equals("2")||session.getRole().equals("3")) {
            submit.setText("Start Chat");
            investor_kam.setVisibility(View.VISIBLE);
            user_work.setVisibility(View.GONE);
        }else{
            investor_kam.setVisibility(View.GONE);
            user_work.setVisibility(View.VISIBLE);
        }


        return view;
    }
}