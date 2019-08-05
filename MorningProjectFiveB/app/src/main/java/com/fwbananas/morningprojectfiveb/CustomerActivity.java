package com.fwbananas.morningprojectfiveb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CustomerActivity extends AppCompatActivity {

    Button mBack;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        mBack = findViewById(R.id.btnMain);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rudi = new Intent(CustomerActivity.this,MainActivity.class);
                startActivity(rudi);
            }
        });
    }
}
