package com.stwalkerster.android.apps.burger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
RatingBar bar;
Button buy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

   bar = findViewById(R.id.rate);
   buy = findViewById(R.id.buy);

   bar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
       @Override
       public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
           Toast.makeText(MainActivity.this, ""+v, Toast.LENGTH_SHORT).show();
       }
   });


   buy.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           Intent i = new Intent(MainActivity.this,rate.class);
           float f = bar.getRating();
           i.putExtra("Rate",f);
           startActivity(i);
       }
   });

    }




}
