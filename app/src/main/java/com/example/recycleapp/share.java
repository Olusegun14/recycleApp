package com.example.recycleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class share extends AppCompatActivity {

    EditText editText;
    FirebaseAuth auth;
    FirebaseDatabase database;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        btn =  findViewById(R.id.postbutton);
        editText = findViewById(R.id.shareet);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentMessae  = editText.getText().toString();
                if(currentMessae == null)
                {
                    editText.setError("it is empty");
                    editText.requestFocus();
                    return;
                }

                Date date = new Date();

                model model = new model(FirebaseAuth.getInstance().getCurrentUser().getEmail(),"dssd",currentMessae);
                DatabaseReference reference = database.getReference("info")
                        .child(date.getTime()+"");
                reference.setValue(model);
                editText.setText("");
            }
        });


    }





}