package com.example.profitness;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StretchesAdapter extends RecyclerView.Adapter<StretchesAdapter.StretchesViewHolder> {
    private ArrayList<StretchesItems> mStretchesList;

    public static class StretchesViewHolder extends RecyclerView.ViewHolder{

        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;

        public StretchesViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.test);
            mTextView1 = itemView.findViewById(R.id.test1);
            mTextView2 = itemView.findViewById(R.id.test3);
        }
    }

    public  StretchesAdapter(ArrayList<StretchesItems> stretchesList){
        mStretchesList = stretchesList;
    }

    @Override
    public StretchesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardio_rv, parent, false);
        StretchesViewHolder cvh = new StretchesViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull StretchesViewHolder holder, int position) {
        StretchesItems currentItem = mStretchesList.get(position);

        holder.mImageView.setImageResource(currentItem.getmImageResource());
        holder.mTextView1.setText(currentItem.getMtext1());
        holder.mTextView2.setText(currentItem.getMtext2());
    }

    @Override
    public int getItemCount() {
        return mStretchesList.size();
    }

    public void filterstrectch(ArrayList<StretchesItems> filteredList) {
        mStretchesList = filteredList;
        notifyDataSetChanged();
    }
}
