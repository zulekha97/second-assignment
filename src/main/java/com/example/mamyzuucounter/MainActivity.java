package com.example.mamyzuucounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text;
    Button counter;
    RadioButton Cup, Cdown;
   private int count =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text =(TextView)findViewById(R.id.txt);
        counter = (Button)findViewById(R.id.btn1);
        Cup =(RadioButton)findViewById(R.id.Cup);
        Cdown =(RadioButton)findViewById(R.id.C_down);


        counter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Cdown.isChecked()){
                    Toast.makeText(getApplicationContext(),"You are counting down the number",Toast.LENGTH_LONG).show();
                    count--;
                }else{
                if (Cup.isChecked()){
                    Toast.makeText(getApplicationContext(),"You are counting up the number",Toast.LENGTH_LONG).show();
                    count++;
                }

                }
                text.setText(String.valueOf(count));
            }
        });

    }
}
