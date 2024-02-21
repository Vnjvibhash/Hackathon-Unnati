/*
 *
 *   Created by VnjVibhash on 2/22/24, 1:50 AM
 *   Copyright Ⓒ 2024. All rights reserved Ⓒ 2024 http://vivekajee.in/
 *   Last modified: 2/21/24, 11:30 PM
 *
 *   Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 *   except in compliance with the License. You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENS... Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *    either express or implied. See the License for the specific language governing permissions and
 *    limitations under the License.
 * /
 */

package com.found101.unnati.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.found101.unnati.Adapters.ChatAdapter;
import com.found101.unnati.Models.ChatModel;
import com.found101.unnati.R;
import com.found101.unnati.Utils.Session;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ChatActivity extends AppCompatActivity {

    String currentTime;
    List<ChatModel> messageChatModelList = new ArrayList<>();
    RecyclerView recyclerView;
    ChatAdapter adapter;

    EditText messageET;
    ImageView sendBtn, back, action;
    TextView continue_btn;
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        session = new Session(this);

        continue_btn = findViewById(R.id.continue_btn);
        action = findViewById(R.id.action);
        messageET = findViewById(R.id.messageET);
        sendBtn = (ImageView) findViewById(R.id.sendBtn);
        back = findViewById(R.id.back);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(ChatActivity.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

        ChatModel model1 = new ChatModel(
                "Hello. How are you today?",
                "10:00 PM",
                0
        );
        ChatModel model2 = new ChatModel(
                "Hey! I'm fine. Thanks for asking!",
                "10:00 PM",
                1
        );
        ChatModel model3 = new ChatModel(
                "Sweet! So, what do you wanna do today?",
                "10:00 PM",
                0
        );
        ChatModel model4 = new ChatModel(
                "Nah, I dunno. Play soccer.. or learn more coding perhaps?",
                "10:00 PM",
                1
        );

        if (session.getRole().equals("4")) {
            continue_btn.setVisibility(View.VISIBLE);
        }
        continue_btn.setOnClickListener(v -> {
            Intent intent = new Intent(ChatActivity.this, DetailsPitchActivity.class);
            startActivity(intent);
        });

        messageChatModelList.add(model1);
        messageChatModelList.add(model2);
        messageChatModelList.add(model3);
        messageChatModelList.add(model4);
        messageChatModelList.add(model1);
        messageChatModelList.add(model2);
        messageChatModelList.add(model3);
        messageChatModelList.add(model4);
        messageChatModelList.add(model1);
        messageChatModelList.add(model2);
        messageChatModelList.add(model3);
        messageChatModelList.add(model4);

        recyclerView.smoothScrollToPosition(messageChatModelList.size());
        adapter = new ChatAdapter(messageChatModelList, ChatActivity.this);
        recyclerView.setAdapter(adapter);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = messageET.getText().toString();
                currentTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
                ChatModel model = new ChatModel(
                        msg,
                        currentTime,
                        0
                );
                messageChatModelList.add(model);
                recyclerView.smoothScrollToPosition(messageChatModelList.size());
                adapter.notifyDataSetChanged();
                messageET.setText("");
            }
        });

        back.setOnClickListener(v -> {
            onBackPressed();
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}