package com.example.profitness;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CardioAdapter extends RecyclerView.Adapter<CardioAdapter.CardioViewHolder> {
    private ArrayList<CardioItems> mCardioList;
    public OnItemClickListener mListener;

    public interface OnItemClickListener {
        void OnItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public static class CardioViewHolder extends RecyclerView.ViewHolder{

        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;

        public CardioViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.test);
            mTextView1 = itemView.findViewById(R.id.test1);
            mTextView2 = itemView.findViewById(R.id.test3);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.OnItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public  CardioAdapter(ArrayList<CardioItems> cardioList){
        mCardioList = cardioList;
    }

    @Override
    public CardioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardio_rv, parent, false);
        CardioViewHolder cvh = new CardioViewHolder(v, mListener);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull CardioViewHolder holder, int position) {
    CardioItems currentItem = mCardioList.get(position);

    holder.mImageView.setImageResource(currentItem.getmImageResource());
    holder.mTextView1.setText(currentItem.getMtext1());
        holder.mTextView2.setText(currentItem.getMtext2());
    }

    @Override
    public int getItemCount() {
        return mCardioList.size();
    }

    public void test(ArrayList<CardioItems> filteredList) {
        mCardioList = filteredList;
        notifyDataSetChanged();
    }
}
