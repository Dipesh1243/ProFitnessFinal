package com.example.profitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

public class Diet extends AppCompatActivity {
    private ArrayList<GainMuscleItems> gmList;
    private RecyclerView mRecyclerView, recyclerView2, recyclerView3;
    private DietAdapter mAdapter;
            private DietAdapter2 adapter2;
            private GainMuscleAdapter adapter3;

    private RecyclerView.LayoutManager mLayoutManager, layoutManager2, layoutManager3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);
        getSupportActionBar().setTitle("Return to Menu");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        recyclerview1();
        recyclerview2();
        recyclerview3();

        EditText editText = findViewById(R.id.searchfood);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }

    public void recyclerview1(){
        gmList = new ArrayList<>();

        gmList.add(new GainMuscleItems(R.drawable.ricechicken, "Rice and Chicken", ""));
        gmList.add(new GainMuscleItems(R.drawable.pastachicken, "Pasta and Chicken", ""));
        gmList.add(new GainMuscleItems(R.drawable.ricepork, "Crispy Pork", ""));
        gmList.add(new GainMuscleItems(R.drawable.salmon, "Salmon & Veg", ""));
        gmList.add(new GainMuscleItems(R.drawable.crabchilli, "Crab & Chilli ", ""));
        gmList.add(new GainMuscleItems(R.drawable.roastchicken, "Roast Chicken", ""));


        mRecyclerView = findViewById(R.id.popular);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mAdapter = new DietAdapter(gmList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }

    public void recyclerview2(){
        gmList = new ArrayList<>();

        gmList.add(new GainMuscleItems(R.drawable.rigatoni, "Rigatoni & Spicy Sausage", ""));
        gmList.add(new GainMuscleItems(R.drawable.mapo, "Ma Po Tofu Noodles", ""));
        gmList.add(new GainMuscleItems(R.drawable.tilapia, "Pan-fried Pilapia", ""));
        gmList.add(new GainMuscleItems(R.drawable.stuffedpepper, "Stuffed Peppers", ""));
        gmList.add(new GainMuscleItems(R.drawable.caprese, "Caprese Zoodles", ""));
        gmList.add(new GainMuscleItems(R.drawable.alfredo, "Skinny Alfredo", ""));


        recyclerView2 = findViewById(R.id.recommended);
        recyclerView2.setHasFixedSize(true);
        layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        adapter2 = new DietAdapter2(gmList);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView2.setAdapter(adapter2);

    }

    public void recyclerview3(){
        gmList = new ArrayList<>();

        gmList.add(new GainMuscleItems(R.drawable.ricechicken, "Rice and Chicken", ""));
        gmList.add(new GainMuscleItems(R.drawable.pastachicken, "Pasta and Chicken", ""));
        gmList.add(new GainMuscleItems(R.drawable.ricepork, "Crispy Pork", ""));
        gmList.add(new GainMuscleItems(R.drawable.salmon, "Salmon & Veg", ""));
        gmList.add(new GainMuscleItems(R.drawable.crabchilli, "Crab & Chilli ", ""));
        gmList.add(new GainMuscleItems(R.drawable.roastchicken, "Roast Chicken", ""));
        gmList.add(new GainMuscleItems(R.drawable.rigatoni, "Rigatoni & Spicy Sausage", ""));
        gmList.add(new GainMuscleItems(R.drawable.mapo, "Ma Po Tofu Noodles", ""));
        gmList.add(new GainMuscleItems(R.drawable.tilapia, "Pan-fried Pilapia", ""));
        gmList.add(new GainMuscleItems(R.drawable.stuffedpepper, "Stuffed Peppers", ""));
        gmList.add(new GainMuscleItems(R.drawable.caprese, "Caprese Zoodles", ""));
        gmList.add(new GainMuscleItems(R.drawable.alfredo, "Skinny Alfredo", ""));


        recyclerView3 = findViewById(R.id.allitems);
        recyclerView3.setHasFixedSize(true);
        layoutManager3 = new LinearLayoutManager(this);
        adapter3 = new GainMuscleAdapter(gmList);
        recyclerView3.setLayoutManager(layoutManager3);
        recyclerView3.setAdapter(adapter3);

    }

    private void filter(String text){
        ArrayList<GainMuscleItems> filteredList = new ArrayList<>();
        for (GainMuscleItems item : gmList){
            if (item.getMtext1().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }

        mAdapter.test(filteredList);

    }

}