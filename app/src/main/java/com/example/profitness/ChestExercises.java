package com.example.profitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChestExercises extends AppCompatActivity {

    CardView cd1, cd2,cd3,cd4,cd5,cd6,cd7,cd8,cd9,cd10,cd11,cd12,cd13,cd14,cd15,cd16,cd17,cd18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_exercises);
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
        cd11 =findViewById(R.id.cd11);
        cd12 =findViewById(R.id.cd12);
        cd13 =findViewById(R.id.cd13);
        cd14 =findViewById(R.id.cd14);
        cd15 =findViewById(R.id.cd15);
        cd16 =findViewById(R.id.cd16);
        cd17 =findViewById(R.id.cd17);
        cd18 =findViewById(R.id.cd18);


        cd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChestExercises.this, WorkoutVideo.class);
                i.putExtra("my_image", R.raw.pressup);
                startActivity(i);
            }
        });

        cd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChestExercises.this, Webview.class);
                i.putExtra("my_image", "barbelbench");
                startActivity(i);
            }
        });

        cd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChestExercises.this, Webview.class);
                i.putExtra("my_image", "dumbellbench");
                startActivity(i);
            }
        });

        cd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChestExercises.this, Webview.class);
                i.putExtra("my_image", "inclinebarbell");
                startActivity(i);
            }
        });

        cd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChestExercises.this, Webview.class);
                i.putExtra("my_image", "inclinedumbbarbell");
                startActivity(i);
            }
        });

        cd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChestExercises.this, Webview.class);
                i.putExtra("my_image", "decline");
                startActivity(i);
            }
        });

        cd7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChestExercises.this, Webview.class);
                i.putExtra("my_image", "decline2");
                startActivity(i);
            }
        });

        cd8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChestExercises.this, Webview.class);
                i.putExtra("my_image", "chestpress");
                startActivity(i);
            }
        });

        cd9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChestExercises.this, Webview.class);
                i.putExtra("my_image", "weightpush");
                startActivity(i);
            }
        });

        cd10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChestExercises.this, Webview.class);
                i.putExtra("my_image", "weightdip");
                startActivity(i);
            }
        });

        cd11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChestExercises.this, Webview.class);
                i.putExtra("my_image", "closegrip");
                startActivity(i);
            }
        });

        cd12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChestExercises.this, Webview.class);
                i.putExtra("my_image", "pullover");
                startActivity(i);
            }
        });

        cd13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChestExercises.this, Webview.class);
                i.putExtra("my_image", "smithbench");
                startActivity(i);
            }
        });

        cd14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChestExercises.this, Webview.class);
                i.putExtra("my_image", "inclinedfly");
                startActivity(i);
            }
        });

        cd15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChestExercises.this, Webview.class);
                i.putExtra("my_image", "one");
                startActivity(i);
            }
        });

        cd16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChestExercises.this, Webview.class);
                i.putExtra("my_image", "two");
                startActivity(i);
            }
        });

        cd17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChestExercises.this, Webview.class);
                i.putExtra("my_image", "three");
                startActivity(i);
            }

        });

        cd18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChestExercises.this, Webview.class);
                i.putExtra("my_image", "one");
                startActivity(i);
            }
        });



    }


}