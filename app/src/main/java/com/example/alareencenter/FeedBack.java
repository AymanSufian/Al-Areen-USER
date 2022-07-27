package com.example.alareencenter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FeedBack extends AppCompatActivity {

    private com.firebase.client.Firebase Ref ;
    private EditText feedback,username ;
    private Button feedbackbtn ;
    FirebaseAuth mAuth ;

    DatabaseReference reference ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);

        username = findViewById(R.id.username);
        feedback = findViewById(R.id.feedback);

        Firebase.setAndroidContext(this);

        mAuth = FirebaseAuth.getInstance();
        Ref= new Firebase("https://physiotherapy-37b02-default-rtdb.firebaseio.com");

        feedbackbtn = findViewById(R.id.feedbackbtn);
        feedbackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String usernameinput = username.getText().toString();
                String feedbackinput = feedback.getText().toString();
                Firebase Reusername = Ref.child("Feedback").child(mAuth.getUid()).child("feed");
                Reusername.setValue(usernameinput);

                Firebase Refeedback = Ref.child("Feedback").child(mAuth.getUid()).child("feed");
                Refeedback.setValue(feedbackinput);

            }
        });



    }
}