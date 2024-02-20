package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class demo extends AppCompatActivity {

    ListView listView;
    ArrayList<Ewaste> arrayList;
    ewasteAdapter ewasteAdapter;
    ewasteHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        db = new ewasteHelper(this);

        listView= findViewById(R.id.list_demo);

        arrayList= db.getAllEwaste();
        ewasteAdapter = new ewasteAdapter(demo.this,
                R.layout.row_demo,
                arrayList);

        listView.setAdapter(ewasteAdapter);

        //dang ky menu COntext cho listView
        registerForContextMenu(listView);

    }
}