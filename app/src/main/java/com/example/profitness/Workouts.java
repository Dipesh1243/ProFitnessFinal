package com.example.profitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Workouts extends AppCompatActivity {

    TextView w1,w2,w3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouts);
        getSupportActionBar().setTitle("Return to Menu");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        w1 = findViewById(R.id.gainmuscle);
        w2 = findViewById(R.id.loseweight);
        w3 = findViewById(R.id.maintainweight);

        w1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i1 = new Intent(Workouts.this, GainMuscle.class);
            startActivity(i1);
            }
        });

        w2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(Workouts.this, LoseWeight.class);
                startActivity(i2);
            }
        });

        w3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(Workouts.this, MaintainWeight.class);
                startActivity(i3);
            }
        });

    }
}