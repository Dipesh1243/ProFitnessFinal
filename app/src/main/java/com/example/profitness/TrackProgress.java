package com.example.profitness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TrackProgress extends AppCompatActivity {

    TrackProgressAdapter trackProgressAdapter;
    RecyclerView rv1;
    FirebaseUser firebaseUser;
    FirebaseAuth firebaseAuth;
    ArrayList<String> list;
    Button bt1,bt2,bt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_progress);
        getSupportActionBar().setTitle("Return to Menu");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rv1 = findViewById(R.id.trackworkout);
        rv1.setHasFixedSize(true);
        rv1.setLayoutManager(new LinearLayoutManager(this));

        bt1 = findViewById(R.id.example);
        bt2 = findViewById(R.id.bmi);
        bt3 = findViewById(R.id.stopwatch);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(TrackProgress.this, WeightTracker.class);
                startActivity(i2);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(TrackProgress.this, BMI.class);
                startActivity(i2);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(TrackProgress.this, Stopwatch.class);
                startActivity(i2);
            }
        });


        list = new ArrayList<>();

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Workout Completed");




        reference.child(firebaseUser.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()){
                    list.add(ds.getKey());

                    trackProgressAdapter = new TrackProgressAdapter(list);
                    rv1.setAdapter(trackProgressAdapter);

                    trackProgressAdapter.setOnItemClickListener(new TrackProgressAdapter.OnItemClickListener() {
                        @Override
                        public void OnItemClick(int position) {
                            String listpos = list.get(position);

                            if (listpos.contains("Gain Muscle")) {
                                Intent i = new Intent(TrackProgress.this, GainMuscle.class);
                                startActivity(i);
                            }
                            if (listpos.contains("Lose Weight")) {
                                Intent i = new Intent(TrackProgress.this, LoseWeight.class);
                                startActivity(i);
                            }
                            if (listpos.contains("Maintain Weight")) {
                                Intent i = new Intent(TrackProgress.this, MaintainWeight.class);
                                startActivity(i);
                            }
                            if (listpos.contains("The Kettlebell Conditioner")) {
                                Intent i = new Intent(TrackProgress.this, HIT.class);
                                startActivity(i);
                            }
                            if (listpos.contains("The Outdoor Sprinter")) {
                                Intent i = new Intent(TrackProgress.this, HIT.class);
                                startActivity(i);
                            }
                            if (listpos.contains("The Home Fat Burner")) {
                                Intent i = new Intent(TrackProgress.this, HIT.class);
                                startActivity(i);
                            }
                            if (listpos.contains("The Punisher")) {
                                Intent i = new Intent(TrackProgress.this, HIT.class);
                                startActivity(i);
                            }
                            if (listpos.contains("The Gym HIIT Workout")) {
                                Intent i = new Intent(TrackProgress.this, HIT.class);
                                startActivity(i);
                            }
                            
                        }

                        @Override
                        public void OnDeleteClick(int position) {
                            String listpos = list.get(position);
                            reference.child(firebaseUser.getUid()).child(listpos).removeValue();
                            list.remove(position);
                            trackProgressAdapter.notifyItemRemoved(position);

                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}