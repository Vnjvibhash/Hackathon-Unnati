/*
 *
 *   Created by VnjVibhash on 2/22/24, 1:50 AM
 *   Copyright Ⓒ 2024. All rights reserved Ⓒ 2024 http://vivekajee.in/
 *   Last modified: 2/21/24, 10:44 AM
 *
 *   Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 *   except in compliance with the License. You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENS... Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *    either express or implied. See the License for the specific language governing permissions and
 *    limitations under the License.
 * /
 */

package com.found101.unnati.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.found101.unnati.Adapters.HomeAdapter;
import com.found101.unnati.Adapters.MessageAdapter;
import com.found101.unnati.R;
import com.found101.unnati.Utils.Session;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeFragment extends Fragment {
    View view;
    Session session;
    RecyclerView pitch_recycler, pitch_recycler2;
    LinearLayout home_view1, home_view2;
    FloatingActionButton floatingActionButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        home_view1 = view.findViewById(R.id.home_view1);
        home_view2 = view.findViewById(R.id.home_view2);
        floatingActionButton = view.findViewById(R.id.floatingActionButton);

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
        if (session.getRole().equals("4")) {
            home_view2.setVisibility(View.VISIBLE);
            home_view1.setVisibility(View.GONE);
        } else {
            home_view1.setVisibility(View.VISIBLE);
            home_view2.setVisibility(View.GONE);
        }
        floatingActionButton.setOnClickListener(v->{
            LayoutInflater inflater1 = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater1.inflate(R.layout.business_model, null);

            PopupWindow popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
            popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

            Button new_business = view.findViewById(R.id.new_business);
            Button old_business = view.findViewById(R.id.old_business);

            new_business.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWindow.dismiss();
                    MessageFragment messageFragment = new MessageFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("Title","Select Your Mentor");
                    messageFragment.setArguments(bundle);
                    getFragmentManager().beginTransaction()
                            .replace(R.id.container, messageFragment)
                            .addToBackStack(null)
                            .commit();
                }
            });
            old_business.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWindow.dismiss();
                    FinancialFragment messageFragment = new FinancialFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("Title","Select Your FA");
                    messageFragment.setArguments(bundle);
                    getFragmentManager().beginTransaction()
                            .replace(R.id.container, messageFragment)
                            .addToBackStack(null)
                            .commit();
                }
            });
        });


        return view;
    }
}