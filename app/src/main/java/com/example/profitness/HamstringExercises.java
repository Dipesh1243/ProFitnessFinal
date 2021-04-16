package com.example.profitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HamstringExercises extends AppCompatActivity {

    CardView cd1, cd2,cd3,cd4,cd5,cd6,cd7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hamstring_exercises);
        getSupportActionBar().setTitle("View More Exercises");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cd1 =findViewById(R.id.cd1);
        cd2 =findViewById(R.id.cd2);
        cd3 =findViewById(R.id.cd3);
        cd4 =findViewById(R.id.cd4);
        cd5 =findViewById(R.id.cd5);
        cd6 =findViewById(R.id.cd6);
        cd7 =findViewById(R.id.cd7);

        cd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HamstringExercises.this, Webview.class);
                i.putExtra("my_image", "glutebridge");
                startActivity(i);
            }
        });

        cd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HamstringExercises.this, Webview.class);
                i.putExtra("my_image", "deadlift");
                startActivity(i);
            }
        });

        cd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HamstringExercises.this, WorkoutVideo.class);
                i.putExtra("my_image", R.raw.singlelegdeadlift);
                startActivity(i);
            }
        });
        cd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HamstringExercises.this, Webview.class);
                i.putExtra("my_image", "hipthrust");
                startActivity(i);
            }
        });

        cd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HamstringExercises.this, Webview.class);
                i.putExtra("my_image", "kettle");
                startActivity(i);
            }
        });

        cd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HamstringExercises.this, Webview.class);
                i.putExtra("my_image", "legcurl");
                startActivity(i);
            }
        });

        cd7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HamstringExercises.this, WorkoutVideo.class);
                i.putExtra("my_image", R.raw.squat);
                startActivity(i);
            }
        });
    }
}