package com.fwbananas.morningprojectfiveb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SupplierActivity extends AppCompatActivity {
;
    Button mHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier);
        mHome = findViewById(R.id.btnHome);
        mHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rudi = new Intent(SupplierActivity.this,MainActivity.class);
                startActivity(rudi);
            }
        });
    }
}
