 package com.example.profitness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tobiasschuerg.prefixsuffix.PrefixSuffixEditText;

public class Profile extends AppCompatActivity {


    FirebaseUser firebaseUser;
    FirebaseAuth firebaseAuth;
    Button bt1;
    EditText ed1,ed2;
    PrefixSuffixEditText ed3,ed4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setTitle("Return to Menu");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ed1 = findViewById(R.id.fullnameprofile);
        ed2 = findViewById(R.id.ageprofile);
        ed3 = findViewById(R.id.heightprofile);
        ed4 = findViewById(R.id.weightprofile);
        bt1 = findViewById(R.id.saveprofile);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("User");


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String nm =  ed1.getText().toString();
               String age =  ed2.getText().toString();
               String height =  ed3.getText().toString();
               String weight =  ed4.getText().toString();
               User editedUser = new User(nm, age, height, weight);

               reference.child(firebaseUser.getUid()).setValue(editedUser);
                Toast.makeText(Profile.this,"Profile has been saved",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Profile.this, Menu.class);
                startActivity(i);

            }
        });

        reference.child(firebaseUser.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                System.out.println(snapshot);

                User info = snapshot.getValue(User.class);
                ed1.setText(info.getName());
                ed2.setText(info.getAge());
                ed3.setText(info.getHeight());
                ed4.setText(info.getWeight());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}