package com.fwbananas.morningprojectnineb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    ArrayList<Item> user;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = new ArrayList();
        adapter = new CustomAdapter(this,user);
        list = findViewById(R.id.listWatu);
        Item person = new Item("Ivan","0719187214",R.drawable.banana);
        Item person1 = new Item("King","0700112233",R.drawable.banana);
        Item person2 = new Item("Seffu","0701234567",R.drawable.banana);
        Item person3 = new Item("Nelly","0789456123",R.drawable.banana);
        Item person4 = new Item("Clare","0785236974",R.drawable.banana);
        Item person5 = new Item("John","0714785236",R.drawable.banana);
        Item person6 = new Item("Angie","0798745612",R.drawable.banana);
        Item person7 = new Item("Daisy","0765478932",R.drawable.banana);
        Item person8 = new Item("Stacy","0732789456",R.drawable.banana);
        Item person9 = new Item("Willy","0715975346",R.drawable.banana);
        Item person10 = new Item("Ian","0746798513",R.drawable.banana);
        user.add(person);
        user.add(person1);
        user.add(person2);
        user.add(person3);
        user.add(person4);
        user.add(person5);
        user.add(person6);
        user.add(person7);
        user.add(person8);
        user.add(person9);
        user.add(person10);

        list.setAdapter(adapter);
    }

}
