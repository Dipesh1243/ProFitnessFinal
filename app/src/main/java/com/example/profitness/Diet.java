package com.example.profitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Diet extends AppCompatActivity {
    private ArrayList<GainMuscleItems> gmList;
    private RecyclerView mRecyclerView, recyclerView3;
    private DietAdapter mAdapter;

            private GainMuscleAdapter adapter3;

    private RecyclerView.LayoutManager mLayoutManager, layoutManager2, layoutManager3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);
        getSupportActionBar().setTitle("Return to Menu");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        recyclerview1();

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
        gmList.add(new GainMuscleItems(R.drawable.crabchilli, "Crab & Chilli", ""));
        gmList.add(new GainMuscleItems(R.drawable.roastchicken, "Roast Chicken", ""));


        mRecyclerView = findViewById(R.id.popular);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mAdapter = new DietAdapter(gmList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new DietAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                GainMuscleItems fooditems1 = gmList.get(position);

                if (fooditems1.getMtext1().contains("Rice and Chicken")) {
                    Intent i = new Intent(Diet.this, FoodIngredients.class);
                    i.putExtra("my_image", R.drawable.food1);
                    startActivity(i);
                }
                if (fooditems1.getMtext1().contains("Pasta and Chicken")) {

                    Intent i = new Intent(Diet.this, FoodIngredients.class);
                    i.putExtra("my_image", R.drawable.food2);
                    startActivity(i);
                }

                if (fooditems1.getMtext1().contains("Crispy Pork")) {

                    Intent i = new Intent(Diet.this, FoodIngredients.class);
                    i.putExtra("my_image", R.drawable.food3);
                    startActivity(i);

                }

                if (fooditems1.getMtext1().contains("Salmon & Veg")) {

                    Intent i = new Intent(Diet.this, FoodIngredients.class);
                    i.putExtra("my_image", R.drawable.food4);
                    startActivity(i);

                }

                if (fooditems1.getMtext1().contains("Crab & Chilli")) {

                    Intent i = new Intent(Diet.this, FoodIngredients.class);
                    i.putExtra("my_image", R.drawable.food5);
                    startActivity(i);

                }

                if (fooditems1.getMtext1().contains("Roast Chicken")) {

                    Intent i = new Intent(Diet.this, FoodIngredients.class);
                    i.putExtra("my_image", R.drawable.food6);
                    startActivity(i);

                }
            }
        });

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

        adapter3.setOnItemClickListener(new GainMuscleAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                GainMuscleItems fooditems2 = gmList.get(position);

                if (fooditems2.getMtext1().contains("Rice and Chicken")) {
                    Intent i = new Intent(Diet.this, FoodIngredients.class);
                    i.putExtra("my_image", R.drawable.food1);
                    startActivity(i);
                }
                if (fooditems2.getMtext1().contains("Pasta and Chicken")) {

                    Intent i = new Intent(Diet.this, FoodIngredients.class);
                    i.putExtra("my_image", R.drawable.food2);
                    startActivity(i);
                }

                if (fooditems2.getMtext1().contains("Crispy Pork")) {

                    Intent i = new Intent(Diet.this, FoodIngredients.class);
                    i.putExtra("my_image", R.drawable.food3);
                    startActivity(i);

                }

                if (fooditems2.getMtext1().contains("Salmon & Veg")) {

                    Intent i = new Intent(Diet.this, FoodIngredients.class);
                    i.putExtra("my_image", R.drawable.food4);
                    startActivity(i);

                }

                if (fooditems2.getMtext1().contains("Crab & Chilli")) {

                    Intent i = new Intent(Diet.this, FoodIngredients.class);
                    i.putExtra("my_image", R.drawable.food5);
                    startActivity(i);

                }

                if (fooditems2.getMtext1().contains("Roast Chicken")) {

                    Intent i = new Intent(Diet.this, FoodIngredients.class);
                    i.putExtra("my_image", R.drawable.food6);
                    startActivity(i);

                }

                if (fooditems2.getMtext1().contains("Rigatoni & Spicy Sausage")) {
                    Intent i = new Intent(Diet.this, FoodIngredients.class);
                    i.putExtra("my_image", R.drawable.food7);
                    startActivity(i);

                }

                if (fooditems2.getMtext1().contains("Ma Po Tofu Noodles")) {
                    Intent i = new Intent(Diet.this, FoodIngredients.class);
                    i.putExtra("my_image", R.drawable.food8);
                    startActivity(i);
                }

                if (fooditems2.getMtext1().contains("Pan-fried Pilapia")) {
                    Intent i = new Intent(Diet.this, FoodIngredients.class);
                    i.putExtra("my_image", R.drawable.food9);
                    startActivity(i);
                }

                if (fooditems2.getMtext1().contains("Stuffed Peppers")) {
                    Intent i = new Intent(Diet.this, FoodIngredients.class);
                    i.putExtra("my_image", R.drawable.food10);
                    startActivity(i);
                }

                if (fooditems2.getMtext1().contains("Caprese Zoodles")) {
                    Intent i = new Intent(Diet.this, FoodIngredients.class);
                    i.putExtra("my_image", R.drawable.food11);
                    startActivity(i);
                }

                if (fooditems2.getMtext1().contains("Skinny Alfredo")) {
                    Intent i = new Intent(Diet.this, FoodIngredients.class);
                    i.putExtra("my_image", R.drawable.food12);
                    startActivity(i);
                }
            }
        });

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