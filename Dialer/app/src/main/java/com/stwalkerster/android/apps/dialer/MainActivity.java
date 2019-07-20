package com.stwalkerster.android.apps.dialer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, bplus, bstar, bzero, dial, back, msg;
    TextView dialogBox;
    String a = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setId();

        if ((Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) && ((ContextCompat.checkSelfPermission
                (MainActivity.this, Manifest.permission.CALL_PHONE)) != PackageManager.PERMISSION_GRANTED)) {
            ActivityCompat.requestPermissions
                    (MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
        }
        if ((ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)
        ) == PackageManager.PERMISSION_DENIED) {
            this.finish();
        }
        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ss = a;
                String uri = "tel:" + ss;
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(uri));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    Activity#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for Activity#requestPermissions for more details.
                        return;
                    }
                }
                startActivity(intent);

            }
        });

        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = a;
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", number, null)));
            }
        });


    }

    public void setId() {
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        bplus = findViewById(R.id.bplus);
        bzero = findViewById(R.id.bzero);
        bstar = findViewById(R.id.bstar);
        dial = findViewById(R.id.dial);
        back = findViewById(R.id.back);
        msg = findViewById(R.id.msg);
        dialogBox = findViewById(R.id.dialog);
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void dos(View v) {
        switch (v.getId()) {
            case R.id.b1:
                dialogBox.setText(a + 1);
                a = a + 1;
                break;

            case R.id.b2:
                dialogBox.setText(a + 2);
                a = a + 2;
                break;

            case R.id.b3:
                dialogBox.setText(a + 3);
                a = a + 3;
                break;

            case R.id.b4:
                dialogBox.setText(a + 4);
                a = a + 4;
                break;

            case R.id.b5:
                dialogBox.setText(a + 5);
                a = a + 5;
                break;

            case R.id.b6:
                dialogBox.setText(a + 6);
                a = a + 6;
                break;

            case R.id.b7:
                dialogBox.setText(a + 7);
                a = a + 7;
                break;

            case R.id.b8:
                dialogBox.setText(a + 8);
                a = a + 8;
                break;

            case R.id.b9:
                dialogBox.setText(a + 9);
                a = a + 9;
                break;

            case R.id.bplus:
                dialogBox.setText(a + "+");
                a = a + "+";
                break;

            case R.id.back:
                if (a != null && a.length() > 0) {
                    a = a.substring(0, a.length() - 1);
                    dialogBox.setText(a);
                } else {
                    a = "";
                }
                break;

            case R.id.bzero:
                dialogBox.setText(a + 0);
                a = a + 0;
                break;

            case R.id.bstar:
                dialogBox.setText(a + "*");
                a = a + "*";
                break;






        }

    }
}
