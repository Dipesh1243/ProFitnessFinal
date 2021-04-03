package com.example.profitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.MediaController;
import android.widget.VideoView;

import java.net.URI;

public class CalvesExercises extends AppCompatActivity {

    CardView card1,card2,card3,card4,card5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calves_exercises);
        getSupportActionBar().setTitle("View More Exercises");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        card1 = findViewById(R.id.cd1);
        card2 = findViewById(R.id.cd2);
        card3 = findViewById(R.id.cd3);
        card4 = findViewById(R.id.cd4);
        card5 = findViewById(R.id.cd5);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


}