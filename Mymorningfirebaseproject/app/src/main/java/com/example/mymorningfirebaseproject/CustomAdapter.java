package com.example.mymorningfirebaseproject;

//CustomAdapter
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CustomAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<item> data;//modify here

    public CustomAdapter(Context mContext, ArrayList<item> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();// # of items in your arraylist
    }
    @Override
    public Object getItem(int position) {
        return data.get(position);// get the actual item
    }
    @Override
    public long getItemId(int id) {
        return id;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(R.layout.item_layout, parent,false);//modify here
            viewHolder = new ViewHolder();
            //modify this block of code
            viewHolder.mname =  convertView.findViewById(R.id.tvname);
            viewHolder.mmail =  convertView.findViewById(R.id.tvmail);
            viewHolder.mpass =  convertView.findViewById(R.id.tvpass);
            viewHolder.mBtnDel = convertView.findViewById(R.id.btndel);
            //Up to here
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //MODIFY THIS BLOCK OF CODE
        final item person = data.get(position);//modify here
        viewHolder.mname.setText(person.getMname());//modify here
        viewHolder.mmail.setText(person.getMemail());//modify here
        viewHolder.mpass.setText(person.getMpass());//modify here
        viewHolder.mBtnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Users/"+person.getMid());
                ref.removeValue();
                Toast.makeText(mContext, "Deleted", Toast.LENGTH_SHORT).show();

            }
        });
        return convertView;

    }

    static class ViewHolder {
        TextView mname;
        TextView mmail;
        TextView mpass;//These don't have to be same names as the Id's
        //MODIFY THIS BLOCK OF CODE
        //TextView textViewTitle;
        Button mBtnDel;
    }

}