package com.stwalkerster.android.apps.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    b1 = findViewById(R.id.Hello);

    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(MainActivity.this,Main2Activity.class);
            i.putExtra("url","https://www.twitter.com");
            startActivity(i);
        }
    });
    }
}
