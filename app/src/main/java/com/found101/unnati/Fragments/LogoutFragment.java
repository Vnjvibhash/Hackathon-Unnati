package com.found101.unnati.Fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.found101.unnati.Activities.LoginActivity;
import com.found101.unnati.R;
import com.found101.unnati.Utils.Session;

public class LogoutFragment extends Fragment {
    View view;
    Button logout_yes, logout_no;
    Session session;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.hide();
        view = inflater.inflate(R.layout.fragment_logout, container, false);
        logout_yes = view.findViewById(R.id.logout_yes);
        logout_no = view.findViewById(R.id.logout_no);

        logout_yes.setOnClickListener(v -> {
            ProgressDialog progressDialog = new ProgressDialog(getContext());
            progressDialog.setMessage("Loading...");
            progressDialog.show();
            session = new Session(getContext());

            session.logoutUser();
            Intent redirect = new Intent(getContext(), LoginActivity.class);
            startActivity(redirect);
        });


        logout_no.setOnClickListener(v -> {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.home, new ProfileFragment()).addToBackStack(null)
                    .commit();
        });
        return view;
    }
}