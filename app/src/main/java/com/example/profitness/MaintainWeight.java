package com.example.profitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MaintainWeight extends AppCompatActivity {

    Button bt1,bt2;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    FirebaseUser firebaseUser;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintain_weight);

        bt1 = findViewById(R.id.completemaintainweight);
        bt2 = findViewById(R.id.returnback);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Workout Completed");

        ArrayList<GainMuscleItems> gmList = new ArrayList<>();

        gmList.add(new GainMuscleItems(R.drawable.spinbike, "Spin Bike", "2 Minute for 5 sets"));
        gmList.add(new GainMuscleItems(R.drawable.dumbellpullovers, "Dumbell Pullovers", "10 Reps for 4 Sets"));
        gmList.add(new GainMuscleItems(R.drawable.arnoldshoulderpress, "Arnold Press", "10 Reps for 4 Sets"));
        gmList.add(new GainMuscleItems(R.drawable.lateralraises, "Lateral Raises", "10 Reps for 4 Sets"));
        gmList.add(new GainMuscleItems(R.drawable.concentrationcurl, "Concentration Curl", "10 Reps for 4 Sets"));
        gmList.add(new GainMuscleItems(R.drawable.pushup, "Push ups", "Max 20-30seconds for 5 reps"));


        mRecyclerView = findViewById(R.id.maintainweightrecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new GainMuscleAdapter(gmList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> item = new ArrayList<>();

                reference.child(firebaseUser.getUid()).child("MaintainWeight").setValue(true);
                Intent i = new Intent(MaintainWeight.this, Menu.class);
                startActivity(i);
                Toast.makeText(MaintainWeight.this,"You have completed this workout",Toast.LENGTH_SHORT).show();
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MaintainWeight.this, Workouts.class);
                startActivity(i);
            }
        });

    }
}