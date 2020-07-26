package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class registration_info extends AppCompatActivity {
    EditText reg_no,address,phone,name,courses;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_info);
        reg_no =(EditText)findViewById(R.id.reg_no);
       address =(EditText)findViewById(R.id.address);
       phone =(EditText)findViewById(R.id.phone);
        name =(EditText)findViewById(R.id.user);
        courses =(EditText)findViewById(R.id.course);
        pref = getSharedPreferences("user_details",MODE_PRIVATE);
        reg_no.setText("Registration number:"+pref.getString("registration number",null));
       address.setText("Address:"+pref.getString("address",null));
        name.setText("Full name:"+pref.getString("username",null));
        phone.setText("Phone number:"+pref.getString("phone",null));
        courses.setText("Course:"+pref.getString("course",null));


    }
}