package com.example.profitness;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DietAdapter2 extends RecyclerView.Adapter<DietAdapter2.DietAdapter2ViewHolder> {
    private ArrayList<GainMuscleItems> mMuscleList;

    public static class DietAdapter2ViewHolder extends RecyclerView.ViewHolder{

        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;

        public DietAdapter2ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.foodmenu);
            mTextView1 = itemView.findViewById(R.id.food);
            mTextView2 = itemView.findViewById(R.id.food2);
        }
    }

    public  DietAdapter2(ArrayList<GainMuscleItems> GAINList){
        mMuscleList = GAINList;
    }

    @Override
    public DietAdapter2ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.diet2rv, parent, false);
        DietAdapter2ViewHolder cvh = new DietAdapter2ViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull DietAdapter2ViewHolder holder, int position) {
        GainMuscleItems currentItem = mMuscleList.get(position);

        holder.mImageView.setImageResource(currentItem.getmImageResource());
        holder.mTextView1.setText(currentItem.getMtext1());
        holder.mTextView2.setText(currentItem.getMtext2());
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
