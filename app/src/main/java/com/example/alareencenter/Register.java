package com.example.alareencenter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alareencenter.MENU.RheumatiodArthritis;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity implements View.OnClickListener {



    EditText Email, Password, Name,ID;
    Button BackLogin;
    FirebaseAuth mAuth;
    TextView banner;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        mAuth=FirebaseAuth.getInstance();



        BackLogin=findViewById(R.id.BackLogin);
        BackLogin.setOnClickListener(this);

        Email=findViewById(R.id.patientemail);
        Password=findViewById(R.id.patientpass);
        Name=findViewById(R.id.patientname);
        ID=findViewById(R.id.patientphone);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.BackLogin:
                registerUser();
                break;
        }


    }

    private void registerUser() {
        String patientName=Name.getText().toString().trim();
        String patientphone=ID.getText().toString().trim();
        String patientemail=Email.getText().toString().trim();
        String patientpass=Password.getText().toString().trim();

        if (patientName.isEmpty()){
            Name.setError("Student Name is Required !");
            Name.requestFocus();
            return;
        }
        if (patientphone.length()==10){
            ID.setError(" Student ID must be 10 char at least  ");
            ID.requestFocus();
            return;}

        if (patientphone.isEmpty()){
            ID.setError("Student ID is Required !");
            ID.requestFocus();
            return;
        }

        if (patientemail.isEmpty()){
            Email.setError("Student Email is Required !");
            Email.requestFocus();
            return;
        }

        if (patientpass.isEmpty()){
            Password.setError("Student Password is Required !");
            Password.requestFocus();
            return;
        }
        if (patientpass.length()<6){
            Password.setError("Minimum Password length Should be 6 characters !");
            Password.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(patientemail,patientpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    User user=new User(patientName,patientphone,patientemail);
                    firebaseDatabase.getInstance().getReference("Users").child(mAuth.getInstance().getCurrentUser().getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull  Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(Register.this,"Registered Successfully !",Toast.LENGTH_LONG).show();
                            }
                            else {
                                Toast.makeText(Register.this,"Failed to Registered ! Try again",Toast.LENGTH_LONG).show();


                            }
                        }
                    });


                }else {
                    Toast.makeText(Register.this,"Failed to Registered ",Toast.LENGTH_LONG).show();


                }
            }
        });



    }


    public void BackLOG(View view) {
        startActivity(new Intent(Register.this, MainActivity.class));

    }
}