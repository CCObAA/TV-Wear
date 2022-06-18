package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ListView lst;
    String obj,obj1;
    String [] devices = {"Лист1", "Лист22", "Лист333", "Лист4444"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lst = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_multiple_choice,devices
        );
        lst.setAdapter(adapter);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                obj = "";
                obj1 = "";
                SparseBooleanArray chosen = ((ListView) adapterView).getCheckedItemPositions();
                for (int ad = 0; ad < chosen.size(); ad++) {
                    if (chosen.valueAt(ad)) {
                        obj = (devices[chosen.keyAt(ad)] + " ");
                        obj1 += obj + " ";
                    }
                }
                Toast.makeText(getApplicationContext(),obj1, Toast.LENGTH_LONG).show();

            }
        });
    }}
