package com.example.profitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class QuadricepExercises extends AppCompatActivity {

    CardView cd1, cd2, cd3, cd4, cd5, cd6, cd7, cd8, cd9, cd10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadricep_exercises);
        getSupportActionBar().setTitle("View More Exercises");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cd1 = findViewById(R.id.cd1);
        cd2 = findViewById(R.id.cd2);
        cd3 = findViewById(R.id.cd3);
        cd4 = findViewById(R.id.cd4);
        cd5 = findViewById(R.id.cd5);
        cd6 = findViewById(R.id.cd6);
        cd7 = findViewById(R.id.cd7);
        cd8 = findViewById(R.id.cd8);
        cd9 = findViewById(R.id.cd9);
        cd10 = findViewById(R.id.cd10);

        cd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuadricepExercises.this, WorkoutVideo.class);
                i.putExtra("my_image", R.raw.squat);
                startActivity(i);
            }
        });

        cd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuadricepExercises.this, Webview.class);
                i.putExtra("my_image", "q1");
                startActivity(i);
            }
        });

        cd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuadricepExercises.this, Webview.class);
                i.putExtra("my_image", "q2");
                startActivity(i);
            }
        });

        cd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuadricepExercises.this, Webview.class);
                i.putExtra("my_image", "q3");
                startActivity(i);
            }
        });

        cd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuadricepExercises.this, WorkoutVideo.class);
                i.putExtra("my_image", R.raw.lunges);
                startActivity(i);
            }
        });

        cd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuadricepExercises.this, Webview.class);
                i.putExtra("my_image", "q4");
                startActivity(i);
            }
        });

        cd7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuadricepExercises.this, Webview.class);
                i.putExtra("my_image", "q5");
                startActivity(i);
            }
        });

        cd8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuadricepExercises.this, Webview.class);
                i.putExtra("my_image", "farm");
                startActivity(i);
            }
        });

        cd9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuadricepExercises.this, WorkoutVideo.class);
                i.putExtra("my_image", R.raw.wallsits);
                startActivity(i);
            }
        });

        cd10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuadricepExercises.this, Webview.class);
                i.putExtra("my_image", "q6");
                startActivity(i);
            }
        });
    }
}