package com.fwbananas.afternoonproject9b;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    CustomAdapter adapter;
    ArrayList<Item>users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.listwatu);
        users =new ArrayList<>();
        adapter = new CustomAdapter(this,users);
        Item p= new Item("King","0761816911",R.drawable.kenya);
        Item p1= new Item("Sanny","0752516541",R.drawable.kenya);
        Item p2= new Item("Mimmie","0741458641",R.drawable.kenya);
        Item p3= new Item("Flavia","072189745",R.drawable.kenya);
        Item p4= new Item("Dan","070741915",R.drawable.kenya);
        Item p5= new Item("Steve","071879364",R.drawable.kenya);
        Item p6= new Item("David","0718748965",R.drawable.kenya);
        Item p7= new Item("Eric","07185298251",R.drawable.kenya);
        Item p8= new Item("Antony","071423697",R.drawable.kenya);
        Item p9= new Item("Edwin","073259874",R.drawable.kenya);
        Item p10= new Item("Evans","0714239775",R.drawable.kenya);
        Item p11= new Item("Abbie","07138527996",R.drawable.kenya);
        users.add(p);
        users.add(p1);
        users.add(p2);
        users.add(p3);
        users.add(p4);
        users.add(p5);
        users.add(p6);
        users.add(p7);
        users.add(p8);
        users.add(p9);
        users.add(p10);
        users.add(p11);

        list.setAdapter(adapter);
    }
}
