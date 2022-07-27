package com.example.alareencenter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.alareencenter.MENU.Home;

public class Patient_Page extends AppCompatActivity {

    CardView cardinfo ,update,list,delete , Myinformation , feed , buttonshow ;
    Button back ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_page);




        update = findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Patient_Page.this , Update_A_Request.class);
                startActivity(intent);
            }
        });

        list = findViewById(R.id.allinlist);
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Patient_Page.this , List_Of_Requests.class);
                startActivity(intent);
            }
        });

        delete = findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Patient_Page.this , Delete_A_Request.class);
                startActivity(intent);
            }
        });


        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Patient_Page.this, Home.class);
                startActivity(intent);
                Patient_Page.this.finish();
            }
        });


        Myinformation = findViewById(R.id.Myinformation);
        Myinformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Patient_Page.this, Myinformation.class);
                startActivity(intent);

            }
        });


        feed = findViewById(R.id.feed);
        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Patient_Page.this, FeedBack.class);
                startActivity(intent);

            }
        });



        buttonshow = findViewById(R.id.buttonshow);
        buttonshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Patient_Page.this, RateUs.class);
                startActivity(intent);

            }
        });



    }
}