package com.fwbananas.morningprojectfiveb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mCustomer,mSupplier;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCustomer = findViewById(R.id.btnCustomer);
        mSupplier = findViewById(R.id.btnSupplier);
        mCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cus = new Intent(MainActivity.this,CustomerActivity.class);
                startActivity(cus);
            }
        });
        mSupplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sup = new Intent(MainActivity.this,SupplierActivity.class);
                startActivity(sup);
            }
        });
    }
}
