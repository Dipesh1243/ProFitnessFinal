package com.example.profitness;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;


import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HiitDialog3 extends AppCompatDialogFragment {

    FirebaseUser firebaseUser;
    FirebaseAuth firebaseAuth;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Workout Completed");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view3 = inflater.inflate(R.layout.hitworkout3, null);

        builder.setView(view3)
                .setTitle("Home Fat Burner")
                .setNegativeButton("Return", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Complete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        reference.child(firebaseUser.getUid()).child("The Home Fat Burner").setValue(true);
                    }
                });


        return  builder.create();
    }
}
