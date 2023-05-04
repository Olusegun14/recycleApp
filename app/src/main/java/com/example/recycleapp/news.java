package com.example.recycleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class news extends AppCompatActivity {


    RecyclerView recyclerView;
    ArrayList<model> models;
    FirebaseDatabase database;
    InfoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        recyclerView = findViewById(R.id.rec);
        models = new ArrayList<>();
        database = FirebaseDatabase.getInstance();
        database.getReference().child("info").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                models.clear();
                for (DataSnapshot snapshot1: snapshot.getChildren())
                {
                    model model = snapshot1.getValue(com.example.recycleapp.model.class);
                    models.add(model);
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

        adapter = new InfoAdapter(models, news.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}