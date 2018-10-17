package com.example.kanak.mistroommanagement;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5;
    Spinner dpt;
    RadioGroup gen;
    RadioButton gg;
    Button reg,back;
    FirebaseAuth ath;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //Firebase
        ath=FirebaseAuth.getInstance();
        ref=FirebaseDatabase.getInstance().getReference("Users");

        //serial data for user class
 //       e1=findViewById(R.id.mailreg);
        e2=findViewById(R.id.emsidreg);
        dpt=findViewById(R.id.deptreg);
        e3=findViewById(R.id.namereg);
        e4=findViewById(R.id.cellreg);
        gen=findViewById(R.id.genreg);
        e5=findViewById(R.id.passreg);

        //buttons
        back=findViewById(R.id.backreg);
        reg=findViewById(R.id.supreg);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backreg=new Intent(getApplicationContext(),login.class);
                startActivity(backreg);
            }
        });


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String mail,ems,dept,name,phone,gend,pass;
                int genindex;


                ems="U-"+e2.getText().toString();
                mail=ems+"@gmail.com";
                //spinner
                dept=dpt.getSelectedItem().toString();

                name=e3.getText().toString();
                phone=e4.getText().toString();
                //Radio
                genindex=gen.getCheckedRadioButtonId();
                gg=findViewById(genindex);
                gend=gg.getText().toString();

                pass=e5.getText().toString();


                ath.createUserWithEmailAndPassword(mail, pass)
                        .addOnCompleteListener(Registration.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Registry_Information r1=new Registry_Information(mail,ems,dept,name,phone,gend,pass);
                                    ref.push().setValue(r1);
                                    Toast.makeText(Registration.this, "Authentication Successful",
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Registration.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    }

                                // ...
                            }
                        });



            }
        });



    }
}
