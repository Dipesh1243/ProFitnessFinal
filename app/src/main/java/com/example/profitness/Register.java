package com.example.profitness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.tobiasschuerg.prefixsuffix.PrefixSuffixEditText;

public class Register extends AppCompatActivity {

    EditText emailID, password, confirmpassword, fullname,age;
    PrefixSuffixEditText height, weight;
    Button btnRegister;
    TextView tvSignin;
    FirebaseAuth mFirebaseAuth;
    private FirebaseDatabase database;
    private DatabaseReference mDatabase;
    private static final String USER = "User";
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailID = findViewById(R.id.email);
        password = findViewById(R.id.password1);
        confirmpassword = findViewById(R.id.password2);
        btnRegister = findViewById(R.id.register);
        fullname = findViewById(R.id.fn);
        age = findViewById(R.id.age);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        tvSignin = findViewById(R.id.signin);
        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference(USER);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String em = emailID.getText().toString();
                String pwd = password.getText().toString();
                String pwd2 = confirmpassword.getText().toString();
                String fn = fullname.getText().toString();
                String agenum= age.getText().toString();
                String heightr = height.getText().toString();
                String weightr = weight.getText().toString();

                user = new User(fn, agenum,heightr,weightr);

                if(em.isEmpty()){
                    emailID.setError("Please enter Email Address");
                    emailID.requestFocus();
                }

                if(fn.isEmpty()){
                    fullname.setError("Please enter fullname");
                    fullname.requestFocus();
                }

                if(agenum.isEmpty()){
                    age.setError("Please enter age");
                    age.requestFocus();
                }

                if(heightr.isEmpty()){
                    height.setError("Please enter height ");
                    height.requestFocus();
                }

                if(weightr.isEmpty()){
                    weight.setError("Please enter weight ");
                    weight.requestFocus();
                }

                else if(pwd.isEmpty()){
                    password.setError("Please enter Password");
                    password.requestFocus();
                }
                else if(!pwd2.equals(pwd)){
                    password.setError("Passwords do not match");
                    password.requestFocus();
                }
                else if(em.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(Register.this,"Fields are empty!",Toast.LENGTH_SHORT).show();
                }
                else if(!(em.isEmpty() && pwd.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(em, pwd).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(Register.this,"Account already exists",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                FirebaseUser user = mFirebaseAuth.getCurrentUser();
                                updateUI(user);
                                startActivity(new Intent(Register.this, Menu.class));

                            }
                        }
                    });
                }
                else {
                    Toast.makeText(Register.this,"Error Occurred",Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Register.this, MainActivity.class);
                startActivity(i);
            }
        });

    }

    public void updateUI(FirebaseUser currentuser){
        //String KeyID = mDatabase.push().getKey();
        mDatabase.child(currentuser.getUid()).setValue(user);
    }
}