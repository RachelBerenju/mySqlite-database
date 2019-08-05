package com.ray.htmlsplashapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Thread splash = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2000);
                    Intent go = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(go);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        splash.start();
    }
}
