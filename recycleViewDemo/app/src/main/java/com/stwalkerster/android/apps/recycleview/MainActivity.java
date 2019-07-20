package com.stwalkerster.android.apps.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycle);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String car[] = {"Ferari","Lamborghini","kljdlkjs","lskdjklajsd","sjkhdkah","jkshdak","ok","hogya","jkhdksjh","sjdjkshd","hoo"};
        recyclerView.setAdapter(new CarAdapter(car));

    }
}
