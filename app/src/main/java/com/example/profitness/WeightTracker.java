package com.example.profitness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.EntryXComparator;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tobiasschuerg.prefixsuffix.PrefixSuffixEditText;

import java.util.ArrayList;
import java.util.Calendar;

public class WeightTracker extends AppCompatActivity {


    EditText ed1;
    PrefixSuffixEditText ed2;
    Button bt1;
    LineChart lineChart;


    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    FirebaseUser firebaseUser;
    FirebaseAuth firebaseAuth;

    LineDataSet lineDataSet = new LineDataSet(null, null);
    ArrayList<ILineDataSet> iLineDataSets = new ArrayList<>();
    LineData lineData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_tracker);
        getSupportActionBar().setTitle("Return to Track Progress");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ed1 = findViewById(R.id.xvalue);
        ed2 = findViewById(R.id.yvalue);
        bt1 = findViewById(R.id.insert);
        lineChart = findViewById(R.id.linechart);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();


        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Chart Values");

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = databaseReference.push().getKey();
                int x = Integer.parseInt(ed1.getText().toString());
                int y = Integer.parseInt(ed2.getText().toString());

                DataPoint dataPoint = new DataPoint(x,y);
                databaseReference.child(firebaseUser.getUid()).child(id).setValue(dataPoint);

                retrieveData();
            }
        });

        retrieveData();

    }



    private void retrieveData() {

        databaseReference.child(firebaseUser.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<Entry> dataVals = new ArrayList<Entry>();

                if (snapshot.hasChildren()){
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        DataPoint dataPoint = dataSnapshot.getValue(DataPoint.class);
                        dataVals.add(new Entry(dataPoint.getxValue(),dataPoint.getyValue()));
                    }
                    showChart(dataVals);
                }else {
                    lineChart.clear();
                    lineChart.invalidate();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void showChart(ArrayList<Entry> dataVals) {
    lineDataSet.setValues(dataVals);
    lineDataSet.setLabel("Weight");
        lineDataSet.setDrawFilled(true);
        lineDataSet.setFillColor(Color.parseColor("#03A9F4"));
        lineDataSet.setValueTextSize(12);
        lineDataSet.setColor(Color.parseColor("#03A9F4"));
        lineDataSet.setDrawCircles(true);
        lineDataSet.setCircleColor(Color.parseColor("#03A9F4"));
        lineDataSet.setCircleHoleColor(Color.parseColor("#03A9F4"));
        lineDataSet.setCircleRadius(5);
        lineDataSet.setDrawValues(false);

        Description description = new Description();
        description.setEnabled(false);



        XAxis xAxis = lineChart.getXAxis();
        xAxis.setValueFormatter(new MyAxisValueFormatter());
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(true);
        xAxis.setAxisMinimum(1);
        xAxis.setTextSize(12);
        xAxis.setDrawGridLines(true);

        YAxis leftYAxis = lineChart.getAxisLeft();
        leftYAxis.setValueFormatter(new MyAxisValueFormatter2());
        leftYAxis.setAxisMinimum(0);
        leftYAxis.setTextSize(12);
        leftYAxis.setDrawGridLines(true);

        YAxis rightYAxis = lineChart.getAxisRight();
        rightYAxis.setEnabled(false);


        lineChart.setHighlightPerDragEnabled(true);
        lineChart.animateXY(1000, 1000, Easing.EaseInOutBack, Easing.EaseInBack);
        lineChart.setDescription(description);

    iLineDataSets.clear();
    iLineDataSets.add(lineDataSet);
    lineData = new LineData(iLineDataSets);
    lineChart.clear();
    lineChart.setData(lineData);
    lineChart.invalidate();

    }

    private class MyAxisValueFormatter extends ValueFormatter implements IAxisValueFormatter{

        @Override
        public String getFormattedValue(float value) {
            return "Day " + value;
        }
    }

    private class MyAxisValueFormatter2 extends ValueFormatter implements IAxisValueFormatter{

        @Override
        public String getFormattedValue(float value) {
            return value+" kg";
        }
    }






}