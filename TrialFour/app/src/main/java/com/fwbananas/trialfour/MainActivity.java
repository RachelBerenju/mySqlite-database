package com.fwbananas.trialfour;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView banana;
    ImageView ndizi;
    Button matoke,maembe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        banana = findViewById(R.id.tvOne);
        ndizi = findViewById(R.id.imgBanana);
        matoke = findViewById(R.id.btnOne);
        maembe =findViewById(R.id.btnTwo);
        banana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "FWbananas clicked", Toast.LENGTH_SHORT).show();
            }
        });
        ndizi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Ndizi clicked", Toast.LENGTH_SHORT).show();
            }
        });
        matoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Matoke clicked", Toast.LENGTH_SHORT).show();
            }
        });
        maembe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Maembe clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
