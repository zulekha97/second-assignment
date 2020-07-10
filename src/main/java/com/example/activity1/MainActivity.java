package com.example.activity1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    TextView ToggleTV;
    TextView SpinnerTV;
    TextView CheckBoxTV;
    TextView TimePickerTV;
    TextView DatePickerTV;
    Spinner spinner;
    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                    //Two array Butterknife
                ButterKnife.bind(this);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.example_array, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            /**
             * Toggle Button State Listener
             * isChecked is the state of the button
             */
            public void OnCheckedChanged(boolean isChecked) {
                if(isChecked){
                    // code to execute when the button is clicked to ON
                    ToggleTV.setText(R.string.the_button_is_on);
                }else {
                    // code to execute when the button is clicked to OFF
                    ToggleTV.setText(R.string.the_button_is_off);
                }
            }
            //error
//            public void OnItemSelected(int position){
//                SpinnerTV.setText(getString(R.string.item_selected,spinner.getItemAtPosition(position)));
//            }
            public void OnClick(View view){
                switch (view.getId()){
                    case R.id.button:
                        showTimePicker();
                        break;
                    case R.id.button2:
                        showDatePicker();
                        break;
                    case R.id.checkBox:
                        checkCheckBox();
                        break;
                }
            }

            private void checkCheckBox() {
                if(checkBox.isChecked())
                    CheckBoxTV.setText(R.string.checkbox_checked);
                else
                    CheckBoxTV.setText(R.string.checkbox_unchecked);
            }

            private void showDatePicker() {
                Calendar mcurrentDate = Calendar.getInstance();
                int year = mcurrentDate.get(Calendar.YEAR);
                int month = mcurrentDate.get(Calendar.MONTH);
                int day = mcurrentDate.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog mDatePicker;
                mDatePicker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("StringFormatInvalid")
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        String d,m,y;
                        if(day<9)
                            d="0"+day;
                        else
                            d=""+day;
                        if(month<9)
                            m="0"+month;
                        else
                            m=""+month;
                        y=""+year;
                        DatePickerTV.setText(getString(R.string.selected_day,d,m,y));
                    }
                },year,month,day);
                mDatePicker.setTitle("Select Date");
                mDatePicker.show();
            }

            private void showTimePicker() {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @SuppressLint("StringFormatInvalid")
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String h = selectedHour + "";
                        String m = selectedMinute + "";
                        if (h.length() == 1) {
                            h = "0" + h;
                        }
                        if (m.length() == 1) {
                            m = "0" + m;
                        }
                        TimePickerTV.setText(getString(R.string.selected_time,h,m));
                    }
                }, hour, minute, true);//Yes 24 hour atime
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }


        }

