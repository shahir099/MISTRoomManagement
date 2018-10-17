package com.example.kanak.mistroommanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class floor extends AppCompatActivity {

    Spinner floor;
    Button goo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor);

        floor=findViewById(R.id.spinnertower);
        goo=findViewById(R.id.go);

        goo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String flr;
                flr=floor.getSelectedItem().toString();

                Intent itflr=new Intent(getApplicationContext(),rooms.class);
                itflr.putExtra("value",flr);
                startActivity(itflr);
                Toast.makeText(floor.this, flr,
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}
