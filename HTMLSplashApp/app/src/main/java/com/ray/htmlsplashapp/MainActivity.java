package com.ray.htmlsplashapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    WebView pageyangu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pageyangu = findViewById(R.id.webyangu);
        WebSettings settings = pageyangu.getSettings();
        settings.setJavaScriptEnabled(true);
        //pageyangu.loadUrl("file:///android_asset/home.html");
        pageyangu.loadUrl("https://www.emobilis.ac.ke");
    }
}
