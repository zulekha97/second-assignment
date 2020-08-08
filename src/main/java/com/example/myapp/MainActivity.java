package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText name, pass;
Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.userName);
        pass = (EditText) findViewById(R.id.passWord);
        login = (Button) findViewById(R.id.btn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getSharedPreferences("MyApp", Context.MODE_PRIVATE);
                //e.g 1

//                SharedPreferences.Editor editor = pref.edit();
//                editor.putString("username", name.getText().toString());
//                editor.putString("password", pass.getText().toString());
//                editor.commit();
//                editor.clear();

                // e.g 2

//                String user = pref.getString("name","");
//                String passWor = pref.getString("pass","");
//                if (user.equals("") || passWor.equals("")){
//                    Toast.makeText(getApplicationContext(),"Data not found",Toast.LENGTH_LONG).show();
//                }else
//                    Toast.makeText(getApplicationContext(), "Data saved successfully", Toast.LENGTH_LONG).show();
//                name.setText(user);
//                pass.setText(passWor);

                //e.g 3
                String user = name.getText().toString();
                String passWor = pass.getText().toString();
                SharedPreferences.Editor editor =pref.edit();
                if (user.equals("Zulekha") && passWor.equals("123")){
                    editor.putString("username",user);
                editor.putString("password",passWor);
                editor.commit();
                editor.clear();
                    Toast.makeText(getApplicationContext(),"login sucessfully",Toast.LENGTH_LONG).show();
                }else
                    Toast.makeText(getApplicationContext(), "invalid username or password", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), detail.class);
                startActivity(intent);
            }

        });

    }
}