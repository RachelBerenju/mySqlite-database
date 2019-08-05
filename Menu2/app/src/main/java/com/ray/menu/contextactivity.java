package com.ray.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class contextactivity extends AppCompatActivity {

    ListView listView;
    String contacts[]={"Lucy","Ann","Mercy"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contextactivity);

        listView=(ListView)findViewById(R.id.lview);

        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contacts);

        listView.setAdapter(adapter);

        registerForContextMenu(listView);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);


        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        menu.setHeaderTitle("Select action to contacts");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.call){
            Toast.makeText(this, "Calling", Toast.LENGTH_SHORT).show();
        }else if (item.getItemId()==R.id.sms){
            Toast.makeText(this, "Sending message", Toast.LENGTH_SHORT).show();
        }else {
            return false;
        }
        return true;
    }
}
