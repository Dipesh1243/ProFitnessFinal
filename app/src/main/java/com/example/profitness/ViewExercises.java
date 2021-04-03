package com.example.profitness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class ViewExercises extends AppCompatActivity {

    TextView exc1,exc2,exc3,exc4,exc5,exc6,exc7,exc8,exc9,exc10,exc11,exc12,exc13,exc14,exc15,exc16;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_exercises);
        getSupportActionBar().setTitle("Return to Menu");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        exc1 = findViewById(R.id.exercise1);
        exc2 = findViewById(R.id.exercise2);
        exc3 = findViewById(R.id.exercise3);
        exc4 = findViewById(R.id.exercise4);
        exc5 = findViewById(R.id.exercise5);
        exc6 = findViewById(R.id.exercise6);
        exc7 = findViewById(R.id.exercise7);
        exc8 = findViewById(R.id.exercise8);
        exc9 = findViewById(R.id.exercise9);
        exc10 = findViewById(R.id.exercise10);
        exc11 = findViewById(R.id.exercise11);
        exc12 = findViewById(R.id.exercise12);
        exc13 = findViewById(R.id.exercise13);
        exc14 = findViewById(R.id.exercise14);
        exc15 = findViewById(R.id.exercise15);
        exc16 = findViewById(R.id.exercise16);

        exc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e1 = new Intent(ViewExercises.this,Cardio.class);
                startActivity(e1);
            }
        });

        exc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e2 = new Intent(ViewExercises.this,Stretches.class);
                startActivity(e2);
            }
        });

        exc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e3 = new Intent(ViewExercises.this,ResistanceBands.class);
                startActivity(e3);
            }
        });

        exc4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e4 = new Intent(ViewExercises.this,BodyWeight.class);
                startActivity(e4);
            }
        });

        exc5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e5 = new Intent(ViewExercises.this,HIT.class);
                startActivity(e5);
            }
        });

        exc6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e6 = new Intent(ViewExercises.this,ChestExercises.class);
                startActivity(e6);
            }
        });

        exc7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e7 = new Intent(ViewExercises.this,AbsExercises.class);
                startActivity(e7);
            }
        });

        exc8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e8 = new Intent(ViewExercises.this,BicepExercises.class);
                startActivity(e8);
            }
        });

        exc9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e9 = new Intent(ViewExercises.this,TricepExercises.class);
                startActivity(e9);
            }
        });

        exc10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e10 = new Intent(ViewExercises.this,ShouldersExercises.class);
                startActivity(e10);
            }
        });

        exc11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e11 = new Intent(ViewExercises.this,HamstringExercises.class);
                startActivity(e11);
            }
        });

        exc12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e12 = new Intent(ViewExercises.this,QuadricepExercises.class);
                startActivity(e12);
            }
        });

        exc13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e13 = new Intent(ViewExercises.this,GlutesExercises.class);
                startActivity(e13);
            }
        });

        exc14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e14 = new Intent(ViewExercises.this,BackExercises.class);
                startActivity(e14);
            }
        });

        exc15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e15 = new Intent(ViewExercises.this,CalvesExercises.class);
                startActivity(e15);
            }
        });

        exc16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e15 = new Intent(ViewExercises.this,TrapeziusExercises.class);
                startActivity(e15);
            }
        });

    }



}