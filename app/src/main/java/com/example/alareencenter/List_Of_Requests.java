package com.example.alareencenter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class List_Of_Requests extends AppCompatActivity {

    FirebaseUser user;
    DatabaseReference databaseReference;
    String subjectID;
    FirebaseAuth auth ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_requests);

        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        subjectID= user.getUid();
        auth= FirebaseAuth.getInstance();


        final TextView subjects1TextView = (TextView) findViewById(R.id.tvbCname);
        final TextView subjects2TextView = (TextView) findViewById(R.id.tvCdes);
        final TextView subjects3TextView = (TextView) findViewById(R.id.tvCBreed);
        final TextView subjects4TextView = (TextView) findViewById(R.id.tvcal);
        final TextView subjects5TextView = (TextView) findViewById(R.id.tvdate);




        databaseReference.child(auth.getUid()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<DataSnapshot> task) {

                if (task.isSuccessful()) {

                    if (task.getResult().exists()) {

                        Toast.makeText(List_Of_Requests.this, "Reading Successfully", Toast.LENGTH_SHORT).show();
                        DataSnapshot dataSnapshot = task.getResult();
                        String check1=String.valueOf(dataSnapshot.child("Patient_Name").getValue());
                        String check2=String.valueOf(dataSnapshot.child("Inj_Place").getValue());
                        String check3=String.valueOf(dataSnapshot.child("Inj_Des").getValue());
                        String check4=String.valueOf(dataSnapshot.child("Calender").getValue());
                        String check5=String.valueOf(dataSnapshot.child("Date").getValue());


                        subjects1TextView.setText(check1);
                        subjects2TextView.setText(check2);
                        subjects3TextView.setText(check3);
                        subjects4TextView.setText(check4);
                        subjects5TextView.setText(check5);



                    }

                }
            }
        });



    }
}

