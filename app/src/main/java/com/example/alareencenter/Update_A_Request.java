package com.example.alareencenter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Update_A_Request extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    DatabaseReference databaseReference ;
    Button updateinfo ;
    EditText PatientName , InjuryPlace , InjuryDes , cal;
    TextView data ;
    DatePickerDialog picker ;
    FirebaseAuth mAuth;

    Spinner date1 ;
    String item ;
    Member member ;
    String [] Dates = {"please choose a date","8-9 am","9-10 am",
                       "10-11 am" , "11-12 am" , "12-1 pm", "1-2 pm",
                       "2-3 pm" , "3-4 pm", "4-5 pm", "5-6 pm"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_arequest);

        date1 = findViewById(R.id.date1);
        date1.setOnItemSelectedListener(this);

        member = new Member();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this , com.airbnb.lottie.R.layout.support_simple_spinner_dropdown_item, Dates);
        arrayAdapter.setDropDownViewResource(androidx.navigation.ui.R.layout.support_simple_spinner_dropdown_item);

        date1.setAdapter(arrayAdapter);



        mAuth = FirebaseAuth.getInstance();

        PatientName = findViewById(R.id.name);
        InjuryPlace = findViewById(R.id.breed);
        InjuryDes = findViewById(R.id.des);
        cal = findViewById(R.id.cal);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                picker = new DatePickerDialog(Update_A_Request.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        cal.setText(dayOfMonth + "/" + (month +1) + "/" + year);

                    }

                } , year,month,day);
                picker.show();

            }
        });

        data = findViewById(R.id.date);
        updateinfo=findViewById(R.id.updateinfo);

        updateinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Patientname = PatientName.getText().toString();
                String Injuryplace = InjuryPlace.getText().toString();
                String Injurydes = InjuryDes.getText().toString();
                String Calender = cal.getText().toString();
                String Date = data.getText().toString();
                UpdateData(Patientname,Injuryplace,Injurydes,Calender,Date);




                if (Patientname.isEmpty()){
                    PatientName.setError("Patient Name is Required !");
                    PatientName.requestFocus();
                    return;
                }
                if (Injuryplace.isEmpty()){
                    InjuryPlace.setError(" Place must be founded  ");
                    InjuryPlace.requestFocus();
                    return;}

                if (Injurydes.isEmpty()){
                    InjuryDes.setError("Description is Required !");
                    InjuryDes.requestFocus();
                    return;
                }

                if (Calender.isEmpty()){
                    cal.setError("Calender is Required !");
                    cal.requestFocus();
                    return;
                }

                if (Date.isEmpty()){
                    data.setError(" Date is Required !");
                    data.requestFocus();
                    return;
                }

                Toast.makeText(getApplicationContext(),"Updated complete",Toast.LENGTH_SHORT).show();
            }


        });


    }


    private void UpdateData(String Patientname, String Injuryplace, String Injurydes,String Calender , String data) {

        HashMap user = new HashMap();
        user.put("Patient_Name",Patientname);
        user.put("Inj_Place",Injuryplace);
        user.put("Inj_Des",Injurydes);
        user.put("Calender",Calender);
        user.put("Date",data);


        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        databaseReference.child(mAuth.getUid()).updateChildren(user).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {

                if (task.isSuccessful()){

                }

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        item = date1.getSelectedItem().toString();
        data.setText(item);


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}