package com.example.profitness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tobiasschuerg.prefixsuffix.PrefixSuffixEditText;

public class BMI extends AppCompatActivity {

    PrefixSuffixEditText editText1, editText2;
    FirebaseUser firebaseUser;
    FirebaseAuth firebaseAuth;
    Button bt1;
    EditText ed1;
    String BMIresult, calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i);
        getSupportActionBar().setTitle("Return to Track Progress");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ed1 = findViewById(R.id.yourbmi);
        editText1 = findViewById(R.id.heightbmi);
        editText2 = findViewById(R.id.weightbmi);

        bt1 = findViewById(R.id.calculate);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("User");

        DatabaseReference reference2 = FirebaseDatabase.getInstance().getReference().child("BMI");

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String height =  editText1.getText().toString();
                String weight =  editText2.getText().toString();

                float weightvalue = Float.parseFloat(weight);
                float heightvalue = Float.parseFloat(height) / 100;

                float bmi = weightvalue / (heightvalue * heightvalue);


                if (bmi < 16){
                    BMIresult = "severly under weight";
                } else if (bmi < 18.5){
                    BMIresult = "under weight";
                }else if (bmi > 18.5 && bmi <= 24.9){
                    BMIresult = "Normal";
                }else if (bmi >= 25){
                    BMIresult = "Overweight";
                }

                String hello = String.valueOf(bmi);
                ed1.setText(hello + BMIresult);

                reference2.child(firebaseUser.getUid()).setValue(hello + " " + BMIresult);




            }
        });


        reference.child(firebaseUser.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                System.out.println(snapshot);

                User info = snapshot.getValue(User.class);
                editText1.setText(info.getHeight());
                editText2.setText(info.getWeight());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        reference2.child(firebaseUser.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String info = (String) snapshot.getValue();
                ed1.setText(info);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }

}