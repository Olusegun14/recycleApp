package com.example.recycleapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText email;
    EditText password;
    Button submit;
    FirebaseAuth auth;
    Button regis;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.shareet);
        password = findViewById(R.id.password);
        submit = findViewById(R.id.login);
        regis = findViewById(R.id.reister);
        button = findViewById(R.id.tt);
        String x="0some";

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Login.this,Integer.parseInt(x),Toast.LENGTH_LONG).show();

            }
        });

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Login.this, register.class);
                startActivity(intent);


            }
        });

        auth = FirebaseAuth.getInstance();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoggedIn();

            }
        });
    }



    private void LoggedIn()
    {
        String currentEmail = email.getText().toString();
        String currentPass = password.getText().toString();
        if(currentEmail.isEmpty())
        {
            email.setError("Required");
            email.requestFocus();
            return;
        }
        if(currentPass.isEmpty())
        {
            password.setError("Required");
            password.requestFocus();
            return;
        }
        auth.signInWithEmailAndPassword(currentEmail,currentPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete( Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                }


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure( Exception e) {
                Toast.makeText(Login.this,"No user Found",Toast.LENGTH_LONG).show();
            }
        });
    }
}