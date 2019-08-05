package com.fwbananas.morningfirebaseproject;

//CustomAdapter
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
    ArrayList<User> data;//modify here

    public CustomAdapter(Context mContext, ArrayList<User> data) {
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
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            viewHolder.tvEmail = (TextView) convertView.findViewById(R.id.tvMail);
            viewHolder.tvId = (TextView) convertView.findViewById(R.id.tvId);
            viewHolder.mBtnDelete = convertView.findViewById(R.id.btnDelete);
            //Up to here
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //MODIFY THIS BLOCK OF CODE
        final User person = data.get(position);//modify here
        viewHolder.tvName.setText(person.getName());//modify here
        viewHolder.tvEmail.setText(person.getEmail());//modify here
        viewHolder.tvId.setText(person.getIdNo());//modify here
        viewHolder.mBtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("Deleting");
                builder.setMessage("Are you sure you want to delete "+person.getName()+"?");
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(mContext, "Deletion cancelled", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("users/"+person.getKey());
                        ref.removeValue();
                        Toast.makeText(mContext, person.getName()+"Deleted Successfully", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create().show();
            }
        });
        return convertView;

    }
    static class ViewHolder {
        TextView tvName;
        TextView tvEmail;
        TextView tvId;
        Button mBtnDelete;

    }

}
