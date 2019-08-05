package com.fwbananas.morningprojectsevenb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_activity);
        Thread splash = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2000);
                    Intent go = new Intent(getApplicationContext(),MainActivity)
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }

        };
    }
}
