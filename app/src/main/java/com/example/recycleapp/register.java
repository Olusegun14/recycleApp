package com.example.recycleapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText password;
    Button submit;

    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.personName);
        email = findViewById(R.id.shareet);
        password = findViewById(R.id.password);
        submit = findViewById(R.id.login);
        auth = FirebaseAuth.getInstance();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registeruser();
            }
        });


    }

    private void registeruser() {
        String currentName;
        String currentEmail;
        String CurrentPassword;
        currentName = name.getText().toString();
        CurrentPassword = password.getText().toString();
        currentEmail = email.getText().toString();
        if(currentName.isEmpty())
        {
            name.setError("Name is required");
            name.requestFocus();
            return;
        }
        if(CurrentPassword.isEmpty())
        {
            password.setError("Password is required");
            password.requestFocus();
            return;
        }
        if(CurrentPassword.length() <5)
        {
            password.setError("Choose a better password");
            password.requestFocus();
            return;
        }
        if(currentEmail.isEmpty())
        {
            email.setError("Choose a better password");
            email.requestFocus();
            return;
        }

        auth.createUserWithEmailAndPassword(currentEmail,CurrentPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                    user user = new user(currentName,currentEmail);
                    FirebaseDatabase.getInstance().getReference("user")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(Task<Void> task) {
                            Toast.makeText(register.this,"Success",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(register.this,Login.class);
                            startActivity(intent);
                        }
                    });
                }
                else{
                    Toast.makeText(register.this,"Failed",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}