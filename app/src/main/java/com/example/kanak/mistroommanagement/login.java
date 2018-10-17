package com.example.kanak.mistroommanagement;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {


    Button sin,sup,lin;
    LinearLayout loid,lopass;
    FirebaseAuth logauth;
    EditText idin,passin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        logauth=FirebaseAuth.getInstance();

        sin=findViewById(R.id.sin);
        sup=findViewById(R.id.sup);
        loid=(LinearLayout) findViewById(R.id.loid);
        lopass=(LinearLayout) findViewById(R.id.lopass);
        lin=findViewById(R.id.lin);

        idin=findViewById(R.id.idin);
        passin=findViewById(R.id.passin);




        lin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String email,password;
                email="U-"+idin.getText().toString()+"@gmail.com";
                password=passin.getText().toString();


                logauth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    Intent success=new Intent(getApplicationContext(),tower.class);
                                    startActivity(success);
                                    Toast.makeText(login.this, "Login Successful",
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(login.this, "Login failed. Please give correct infomation ",
                                            Toast.LENGTH_SHORT).show();

                                }

                                // ...
                            }
                        });


            }
        });

        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itreg=new Intent(getApplicationContext(), Registration.class);
                startActivity(itreg);
            }
        });


        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sin.setVisibility(View.INVISIBLE);
                sup.setVisibility(View.INVISIBLE);
                loid.setVisibility(View.VISIBLE);
                lopass.setVisibility(View.VISIBLE);
                lin.setVisibility(View.VISIBLE);
            }
        });

    }
}
