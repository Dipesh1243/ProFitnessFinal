package com.example.profitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

import java.util.ArrayList;

public class Cardio extends AppCompatActivity {
    private ArrayList<CardioItems> cardioList;
    private RecyclerView mRecyclerView;
    private CardioAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio);
        getSupportActionBar().setTitle("View More Exercises");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CreateCardioList();
        BuildRecyclerView();

        EditText editText = findViewById(R.id.cardiosearch);
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

    public void CreateCardioList() {

        cardioList = new ArrayList<>();
        cardioList.add(new CardioItems(R.drawable.jumprope, "Jump Rope", "Equipment: Skipping Rope"));
        cardioList.add(new CardioItems(R.drawable.swimming, "Swimming", "Equipment: Swimming Pool"));
        cardioList.add(new CardioItems(R.drawable.jogging, "Outdoor Jogging", "No Equipment Required"));
        cardioList.add(new CardioItems(R.drawable.boxing, "Boxing", "Equipment: Gym, Punching Bag"));
        cardioList.add(new CardioItems(R.drawable.cycling, "Cycling", "Equipment: Gym, Bike"));
        cardioList.add(new CardioItems(R.drawable.powerwalk, "Power Walking", "No Equipment Required"));
        cardioList.add(new CardioItems(R.drawable.rowing, "Rowing", "Equipment: Gym"));
        cardioList.add(new CardioItems(R.drawable.eliptical, "Elliptical", "Equipment: Gym"));
        cardioList.add(new CardioItems(R.drawable.stairclimber, "Stair Climber", "Equipment: Gym"));
        cardioList.add(new CardioItems(R.drawable.treadmill, "Treadmill", "Equipment: Gym"));
        cardioList.add(new CardioItems(R.drawable.spinbike, "Spin Bike", "Equipment: Gym"));

    }

    public void BuildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new CardioAdapter(cardioList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new CardioAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                CardioItems cardioItems = cardioList.get(position);

                if (cardioItems.getMtext1().contains("Jump Rope")) {

                    Intent i = new Intent(Cardio.this, Webview.class);
                    i.putExtra("my_image", "jump");
                    startActivity(i);
                }

                if (cardioItems.getMtext1().contains("Swimming")) {

                    Intent i = new Intent(Cardio.this, Webview.class);
                    i.putExtra("my_image", "swim");
                    startActivity(i);
                }

                if (cardioItems.getMtext1().contains("Outdoor Jogging")) {
                    Intent i = new Intent(Cardio.this, Webview.class);
                    i.putExtra("my_image", "jog");
                    startActivity(i);
                }

                if (cardioItems.getMtext1().contains("Boxing")) {
                    Intent i = new Intent(Cardio.this, Webview.class);
                    i.putExtra("my_image", "box");
                    startActivity(i);
                }

                if (cardioItems.getMtext1().contains("Cycling")) {
                    Intent i = new Intent(Cardio.this, Webview.class);
                    i.putExtra("my_image", "cycle");
                    startActivity(i);
                }

                if (cardioItems.getMtext1().contains("Power Walking")) {
                    Intent i = new Intent(Cardio.this, Webview.class);
                    i.putExtra("my_image", "powerwalk");
                    startActivity(i);
                }

                if (cardioItems.getMtext1().contains("Rowing")) {
                    Intent i = new Intent(Cardio.this, Webview.class);
                    i.putExtra("my_image", "rowing");
                    startActivity(i);
                }

                if (cardioItems.getMtext1().contains("Elliptical")) {
                    Intent i = new Intent(Cardio.this, Webview.class);
                    i.putExtra("my_image", "elliptical");
                    startActivity(i);
                }

                if (cardioItems.getMtext1().contains("Stair Climber")) {
                    Intent i = new Intent(Cardio.this, Webview.class);
                    i.putExtra("my_image", "stairs");
                    startActivity(i);
                }

                if (cardioItems.getMtext1().contains("Treadmill")) {
                    Intent i = new Intent(Cardio.this, Webview.class);
                    i.putExtra("my_image", "treadmill");
                    startActivity(i);
                }
                if (cardioItems.getMtext1().contains("Spin Bike")) {
                    Intent i = new Intent(Cardio.this, Webview.class);
                    i.putExtra("my_image", "spinbike");
                    startActivity(i);
                }
            }
        });
    }

    private void filter(String text) {
        ArrayList<CardioItems> filteredList = new ArrayList<>();
        for (CardioItems item : cardioList) {
            if (item.getMtext1().toLowerCase().contains(text.toLowerCase()) | item.getMtext2().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        mAdapter.test(filteredList);
    }


}