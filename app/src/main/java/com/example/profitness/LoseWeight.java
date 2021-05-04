package com.example.profitness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LoseWeight extends AppCompatActivity {

    Button bt1, bt2;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    FirebaseUser firebaseUser;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose_weight);

        bt1 = findViewById(R.id.completeloseweight);
        bt2 = findViewById(R.id.returnback);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Workout Completed");

        ArrayList<GainMuscleItems> gmList = new ArrayList<>();

        gmList.add(new GainMuscleItems(R.drawable.jumprope, "Skipping", "1 Minute for 5 sets"));
        gmList.add(new GainMuscleItems(R.drawable.inclinebarbell, "Incline Bench Press", "10 Reps for 4 Sets"));
        gmList.add(new GainMuscleItems(R.drawable.weighteddips, "Weighted Dips", "10 Reps for 4 Sets"));
        gmList.add(new GainMuscleItems(R.drawable.bentrow, "Bent Over Rows", "10 Reps for 4 Sets"));
        gmList.add(new GainMuscleItems(R.drawable.farmerswalk, "Farmers Squats", "10 metres for 4 Sets"));
        gmList.add(new GainMuscleItems(R.drawable.butterfly, "Butterfly Stretch", "20-30seconds"));
        gmList.add(new GainMuscleItems(R.drawable.sidebend, "Side Bend Stretch", "20-30seconds"));
        gmList.add(new GainMuscleItems(R.drawable.eliptical, "Eliptical Machine", "10 Mins"));

        mRecyclerView = findViewById(R.id.loseweightrecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new GainMuscleAdapter(gmList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> item = new ArrayList<>();

                reference.child(firebaseUser.getUid()).child("Lose Weight").setValue(true);

                Intent i = new Intent(LoseWeight.this, Menu.class);
                startActivity(i);
                Toast.makeText(LoseWeight.this, "You have completed this workout", Toast.LENGTH_SHORT).show();
            }
        });

        reference.child(firebaseUser.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot ds : snapshot.getChildren()) {

                    if (ds.getKey().equals("Lose Weight")) {
                        bt1.setText("Completed");
                        bt1.setBackgroundColor(Color.parseColor("#4CAF50"));
                    }
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoseWeight.this, Workouts.class);
                startActivity(i);
            }
        });
    }

}