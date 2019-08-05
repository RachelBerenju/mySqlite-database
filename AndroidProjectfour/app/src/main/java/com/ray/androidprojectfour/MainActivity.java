package com.ray.androidprojectfour;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView salamu;
    Button sajili,ingia;
    ImageView pichayetu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        salamu = findViewById(R.id.tvTitle);
        sajili = findViewById(R.id.btnreg);
        ingia = findViewById(R.id.btnlog);
        pichayetu = findViewById(R.id.imgkenya);

        salamu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "This item has been clicked", Toast.LENGTH_SHORT).show();
            }
        });
        sajili.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button register has been clicked", Toast.LENGTH_SHORT).show();
            }
        });
        ingia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button login has been clicked", Toast.LENGTH_SHORT).show();
            }
        });
        pichayetu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Image Kenya has been clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
