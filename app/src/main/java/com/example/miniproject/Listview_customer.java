package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Listview_customer extends AppCompatActivity {


    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_customer);
        listview = (ListView) findViewById(R.id.list);

        final ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Samarth Mess");
        arrayList.add("Vignahartha Mess");
        arrayList.add("Sai Mess");
        arrayList.add("Sukhakarta Mess");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        listview.setAdapter(arrayAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Listview_customer.this, +i + "" + arrayList.get(i).toString(), Toast.LENGTH_SHORT).show();
                Intent i1 = new Intent(getApplicationContext(), New.class);
                startActivity(i1);

            }
        });


    }
}