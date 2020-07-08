package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button1;
    EditText txt;
    String msg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.btn1);



//        Toast.makeText(
//                getApplicationContext(),"welcome",Toast.LENGTH_LONG
//        ).show();

    }
    public void onClickButton(View v){
        Intent i = new Intent(this,send.class);
        startActivity(i);
    }
//        txt1 =(EditText)findViewById(R.id.txt1);
//        button1 =(Button) findViewById(R.id.btn1);
//        button1.setOnClickListener(new onClickListener(){
//
//        });


        @Override
        public void onStart(){
            super.onStart();
            Toast.makeText(getApplicationContext(),"onStart()",Toast.LENGTH_LONG).show();
        }
        @Override
        public void onResume(){
            super.onResume();
            Toast.makeText(getApplicationContext(),"onResume()",Toast.LENGTH_LONG).show();
        }
        @Override
        public void onPause(){
            super.onPause();
            Toast.makeText(getApplicationContext(),"onPause()",Toast.LENGTH_LONG).show();
        }
        @Override
        public void onStop(){
            super.onStop();
            Toast.makeText(getApplicationContext(),"onStop()",Toast.LENGTH_LONG).show();
        }
        @Override
        public void onDestroy() {
            super.onDestroy();
            Toast.makeText(getApplicationContext(),"onDistroy()",Toast.LENGTH_LONG).show();
        }
    }

