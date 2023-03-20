package com.found101.unnati.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.found101.unnati.R;
import com.squareup.picasso.Picasso;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.MyViewHolder>{
    Context context;

    public FeedAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public FeedAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.pitch_item, parent, false);
        return new FeedAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedAdapter.MyViewHolder holder, int position) {
        Picasso.get().load(R.drawable.startup3).into(holder.pitch_img);
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView pitch_img;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pitch_img=itemView.findViewById(R.id.pitch_img);
        }
    }
}
