package com.example.profitness;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DietAdapter extends RecyclerView.Adapter<DietAdapter.DietAdapterViewHolder> {
    private ArrayList<GainMuscleItems> mMuscleList;

    public static class DietAdapterViewHolder extends RecyclerView.ViewHolder{

        public ImageView mImageView;
        public TextView mTextView1;


        public DietAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.foodmenu);
            mTextView1 = itemView.findViewById(R.id.food);

        }
    }

    public  DietAdapter(ArrayList<GainMuscleItems> GAINList){
        mMuscleList = GAINList;
    }

    @Override
    public DietAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dietrv, parent, false);
        DietAdapterViewHolder cvh = new DietAdapterViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull DietAdapterViewHolder holder, int position) {
        GainMuscleItems currentItem = mMuscleList.get(position);

        holder.mImageView.setImageResource(currentItem.getmImageResource());
        holder.mTextView1.setText(currentItem.getMtext1());
    }

    @Override
    public int getItemCount() {
        return mMuscleList.size();
    }

    public void test(ArrayList<GainMuscleItems> filteredList) {
        mMuscleList = filteredList;
        notifyDataSetChanged();
    }
}
