package com.example.profitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

public class Stretches extends AppCompatActivity {
    private ArrayList<StretchesItems> stretchesList;
    private RecyclerView mRecyclerView;
    private StretchesAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stretches);
        getSupportActionBar().setTitle("View More Exercises");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CreateStretchList();
        BuildRecyclerViewStretch();

        EditText editText = findViewById(R.id.stretchesearch);
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

    public void CreateStretchList(){
        stretchesList = new ArrayList<>();
        stretchesList.add(new StretchesItems(R.drawable.hamstringstetch, "Standing Hamstring ", "Neck, Back, Glutes, Hamstrings, Calves"));
        stretchesList.add(new StretchesItems(R.drawable.piriformis, "Piriformis", "Hips, Back, Glutes"));
        stretchesList.add(new StretchesItems(R.drawable.lungetwist, "Lunge With Spinal Twist", "Hip flexors, Quads, Back"));
        stretchesList.add(new StretchesItems(R.drawable.figure4, "Figure 4", "Hips, Glutes, Lower back, Hamstrings"));
        stretchesList.add(new StretchesItems(R.drawable.butterfly, "Butterfly", "Hips, Glutes, Back, Thighs"));
        stretchesList.add(new StretchesItems(R.drawable.sidebend, "Side Bend", "Groin, Hips, Inner thigh, Obliques"));
        stretchesList.add(new StretchesItems(R.drawable.lunging, "Lunging Hip Flexor", "Hips, Quads, Glutes"));
        stretchesList.add(new StretchesItems(R.drawable.kneetochest, "Knee To Chest", "Lower Back, Hips, Hamstrings"));
        stretchesList.add(new StretchesItems(R.drawable.lyingquad, "Lying Quad", "Quad"));
        stretchesList.add(new StretchesItems(R.drawable.standingquad, "Standing Quad", "Quad"));
        stretchesList.add(new StretchesItems(R.drawable.sphinx, "Sphinx Pose", "Lower back, Chest, Shoulders"));
        stretchesList.add(new StretchesItems(R.drawable.torsorelease, "Torso Release", "Arms, Chest"));
        stretchesList.add(new StretchesItems(R.drawable.pectoralis, "Pectoralis", "Chest, Arms"));
    }

    public void BuildRecyclerViewStretch(){
        mRecyclerView = findViewById(R.id.stretchrecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new StretchesAdapter(stretchesList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void filter(String text){
        ArrayList<StretchesItems> filteredList = new ArrayList<>();
        for (StretchesItems item : stretchesList){
            if (item.getMtext1().toLowerCase().contains(text.toLowerCase()) | item.getMtext2().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }

        mAdapter.filterstrectch(filteredList);
    }


}