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