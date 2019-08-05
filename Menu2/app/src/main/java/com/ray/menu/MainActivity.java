package com.ray.menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button butonpop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butonpop=(Button)findViewById(R.id.btnpop);

    }
    public void clickPop(View view) {

        PopupMenu popupmenu=new PopupMenu(MainActivity.this,butonpop);

        popupmenu.getMenuInflater().inflate(R.menu.popup_menu,popupmenu.getMenu());

        popupmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(MainActivity.this, "You clicked"+item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        popupmenu.show();
    }

    public void buttonnext(View view) {
       startActivity(new Intent(MainActivity.this,contextactivity.class));
    }
}
