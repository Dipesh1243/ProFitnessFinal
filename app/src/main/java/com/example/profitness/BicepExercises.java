package com.example.profitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BicepExercises extends AppCompatActivity {

    CardView cd1, cd2,cd3,cd4,cd5,cd6,cd7,cd8,cd9,cd10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bicep_exercises);
        getSupportActionBar().setTitle("View More Exercises");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cd1 =findViewById(R.id.cd1);
        cd2 =findViewById(R.id.cd2);
        cd3 =findViewById(R.id.cd3);
        cd4 =findViewById(R.id.cd4);
        cd5 =findViewById(R.id.cd5);
        cd6 =findViewById(R.id.cd6);
        cd7 =findViewById(R.id.cd7);
        cd8 =findViewById(R.id.cd8);
        cd9 =findViewById(R.id.cd9);
        cd10 =findViewById(R.id.cd10);

        cd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BicepExercises.this, Webview.class);
                i.putExtra("my_image", "1");
                startActivity(i);
            }
        });

        cd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BicepExercises.this, Webview.class);
                i.putExtra("my_image", "2");
                startActivity(i);
            }
        });

        cd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BicepExercises.this, Webview.class);
                i.putExtra("my_image", "3");
                startActivity(i);
            }
        });

        cd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BicepExercises.this, Webview.class);
                i.putExtra("my_image", "4");
                startActivity(i);
            }
        });

        cd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BicepExercises.this, Webview.class);
                i.putExtra("my_image", "5");
                startActivity(i);
            }
        });

        cd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BicepExercises.this, Webview.class);
                i.putExtra("my_image", "6");
                startActivity(i);
            }
        });

        cd7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BicepExercises.this, Webview.class);
                i.putExtra("my_image", "7");
                startActivity(i);
            }
        });

        cd8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BicepExercises.this, Webview.class);
                i.putExtra("my_image", "8");
                startActivity(i);
            }
        });

        cd9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BicepExercises.this, Webview.class);
                i.putExtra("my_image", "9");
                startActivity(i);
            }
        });

        cd10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BicepExercises.this, Webview.class);
                i.putExtra("my_image", "10");
                startActivity(i);
            }
        });


    }
}