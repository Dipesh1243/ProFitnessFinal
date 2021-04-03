package com.example.profitness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.EntryXComparator;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class WeightTracker extends AppCompatActivity {

    EditText ed1,ed2;
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
        //hi
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
    lineDataSet.setLabel("data set 1");
    iLineDataSets.clear();
    iLineDataSets.add(lineDataSet);
    lineData = new LineData(iLineDataSets);
    lineChart.clear();
    lineChart.setData(lineData);
    lineChart.invalidate();
    }


}