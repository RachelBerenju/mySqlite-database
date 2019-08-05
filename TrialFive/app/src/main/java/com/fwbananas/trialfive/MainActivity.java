package com.fwbananas.trialfive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button Avitamin,Bvitamin,Cvitamin,Dvitamin,Kvitamin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitaminc);
        Avitamin = findViewById(R.id.btnA);
        Bvitamin = findViewById(R.id.btnB);
        Cvitamin = findViewById(R.id.btnC);
        Dvitamin = findViewById(R.id.btnD);
        Kvitamin = findViewById(R.id.btnK);
        Avitamin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this,VitaminaActivity.class);
                startActivity(a);
            }
        });
        Bvitamin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(MainActivity.this,VitaminbActivity.class);
                startActivity(b);
            }
        });
        Cvitamin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(MainActivity.this,VitamincActivity.class);
                startActivity(c);
            }
        });
        Dvitamin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(MainActivity.this,VitamindActivity.class);
                startActivity(d);
            }
        });
        Kvitamin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(MainActivity.this,VitaminkActivity.class);
                startActivity(k);
            }
        });
    }
}
