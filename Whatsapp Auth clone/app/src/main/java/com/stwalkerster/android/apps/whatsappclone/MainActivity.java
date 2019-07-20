package com.stwalkerster.android.apps.whatsappclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
Spinner spin;
TextView countryCode;
EditText phoneNo;
Button button;
private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spin = findViewById(R.id.spinner);
        countryCode = findViewById(R.id.textView);
        phoneNo = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        mAuth = FirebaseAuth.getInstance();

        spin.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, CountryData.countryNames));

       spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               String s = CountryData.countryAreaCodes[spin.getSelectedItemPosition()];
               countryCode.setText(s);
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String code = CountryData.countryAreaCodes[spin.getSelectedItemPosition()];
                String number = phoneNo.getText().toString().trim();

                if(TextUtils.isEmpty(number)||number.length()<10||number.length()>10){
                    phoneNo.setError("Valid Number Required");
                    phoneNo.requestFocus();
                }
                 else {
                    String PhoneNo = "+" + code + number;

                    Intent i = new Intent(MainActivity.this, OtpMatch.class);
                    i.putExtra("Number", PhoneNo);

                    startActivity(i);
                }

            }
        });


    }



}
