package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class home extends AppCompatActivity {
    TextView home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        home =(TextView)findViewById(R.id.home);
        home.setText("you are in home page welcome");
    }
}