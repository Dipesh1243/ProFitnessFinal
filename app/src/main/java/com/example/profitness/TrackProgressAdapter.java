package com.example.profitness;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TrackProgressAdapter extends RecyclerView.Adapter<TrackProgressAdapter.TrackProgressViewHolder> {
    private ArrayList<String> mMuscleList;





    public static class TrackProgressViewHolder extends RecyclerView.ViewHolder{


        public TextView mTextView1;


        public TrackProgressViewHolder(@NonNull View itemView) {
            super(itemView);

            mTextView1 = itemView.findViewById(R.id.test1);

        }
    }

    public  TrackProgressAdapter(ArrayList<String> GAINList){

        mMuscleList = GAINList;
    }

    @Override
    public TrackProgressViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.trackprogressrv, parent, false);
        TrackProgressViewHolder cvh = new TrackProgressViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull TrackProgressViewHolder holder, int position) {
        String currentItem = mMuscleList.get(position);
        holder.mTextView1.setText(currentItem);
    }

    @Override
    public int getItemCount() {
        return mMuscleList.size();
    }
}
