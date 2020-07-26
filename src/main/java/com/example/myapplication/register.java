package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button register =(Button)findViewById(R.id.register);
        final EditText name =(EditText)findViewById(R.id.user);
        final EditText reg_no =(EditText)findViewById(R.id.reg_no);
        final EditText add =(EditText)findViewById(R.id.address);
        final EditText number =(EditText)findViewById(R.id.phone);
        final EditText courses =(EditText)findViewById(R.id.course);


        final Intent intent = new Intent(getApplicationContext(), registration_info.class);
        if (pref.contains("username") && pref.contains("registration_no")) {
            startActivity(intent);
        }
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = name.getText().toString();
                String registration_no = reg_no.getText().toString();
                String address = add.getText().toString();
                String phone = number.getText().toString();
                String course = courses.getText().toString();
                if(username.equals("Zulekha") && registration_no.equals("BITA/2/18/020/TZ")){
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("username",username);
                    editor.putString("registration number",registration_no);
                    editor.commit();

                    if (address.equals("Mombasa") && phone.equals("+255-718-516-768")){
                        editor.putString("address",address);
                        editor.putString("phone",phone);
                        editor.commit();
                    }
                    if (courses.equals("ICT")){
                        editor.putString("course",course);
                    }
                    Toast.makeText(getApplicationContext(), "Registration Successful",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Credentials are not valid",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}