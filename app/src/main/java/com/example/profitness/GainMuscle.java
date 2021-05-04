package com.example.profitness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.mikephil.charting.data.Entry;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class GainMuscle extends AppCompatActivity {

    Button bt1, bt2;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    FirebaseUser firebaseUser;
    FirebaseAuth firebaseAuth;


    private static final String WORKOUT = "Workout";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gain_muscle);

        bt1 = findViewById(R.id.complete);
        bt2 = findViewById(R.id.returnback);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Workout Completed");

        ArrayList<GainMuscleItems> gmList = new ArrayList<>();

        gmList.add(new GainMuscleItems(R.drawable.treadmill, "Warm-up Jog", "10 Minutes"));
        gmList.add(new GainMuscleItems(R.drawable.barbellbench, "Bench Press", "10 Reps for 4 Sets"));
        gmList.add(new GainMuscleItems(R.drawable.overheadpress, "Over Head Press", "10 Reps for 4 Sets"));
        gmList.add(new GainMuscleItems(R.drawable.tbarrow, "T-Bar Rows", "10 Reps for 4 Sets"));
        gmList.add(new GainMuscleItems(R.drawable.frontsquatrb, "Front Squats", "10 Reps for 4 Sets"));
        gmList.add(new GainMuscleItems(R.drawable.torsorelease, "Torso Release", "20-30seconds"));
        gmList.add(new GainMuscleItems(R.drawable.pectoralis, "Pectoralis", "20-30seconds"));

        mRecyclerView = findViewById(R.id.gainmusclerecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new GainMuscleAdapter(gmList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


        reference.child(firebaseUser.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot ds : snapshot.getChildren()) {

                    if (ds.getKey().equals("Gain Muscle")) {
                        bt1.setText("Completed");
                        bt1.setBackgroundColor(Color.parseColor("#4CAF50"));
                    }
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> item = new ArrayList<>();

                reference.child(firebaseUser.getUid()).child("Gain Muscle").setValue(true);

                Toast.makeText(GainMuscle.this, "You have completed this workout", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(GainMuscle.this, Menu.class);
                startActivity(i);
            }
        });


        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(GainMuscle.this, Workouts.class);
                startActivity(i);

            }


        });
    }
}