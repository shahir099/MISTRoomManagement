package com.example.kanak.mistroommanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class room_info extends AppCompatActivity {

    TextView roomno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_info);


        roomno=findViewById(R.id.rmno);

        Intent i=getIntent();
        String rmno=i.getStringExtra("value");
        roomno.setText("ROOM "+rmno);

    }
}
