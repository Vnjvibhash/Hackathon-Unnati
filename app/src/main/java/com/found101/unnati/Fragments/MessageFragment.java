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
import android.widget.TextView;

import com.found101.unnati.Adapters.MessageAdapter;
import com.found101.unnati.R;
import com.found101.unnati.Utils.Session;

public class MessageFragment extends Fragment {
    View view;
    RecyclerView message_recycler;
    TextView title;
    Session session;
    String head;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_message, container, false);
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

        MessageAdapter messageAdapter = new MessageAdapter(getContext());
        message_recycler.setAdapter(messageAdapter);

        return view;
    }
}