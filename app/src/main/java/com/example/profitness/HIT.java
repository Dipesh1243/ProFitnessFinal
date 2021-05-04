package com.example.profitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;

public class HIT extends AppCompatActivity {
    public CardView cdhit1, cdhit2, cdhit3, cdhit4, cdhit5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h_i_t);
        getSupportActionBar().setTitle("View More Exercises");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cdhit1 = findViewById(R.id.hit1);
        cdhit2 = findViewById(R.id.hit2);
        cdhit3 = findViewById(R.id.hit3);
        cdhit4 = findViewById(R.id.hit4);
        cdhit5 = findViewById(R.id.hit5);

        cdhit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog1();
            }
        });

        cdhit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog2();
            }
        });

        cdhit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog3();
            }
        });

        cdhit4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog4();
            }
        });

        cdhit5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog5();
            }
        });


    }

    public void openDialog1() {
        HiitDialog1 hiitDialog1 = new HiitDialog1();
        hiitDialog1.show(getSupportFragmentManager(), "hiitdialog 1");

    }

    public void openDialog2() {
        HiitDialog2 hiitDialog2 = new HiitDialog2();
        hiitDialog2.show(getSupportFragmentManager(), "hiitdialog 2");

    }

    public void openDialog3() {
        HiitDialog3 hiitDialog3 = new HiitDialog3();
        hiitDialog3.show(getSupportFragmentManager(), "hiitdialog 3");

    }

    public void openDialog4() {
        HiitDialog4 hiitDialog4 = new HiitDialog4();
        hiitDialog4.show(getSupportFragmentManager(), "hiitdialog 4");

    }

    public void openDialog5() {
        HiitDialog5 hiitDialog5 = new HiitDialog5();
        hiitDialog5.show(getSupportFragmentManager(), "hiitdialog 5");

    }
}