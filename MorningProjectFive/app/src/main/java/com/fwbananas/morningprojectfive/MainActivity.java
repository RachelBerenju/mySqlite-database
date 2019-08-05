package com.fwbananas.morningprojectfive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mButton1,mButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton1 = findViewById(R.id.btnOne);
        mButton2 = findViewById(R.id.btnTwo);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sajili = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(sajili);
            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ingia = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(ingia);
            }
        });
    }
}
