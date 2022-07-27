package com.example.alareencenter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alareencenter.databinding.ActivityMyinformationBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.NotNull;

public class Myinformation extends AppCompatActivity {

    FirebaseUser user1;

    DatabaseReference databaseReference;

    String userID;

    Button button;

    ActivityMyinformationBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinformation);


        binding = ActivityMyinformationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        user1 = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user1.getUid();

        final TextView NameTextView = (TextView) findViewById(R.id.Name_user);
        final TextView IDTextView = (TextView) findViewById(R.id.ID_user);
        final TextView EmailTextView = (TextView) findViewById(R.id.Email_user);

        databaseReference.child(userID).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<DataSnapshot> task) {

                if (task.isSuccessful()) {

                    if (task.getResult().exists()) {

                        Toast.makeText(Myinformation.this, "Successfully Read", Toast.LENGTH_SHORT).show();
                        DataSnapshot dataSnapshot = task.getResult();
                        String email = String.valueOf(dataSnapshot.child("email").getValue());
                        String id = String.valueOf(dataSnapshot.child("id").getValue());
                        String name = String.valueOf(dataSnapshot.child("name").getValue());
                        NameTextView.setText(name);
                        IDTextView.setText(id);
                        EmailTextView.setText(email);
                    }
                }
            }
        });
    }
}

