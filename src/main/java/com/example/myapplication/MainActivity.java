package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    NavigationView navigationView;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.home) {
           Intent intent =new Intent(getApplicationContext(),home.class);
        }
        if (id == R.id.reg) {
        Intent intent =new Intent(getApplicationContext(),register.class);
        startActivity(intent);
        }
        if (id == R.id.view) {
        Intent intent =new Intent(getApplicationContext(),view.class);
        startActivity(intent);
        }

        if (id == R.id.reg_info) {
        Intent intent =new Intent(getApplicationContext(),registration_info.class);
        startActivity(intent);
        }

        if (id == R.id.Logout) {
            final Intent intent =new Intent(getApplicationContext(),MainActivity.class);
            Logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences.Editor editor = pref.edit();
                    editor.clear();
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
    }
}