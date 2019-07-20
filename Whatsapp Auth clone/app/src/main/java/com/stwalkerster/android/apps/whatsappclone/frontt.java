package com.stwalkerster.android.apps.whatsappclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class frontt extends AppCompatActivity {
Button bun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frontt);

        bun = findViewById(R.id.b1);

        bun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(frontt.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
