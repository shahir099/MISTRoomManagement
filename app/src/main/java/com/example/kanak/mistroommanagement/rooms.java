package com.example.kanak.mistroommanagement;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kanak.mistroommanagement.Database.DBHelper;
import com.example.kanak.mistroommanagement.model.Routine;

public class rooms extends AppCompatActivity {

    Button r1,r2,r3,r4, room1,room2,room3,room4;
    int flag1=0,flag2=0,flag3=0,flag4=0;
    Button btnRoutine;
    DBHelper db;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);

        context=this;

        btnRoutine= findViewById(R.id.btnRoutine);
        db=new DBHelper(context);

        Intent i=getIntent();
        String rmno=i.getStringExtra("value");
        //char flrN=rmno.charAt(0);
        char flrN='2';


        r1=findViewById(R.id.r1);
        r2=findViewById(R.id.r2);
        r3=findViewById(R.id.r3);
        r4=findViewById(R.id.r4);

        r1.setText(flrN+"01");
        r2.setText(flrN+"02");
        r3.setText(flrN+"03");
        r4.setText(flrN+"04");

        room1=findViewById(R.id.c1);
        room2=findViewById(R.id.c2);
        room3=findViewById(R.id.c3);
        room4=findViewById(R.id.c4);



        btnRoutine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateData();
            }
        });

        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String rm1;
                rm1=r1.getText().toString();
                Intent itflr=new Intent(getApplicationContext(),room_info.class);
                itflr.putExtra("value",rm1);
                startActivity(itflr);
            }
        });


        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String rm1;
                rm1=r2.getText().toString();
                Intent itflr=new Intent(getApplicationContext(),room_info.class);
                itflr.putExtra("value",rm1);
                startActivity(itflr);
            }
        });


        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String rm1;
                rm1=r3.getText().toString();
                Intent itflr=new Intent(getApplicationContext(),room_info.class);
                itflr.putExtra("value",rm1);
                startActivity(itflr);
            }
        });


        r4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String rm1;
                rm1=r4.getText().toString();
                Intent itflr=new Intent(getApplicationContext(),room_info.class);
                itflr.putExtra("value",rm1);
                startActivity(itflr);
            }
        });



        room1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag1==1){
                    room1.setBackgroundColor(Color.RED);
                    flag1=0;
                }
                else{
                    room1.setBackgroundColor(Color.GREEN);
                    flag1=1;
                }



            }
        });

        room2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag2==1){
                    room2.setBackgroundColor(Color.RED);
                    flag2=0;
                }
                else{
                    room2.setBackgroundColor(Color.GREEN);
                    flag2=1;
                }



            }
        });

        room3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag3==1){
                    room3.setBackgroundColor(Color.RED);
                    flag3=0;
                }
                else{
                    room3.setBackgroundColor(Color.GREEN);
                    flag3=1;
                }



            }
        });

        room4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag4==1){
                    room4.setBackgroundColor(Color.RED);
                    flag4=0;
                }
                else{
                    room4.setBackgroundColor(Color.GREEN);
                    flag4=1;
                }



            }
        });


    }

    private void validateData() {
        String roomNo,period,subject,code,day;
        roomNo="504";
        period="2";
        subject="CSE";
        code= "305";
        day="2";

            // Toast.makeText(context,c,Toast.LENGTH_LONG).show();
            Routine p=new Routine();
            p.setRoomNo(roomNo);
            p.setPeriod(period);
            p.setSubject(subject);
            p.setCode(code);
            p.setDay(day);


            if (db.insertIntoRoutine(p)){
                Toast.makeText(context,"Added success",Toast.LENGTH_SHORT).show();

                /*fName.setText("");
                lName.setText("");
                mobile.setText("");

                recyclerView.setAdapter(pa);*/

                /*Intent in = new Intent(context,MainActivity.class);
                context.startActivity(in);
                finish();*/

            }else{
                Toast.makeText(context,"Update success",Toast.LENGTH_SHORT).show();
                /*fName.setText("");
                lName.setText("");
                mobile.setText("");
                recyclerView.setAdapter(pa);
                Intent in = new Intent(context,MainActivity.class);
                context.startActivity(in);
                finish();*/
            }

    }




}


