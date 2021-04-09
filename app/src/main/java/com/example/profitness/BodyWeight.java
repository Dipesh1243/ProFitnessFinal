package com.example.profitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BodyWeight extends AppCompatActivity {

    CardView cd1, cd2,cd3,cd4,cd5,cd6,cd7,cd8,cd9,cd10,cd11,cd12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_weight);
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

        cd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BodyWeight.this, WorkoutVideo.class);
                i.putExtra("my_image", R.raw.pressup);
                startActivity(i);
            }
        });

        cd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BodyWeight.this, WorkoutVideo.class);
                i.putExtra("my_image", R.raw.situps);
                startActivity(i);
            }
        });

        cd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BodyWeight.this, WorkoutVideo.class);
               i.putExtra("my_image", R.raw.lunges);
                startActivity(i);
            }
        });

        cd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BodyWeight.this, WorkoutVideo.class);
                i.putExtra("my_image", R.raw.squat);
                startActivity(i);
            }
        });

        cd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BodyWeight.this, WorkoutVideo.class);
                i.putExtra("my_image", R.raw.burpee);
                startActivity(i);
            }
        });

        cd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BodyWeight.this, WorkoutVideo.class);
                i.putExtra("my_image", R.raw.tuckjump);
                startActivity(i);
            }
        });

        cd7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BodyWeight.this, WorkoutVideo.class);
                i.putExtra("my_image", R.raw.mountainclimbers);
                startActivity(i);
            }
        });

//        cd8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(BodyWeight.this, WorkoutVideo.class);
//                i.putExtra("my_image", R.raw.mountainclimbers);
//                startActivity(i);
//            }
//        });


        cd9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BodyWeight.this, WorkoutVideo.class);
                i.putExtra("my_image", R.raw.singlelegdeadlift);
                startActivity(i);
            }
        });

        cd10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BodyWeight.this, WorkoutVideo.class);
                i.putExtra("my_image", R.raw.calfraises);
                startActivity(i);
            }
        });

        cd11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BodyWeight.this, WorkoutVideo.class);
                i.putExtra("my_image", R.raw.superman);
                startActivity(i);
            }
        });

        cd12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BodyWeight.this, WorkoutVideo.class);
                i.putExtra("my_image", R.raw.tricepdips);
                startActivity(i);
            }
        });

    }
}