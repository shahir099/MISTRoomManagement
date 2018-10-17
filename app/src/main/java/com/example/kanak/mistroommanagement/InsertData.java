package com.example.kanak.mistroommanagement;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.kanak.mistroommanagement.adapter.AdapterOfSpinner;

import java.text.DecimalFormat;
import java.util.ArrayList;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;

public class InsertData extends AppCompatActivity {

    Spinner spinnerCode,spinnerRoom,spinnerDay,spinnerPeroid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

        spinnerCode=findViewById(R.id.spnSubjectCode);
        spinnerDay=findViewById(R.id.spDay);
        spinnerRoom=findViewById(R.id.spRoom);
        spinnerPeroid=findViewById(R.id.spPeroid);

        ArrayList<String> lengthArray = new ArrayList<String>();
        ArrayList<String> dayArray = new ArrayList<String>();
        ArrayList<String> roomArray = new ArrayList<String>();
        ArrayList<String> peroidArray = new ArrayList<String>();

        lengthArray.add("CSE 313");
        lengthArray.add("CSE 319");
        lengthArray.add("CSE 311");
        lengthArray.add("CSE 317");
        lengthArray.add("CSE 313");

        AdapterOfSpinner as=new AdapterOfSpinner(InsertData.this,lengthArray);
        spinnerCode.setAdapter(as);

        dayArray.add("Sun");
        dayArray.add("Mon");
        dayArray.add("Tue");
        dayArray.add("Wed");
        dayArray.add("Thu");

        AdapterOfSpinner as1=new AdapterOfSpinner(InsertData.this,dayArray);
        spinnerDay.setAdapter(as1);

        peroidArray.add("08:00-08:55");
        peroidArray.add("09:00-09:55");
        peroidArray.add("10:00-10:55");
        peroidArray.add("11:45-12:40");
        peroidArray.add("12:45-13:40");
        peroidArray.add("13:45-14:40");


        AdapterOfSpinner as2=new AdapterOfSpinner(InsertData.this,peroidArray);
        spinnerPeroid.setAdapter(as2);

        roomArray.add("501");
        roomArray.add("502");
        roomArray.add("503");
        roomArray.add("504");

        AdapterOfSpinner as3=new AdapterOfSpinner(InsertData.this,roomArray);
        spinnerRoom.setAdapter(as3);









    }






}


