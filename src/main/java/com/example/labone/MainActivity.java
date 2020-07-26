package com.example.labone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    TextView username1,password1,role;
    Spinner spinner;
    Button login;


    String roles[] ={"Administrator","Normal user","Manager","Executive Director"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username1 =(TextView)findViewById(R.id.user);
        password1 =(TextView)findViewById(R.id.pass);
        username =(EditText)findViewById(R.id.editUser);
        password = (EditText)findViewById(R.id.editPass);
        spinner =(Spinner)findViewById(R.id.spinner);
        login =(Button)findViewById(R.id.loginbtn) ;
        role =(TextView)findViewById(R.id.role);

        Intent intent = new Intent(MainActivity.this, detail.class);
        ArrayAdapter <CharSequence> arrayAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.resource,R.layout.support_simple_spinner_dropdown_item);

              spinner.setAdapter(arrayAdapter);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = null;


                SharedPreferences pref;
                      pref  = getSharedPreferences("user_details", MODE_PRIVATE);

                if (pref.contains("username") && pref.contains("password")) {
                    startActivity(intent);
                }
                final SharedPreferences finalPref = pref;
                login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String user = username.getText().toString();
                        String pass = password.getText().toString();
                        String role = roles.toString();
                        if(username.equals("Zulekha") && password.equals("123")){
                            SharedPreferences.Editor editor = finalPref.edit();
                            editor.putString("username",user);
                            editor.putString("password",pass);
                            editor.putString("roles",role);
                            editor.commit();
                            Toast.makeText(getApplicationContext(), "Login Successful",Toast.LENGTH_LONG).show();
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Credentials are not valid",Toast.LENGTH_LONG).show();
                        }
                    }



});
    }
});
    }
    }