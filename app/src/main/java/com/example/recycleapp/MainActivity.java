package com.example.recycleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;
    AutoCompleteTextView tv;
    ArrayAdapter adapter;
    Button button;
    StringRequest request;
    Button buttons;
    TextView itemname, itemdescription, itemstatus;
    public final static String URLS = "http://192.168.83.81/project/abc.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.autoCompleteTextView);

        button = findViewById(R.id.button);
        buttons = findViewById(R.id.button2);

        itemname = findViewById(R.id.itemNamevalue);
        itemstatus = findViewById(R.id.isrec);
        itemdescription = findViewById(R.id.finaldescription);

        Toast.makeText(MainActivity.this,"sjdhs sdsd sd",Toast.LENGTH_LONG).show();

        String[] item = getResources().getStringArray(R.array.list);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, item);
        tv.setAdapter(adapter);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        buttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Game.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              //  Toast.makeText(MainActivity.this,"dddd",Toast.LENGTH_LONG).show();
                getData(tv.getText().toString());
            }
        });



        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.sharenow:
                       Intent intent = new Intent(MainActivity.this, share.class);
                       startActivity(intent);
                        break;
                    case R.id.update:
                        Intent intents = new Intent(MainActivity.this, news.class);
                        startActivity(intents);
                        break;
                }
            }
        });
    }

    public void getData(final String item) {


        StringRequest requests = new StringRequest(Request.Method.POST, URLS, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {



              //  Toast.makeText(MainActivity.this,response.toString(),Toast.LENGTH_LONG).show();
                String[] all = response.split(",");
                Toast.makeText(MainActivity.this,all[0],Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this,all[1],Toast.LENGTH_LONG).show();


                String stats = all[0];
                if(stats.equals("0"))
                {
                    itemstatus.setText("No");
                }
                if(stats.equals("1"))
                {
                    itemstatus.setText("Yes");
                }

                itemname.setText(item.toString());
                itemdescription.setText(all[1]);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
               // button.setText(error.getMessage());
              //  Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this,error.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("item",item);

                return  map;
            }

        };



        Singleton.getInstance(getApplicationContext()).addToRequestQueue(requests);

}}