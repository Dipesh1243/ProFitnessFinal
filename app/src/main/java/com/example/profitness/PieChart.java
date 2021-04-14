package com.example.profitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class PieChart extends AppCompatActivity {

        com.github.mikephil.charting.charts.PieChart pieChart;
        Button bt1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
        getSupportActionBar().setTitle("Return to Menu");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pieChart = findViewById(R.id.piechart);
        bt1 = findViewById(R.id.back);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PieChart.this, Menu.class);
                startActivity(i);
            }
        });

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5,10,5,5);

        pieChart.setDragDecelerationFrictionCoef(0.99f);

        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f);
        pieChart.setEntryLabelColor(Color.BLACK);


        ArrayList<PieEntry> yValues = new ArrayList<>();

        yValues.add(new PieEntry(20f, "Strength"));
        yValues.add(new PieEntry(10f, "High Intensity Training"));
        yValues.add(new PieEntry(20f, "Cardio"));
        yValues.add(new PieEntry(40f, "Healthy Eating"));
        yValues.add(new PieEntry(10f, "Stretching"));




        pieChart.setCenterText("How to spend your time");
        pieChart.setCenterTextSize(24);



        pieChart.animateY(1000, Easing.EaseInOutCubic);



        PieDataSet pieDataSet = new PieDataSet(yValues, "Countries");
        pieDataSet.setSliceSpace(3f);
        pieDataSet.setSelectionShift(5f);
        pieDataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);

        PieData pieData = new PieData((pieDataSet));
        pieData.setValueTextSize(10f);
        pieData.setValueTextColor(Color.BLACK);

        pieChart.setData(pieData);



    }
}