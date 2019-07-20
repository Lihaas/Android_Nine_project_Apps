package com.stwalkerster.android.apps.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        WebView web = findViewById(R.id.webV);
        String url = getIntent().getStringExtra("url");
        web.setWebViewClient(new WebViewClient());
        web.loadUrl(url);
        web.getSettings().setJavaScriptEnabled(true);





    }
}
