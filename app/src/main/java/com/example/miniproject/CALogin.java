package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CALogin extends AppCompatActivity {
    Button lcustomer;
    Button ladmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calogin);
        lcustomer=(Button) findViewById(R.id.lcustomer);
        lcustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Login.class);
                startActivity(i);

            }
        });
        ladmin=(Button) findViewById(R.id.ladmin);
        ladmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Admin_Login.class);
                startActivity(i);

            }
        });

    }
}

