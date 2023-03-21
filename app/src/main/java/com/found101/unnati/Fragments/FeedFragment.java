package com.found101.unnati.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.found101.unnati.Adapters.HomeAdapter;
import com.found101.unnati.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class FeedFragment extends Fragment {
    View view;

    RecyclerView feed_recycler;
    Button govt,post,learn;
    ImageView pitch_img2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_feed, container, false);

        pitch_img2=view.findViewById(R.id.pitch_img2);
        post=view.findViewById(R.id.post);
        govt=view.findViewById(R.id.govt);
        learn=view.findViewById(R.id.learn);
        post.setOnClickListener(v->{
            Picasso.get().load(R.drawable.img_3).into(pitch_img2, new Callback() {
                @Override
                public void onSuccess() {

                }

                @Override
                public void onError(Exception e) {

                }
            });;
        });
        govt.setOnClickListener(v->{
            Picasso.get().load(R.drawable.img_1).into(pitch_img2, new Callback() {
                @Override
                public void onSuccess() {

                }

                @Override
                public void onError(Exception e) {

                }
            });;
        });
        learn.setOnClickListener(v->{
            Picasso.get().load(R.drawable.img_2).into(pitch_img2, new Callback() {
                @Override
                public void onSuccess() {

                }

                @Override
                public void onError(Exception e) {

                }
            });;
        });
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        feed_recycler.setLayoutManager(linearLayoutManager);
//
//        HomeAdapter messageAdapter=new HomeAdapter(getContext());
//        feed_recycler.setAdapter(messageAdapter);

        return view;
    }
}