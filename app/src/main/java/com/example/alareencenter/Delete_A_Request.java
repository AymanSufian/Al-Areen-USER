package com.example.alareencenter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alareencenter.databinding.ActivityDeleteArequestBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Delete_A_Request extends AppCompatActivity {

    ActivityDeleteArequestBinding binding ;
    DatabaseReference reference ;

    EditText P_id ;
    Button delitem ;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_arequest);
        delitem = findViewById(R.id.delitem);
        mAuth = FirebaseAuth.getInstance();

        P_id = findViewById(R.id.catid);


        delitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Patient__name = P_id.getText().toString();
                if (!Patient__name.isEmpty()){

                    deleteData(Patient__name);
                }
                else {


                    Toast.makeText(Delete_A_Request.this,"Please Write A Correctly Name",Toast.LENGTH_SHORT).show();


                }
            }
        });
    }

    private void deleteData(String Patient_name) {

        reference = FirebaseDatabase.getInstance().getReference("Users");
        reference.child(mAuth.getUid()).child("My reservation").removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()){

                    Toast.makeText(Delete_A_Request.this,"Successfully Deleted",Toast.LENGTH_SHORT).show();
                    P_id.setText("");
                }
                else {

                    Toast.makeText(Delete_A_Request.this,"Failed to delete",Toast.LENGTH_SHORT).show();

                }

            }
        });

    }
}