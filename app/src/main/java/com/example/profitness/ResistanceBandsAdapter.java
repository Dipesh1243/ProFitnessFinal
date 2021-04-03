package com.example.profitness;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ResistanceBandsAdapter extends RecyclerView.Adapter<ResistanceBandsAdapter.ResistanceBandsViewHolder> {
    private ArrayList<ResistanceBandsItems> mRBlist;

    public static class ResistanceBandsViewHolder extends RecyclerView.ViewHolder{

        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;

        public ResistanceBandsViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.test);
            mTextView1 = itemView.findViewById(R.id.test1);
            mTextView2 = itemView.findViewById(R.id.test3);
        }
    }

    public  ResistanceBandsAdapter(ArrayList<ResistanceBandsItems> rbList){
        mRBlist = rbList;
    }

    @Override
    public ResistanceBandsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardio_rv, parent, false);
        ResistanceBandsViewHolder cvh = new ResistanceBandsViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ResistanceBandsViewHolder holder, int position) {
        ResistanceBandsItems currentItem = mRBlist.get(position);

        holder.mImageView.setImageResource(currentItem.getmImageResource());
        holder.mTextView1.setText(currentItem.getMtext1());
        holder.mTextView2.setText(currentItem.getMtext2());
    }

    @Override
    public int getItemCount() {
        return mRBlist.size();
    }

    public void filterstrectch(ArrayList<ResistanceBandsItems> filteredList) {
        mRBlist = filteredList;
        notifyDataSetChanged();
    }
}
