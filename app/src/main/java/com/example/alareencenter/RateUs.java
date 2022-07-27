package com.example.alareencenter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;

public class RateUs extends AppCompatActivity {

    Button button ;
    TextView textView ;
    RatingBar ratingBar ;

    FirebaseAuth mAuth ;
    private com.firebase.client.Firebase Ref ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_us);


        textView = findViewById(R.id.mytextview);
        ratingBar = findViewById(R.id.ratingBar);

        Firebase.setAndroidContext(this);

        mAuth = FirebaseAuth.getInstance();
        Ref= new Firebase("https://physiotherapy-37b02-default-rtdb.firebaseio.com");



        button = findViewById(R.id.buttonshow);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String rating = ratingBar.getRating() + "";
                textView.setText("result : "+ rating);
                Toast.makeText(RateUs.this,"thanks for rating"+rating,Toast.LENGTH_SHORT).show();
                String usernameinput = textView.getText().toString();
                Firebase Reusername = Ref.child("Rating").child(mAuth.getUid()).child("rate");
                Reusername.setValue(usernameinput);

            }
        });
    }
}