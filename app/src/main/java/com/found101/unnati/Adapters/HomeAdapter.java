package com.found101.unnati.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.found101.unnati.Fragments.BusinessDetailsFragment;
import com.found101.unnati.Fragments.ExistingBusinessFragment;
import com.found101.unnati.R;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>{
    Context context;

    public HomeAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public HomeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.pitch_item, parent, false);
        return new HomeAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.MyViewHolder holder, int position) {
holder.pitch_id.setOnClickListener(v->{
    BusinessDetailsFragment serviceInnerListFragment = new BusinessDetailsFragment();
    FragmentManager fragmentManager = ((FragmentActivity)context).getSupportFragmentManager();
    FragmentTransaction ft = fragmentManager.beginTransaction();
    ft.replace(R.id.container, serviceInnerListFragment).commit();
});
    }

    @Override
    public int getItemCount() {
        return 9;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        CardView pitch_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pitch_id=itemView.findViewById(R.id.pitch_id);
        }
    }
}
