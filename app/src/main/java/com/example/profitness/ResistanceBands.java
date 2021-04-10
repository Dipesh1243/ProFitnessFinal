package com.example.profitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

public class ResistanceBands extends AppCompatActivity {
    private ArrayList<ResistanceBandsItems> rbList;
    private RecyclerView mRecyclerView;
    private ResistanceBandsAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resistance_bands);
        getSupportActionBar().setTitle("View More Exercises");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CreateRB();
        BuildRecyclerViewStretch();

        EditText editText = findViewById(R.id.rbsearch);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

    }

    public void CreateRB(){
        rbList = new ArrayList<>();
        rbList.add(new ResistanceBandsItems(R.drawable.lateralrb, "Banded Lateral Step-out Squat", "Legs, Lower Back, Quads, Hamstrings"));
        rbList.add(new ResistanceBandsItems(R.drawable.frontsquatrb, "Banded Front Squat", "Legs, Quads, Hamstrings"));
        rbList.add(new ResistanceBandsItems(R.drawable.lateralwalk, "Lateral Walk", "Legs, Quads, Hamstrings"));
        rbList.add(new ResistanceBandsItems(R.drawable.deadliftrb, "Deadlift", "Lower Back, Leggs, Quads, Hamstrings, Biceps"));
        rbList.add(new ResistanceBandsItems(R.drawable.shoulderrb, "Shoulder Press", "Shoulders, Triceps"));
        rbList.add(new ResistanceBandsItems(R.drawable.bicylerb, "Bicycle Crunch", "Abs"));
        rbList.add(new ResistanceBandsItems(R.drawable.triceprb, "Tricep Extensions", "Triceps"));
        rbList.add(new ResistanceBandsItems(R.drawable.legrowrb, "Leg Row", "Legs"));
        rbList.add(new ResistanceBandsItems(R.drawable.midbackrb, "Mid-Back Row", "Lower Back, Biceps"));
        rbList.add(new ResistanceBandsItems(R.drawable.frontshouldersrb, "Front Shoulders", "Shoulders"));
    }
    public void BuildRecyclerViewStretch(){
        mRecyclerView = findViewById(R.id.rbrecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ResistanceBandsAdapter(rbList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ResistanceBandsAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                ResistanceBandsItems fooditems1 = rbList.get(position);

                if (fooditems1.getMtext1().contains("Front Shoulders")) {
                    Intent i = new Intent(ResistanceBands.this, WorkoutVideo.class);
                    i.putExtra("my_image", R.raw.rbfrontshoulder);
                    startActivity(i);
                }

                if (fooditems1.getMtext1().contains("Banded Lateral Step-out Squat")) {
                    Intent i = new Intent(ResistanceBands.this, WorkoutVideo.class);
                    i.putExtra("my_image", R.raw.bandedlatstep);
                    startActivity(i);
                }

                if (fooditems1.getMtext1().contains("Banded Front Squat")) {
                    Intent i = new Intent(ResistanceBands.this, WorkoutVideo.class);
                    i.putExtra("my_image", R.raw.bandedlatstep);
                    startActivity(i);
                }
            }
        });
    }

    private void filter(String text){
        ArrayList<ResistanceBandsItems> filteredList = new ArrayList<>();
        for (ResistanceBandsItems item : rbList){
            if (item.getMtext1().toLowerCase().contains(text.toLowerCase()) | item.getMtext2().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }

        mAdapter.filterstrectch(filteredList);
    }
}