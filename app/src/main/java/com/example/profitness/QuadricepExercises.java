package com.example.profitness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class QuadricepExercises extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadricep_exercises);
        getSupportActionBar().setTitle("View More Exercises");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}