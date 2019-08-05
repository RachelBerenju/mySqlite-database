package com.fwbananas.morningprojectfourb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView picha;
    TextView salamu;
    Button niguse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        picha = findViewById(R.id.imgPicha);
        salamu = findViewById(R.id.tvTitle);
        niguse = findViewById(R.id.btnOne);
        picha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Picha clicked", Toast.LENGTH_SHORT).show();
            }
        });
        salamu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Salamu clicked", Toast.LENGTH_SHORT).show();
            }
        });
        niguse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Umenigusa", Toast.LENGTH_LONG).show();
            }
        });
    }
}
