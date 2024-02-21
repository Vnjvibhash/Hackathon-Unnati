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

package com.found101.unnati.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.found101.unnati.Activities.ChatActivity;
import com.found101.unnati.Activities.FAChatActivity;
import com.found101.unnati.R;

public class FinancialAdapter extends RecyclerView.Adapter<FinancialAdapter.MyViewHolder>{
    Context context;

    public FinancialAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public FinancialAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item, parent, false);
        return new FinancialAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FinancialAdapter.MyViewHolder holder, int position) {
        holder.chat.setOnClickListener(v->{
            Intent intent = new Intent(context, FAChatActivity.class);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        CardView chat;
        TextView user_name,user_message,message_time;
        ImageView message_status;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            chat = itemView.findViewById(R.id.chat);
            user_name = itemView.findViewById(R.id.user_name);
            user_message = itemView.findViewById(R.id.user_message);
            message_time = itemView.findViewById(R.id.message_time);
            message_status = itemView.findViewById(R.id.message_status);
        }
    }
}
