package com.stwalkerster.android.apps.burger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class rate extends AppCompatActivity {
TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

            txt = findViewById(R.id.txt);
            String i =getIntent().getStringExtra("Rate");
            txt.setText(i);

    }


}
