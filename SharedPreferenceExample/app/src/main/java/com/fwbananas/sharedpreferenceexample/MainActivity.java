package com.fwbananas.sharedpreferenceexample;

import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;
    Button mRed,mGreen,mYellow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = findViewById(R.id.tbone);
        mRed = findViewById(R.id.btnRed);
        mGreen = findViewById(R.id.btnGreen);
        mYellow = findViewById(R.id.btnYellow);

        if (getColor() != getResources().getColor(R.color.colorPrimary)){
            mToolbar.setBackgroundColor(getColor());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(getColor());
            }
        }

        mRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mToolbar.setBackgroundColor(getResources().getColor(R.color.colorRed));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.colorRed));
                }
                storecolor(getResources().getColor(R.color.colorRed));
            }
        });
        mGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mToolbar.setBackgroundColor(getResources().getColor(R.color.colorGreen));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.colorGreen));
                }
                storecolor(getResources().getColor(R.color.colorGreen));
            }
        });
        mYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mToolbar.setBackgroundColor(getResources().getColor(R.color.colorYellow));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.colorYellow));
                }
                storecolor(getResources().getColor(R.color.colorYellow));
            }
        });
    }

    private void storecolor(int color){
        SharedPreferences mSharedPrefences = getSharedPreferences("ToolbarColor",MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSharedPrefences.edit();
        mEditor.putInt("color",color);
        mEditor.apply();
    }

    private int getColor(){
        SharedPreferences mSharedPrefences = getSharedPreferences("ToolbarColor",MODE_PRIVATE);
        int selectedColor = mSharedPrefences.getInt("color",getResources().getColor(R.color.colorPrimary));
        return selectedColor;
    }
}
