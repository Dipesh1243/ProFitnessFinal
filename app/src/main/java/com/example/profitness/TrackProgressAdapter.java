package com.example.profitness;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TrackProgressAdapter extends RecyclerView.Adapter<TrackProgressAdapter.TrackProgressViewHolder> {
    private ArrayList<String> mMuscleList;
    public OnItemClickListener mListener;

    public interface OnItemClickListener {
        void OnItemClick(int position);

        void OnDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


    public static class TrackProgressViewHolder extends RecyclerView.ViewHolder {


        public TextView mTextView1;
        public ImageView imageView;


        public TrackProgressViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);

            mTextView1 = itemView.findViewById(R.id.test1);
            imageView = itemView.findViewById(R.id.delete);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.OnItemClick(position);
                        }
                    }
                }
            });

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.OnDeleteClick(position);
                        }
                    }
                }
            });

        }
    }

    public TrackProgressAdapter(ArrayList<String> GAINList) {

        mMuscleList = GAINList;
    }

    @Override
    public TrackProgressViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.trackprogressrv, parent, false);
        TrackProgressViewHolder cvh = new TrackProgressViewHolder(v, mListener);
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
