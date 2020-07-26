package com.example.labone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class detail extends AppCompatActivity {
    TextView diplaytextView;
    Button logout;
    SharedPreferences prf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        diplaytextView = (TextView) findViewById(R.id.display);

        logout = (Button)findViewById(R.id.btnlogout);
        final SharedPreferences prf = getSharedPreferences("user_details", MODE_PRIVATE);
        final Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        diplaytextView.setText("Welcome, "+prf.getString("username",null)+prf.getString("roles",null));
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = prf.edit();
                editor.clear();
                editor.commit();
                startActivity(intent);
            }
        });

    }
}