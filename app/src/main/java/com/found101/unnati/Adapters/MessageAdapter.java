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
import com.found101.unnati.R;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyViewHolder>{
    Context context;

    public MessageAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MessageAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item, parent, false);
        return new MessageAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapter.MyViewHolder holder, int position) {
        holder.chat.setOnClickListener(v->{
            Intent intent = new Intent(context, ChatActivity.class);
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
