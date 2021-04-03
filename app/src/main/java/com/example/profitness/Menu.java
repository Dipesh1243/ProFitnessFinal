package com.example.profitness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Menu extends AppCompatActivity {

    Button btnlogout;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    public CardView card1,card2,card3,card4,card5,card6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        card1 = findViewById(R.id.cd1);
        card2 = findViewById(R.id.cd4);
        card3 = findViewById(R.id.cd6);
        card4 =  findViewById(R.id.cd2);
        card5 = findViewById(R.id.cd5);
        card6 = findViewById(R.id.cd3);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToViewExc = new Intent(Menu.this, ViewExercises.class);
                startActivity(intToViewExc);
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToViewExc = new Intent(Menu.this, Advice.class);
                startActivity(intToViewExc);
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToViewPro = new Intent(Menu.this, Profile.class);
                startActivity(intToViewPro);
            }
        });

        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToViewWorkout = new Intent(Menu.this, Workouts.class);
                startActivity(intToViewWorkout);
            }
        });

        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intTotrack = new Intent(Menu.this, TrackProgress.class);
                startActivity(intTotrack);
            }
        });

        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intTodiet = new Intent(Menu.this, Diet.class);
                startActivity(intTodiet);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menulogout:
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(Menu.this, MainActivity.class);
                startActivity(intToMain);
        }
        return super.onOptionsItemSelected(item);
    }
}