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

        mAdapter.setOnItemClickListener(new StretchesAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                StretchesItems cardioItems = stretchesList.get(position);

                if (cardioItems.getMtext1().contains("Standing Hamstring")) {

                    Intent i = new Intent(Stretches.this, WorkoutVideo.class);
                    i.putExtra("my_image", R.raw.standingham);
                    startActivity(i);
                }
                if (cardioItems.getMtext1().contains("Piriformis")) {

                    Intent i = new Intent(Stretches.this, WorkoutVideo.class);
                    i.putExtra("my_image", R.raw.piriformis);
                    startActivity(i);
                }

                if (cardioItems.getMtext1().contains("Lunge With Spinal Twist")) {

                    Intent i = new Intent(Stretches.this, WorkoutVideo.class);
                    i.putExtra("my_image", R.raw.lungetwist);
                    startActivity(i);
                }

                if (cardioItems.getMtext1().contains("Figure 4")) {

                    Intent i = new Intent(Stretches.this, WorkoutVideo.class);
                    i.putExtra("my_image", R.raw.fig4);
                    startActivity(i);
                }

                if (cardioItems.getMtext1().contains("Butterfly")) {

                    Intent i = new Intent(Stretches.this, WorkoutVideo.class);
                    i.putExtra("my_image", R.raw.butterfly);
                    startActivity(i);
                }

                if (cardioItems.getMtext1().contains("Side Bend")) {

                    Intent i = new Intent(Stretches.this, WorkoutVideo.class);
                    i.putExtra("my_image", R.raw.sidebend);
                    startActivity(i);
                }

                if (cardioItems.getMtext1().contains("Lunging Hip Flexor")) {

                    Intent i = new Intent(Stretches.this, WorkoutVideo.class);
                    i.putExtra("my_image", R.raw.lungehip);
                    startActivity(i);
                }
                if (cardioItems.getMtext1().contains("Knee To Chest")) {

                    Intent i = new Intent(Stretches.this, WorkoutVideo.class);
                    i.putExtra("my_image", R.raw.kneetochest);
                    startActivity(i);
                }
                if (cardioItems.getMtext1().contains("Lying Quad")) {

                    Intent i = new Intent(Stretches.this, WorkoutVideo.class);
                    i.putExtra("my_image", R.raw.lyingquad);
                    startActivity(i);
                }

                if (cardioItems.getMtext1().contains("Standing Quad")) {
                    Intent i = new Intent(Stretches.this, WorkoutVideo.class);
                    i.putExtra("my_image", R.raw.standingquad);
                    startActivity(i);
                }
                if (cardioItems.getMtext1().contains("Sphinx Pose")) {
                    Intent i = new Intent(Stretches.this, WorkoutVideo.class);
                    i.putExtra("my_image", R.raw.sphinx);
                    startActivity(i);
                }

                if (cardioItems.getMtext1().contains("Torso Release")) {
                    Intent i = new Intent(Stretches.this, WorkoutVideo.class);
                    i.putExtra("my_image", R.raw.torso);
                    startActivity(i);
                }
                if (cardioItems.getMtext1().contains("Pectoralis")) {
                    Intent i = new Intent(Stretches.this, WorkoutVideo.class);
                    i.putExtra("my_image", R.raw.pectoralis);
                    startActivity(i);
                }
            }
        });
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