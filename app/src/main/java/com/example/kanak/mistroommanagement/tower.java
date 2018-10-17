package com.example.kanak.mistroommanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tower extends AppCompatActivity {

    Button t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tower);

        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1=new Intent(getApplicationContext(),floor.class);
                startActivity(it1);
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it2=new Intent(getApplicationContext(),floor.class);
                startActivity(it2);
            }
        });


    }
}
