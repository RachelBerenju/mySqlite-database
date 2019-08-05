package com.fwbananas.morningsqliteproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText mName,mEmail,mId;
    Button mBtnSave,mBtnView,mBtnDelete;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mName = findViewById(R.id.edtName);
        mEmail = findViewById(R.id.edtMail);
        mId = findViewById(R.id.edtId);
        mBtnSave = findViewById(R.id.btnSave);
        mBtnDelete = findViewById(R.id.btnDelete);
        mBtnView = findViewById(R.id.btnView);
        db = openOrCreateDatabase("voterDb",MODE_PRIVATE,null);
        //Query to Create a table
        db.execSQL("CREATE TABLE IF NOT EXISTS voterreg(Name VARCHAR, Email VARCHAR, IdNo VARCHAR)");
        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Check if the user has filled in all records
                String Name = mName.getText().toString();
                String Email = mEmail.getText().toString();
                String ID = mId.getText().toString().trim();
                if (Name.isEmpty()){
                    messageDisplay("NAME ERROR","Kindly fill in your Name");
                }else if (Email.isEmpty()){
                    messageDisplay("EMAIL ERROR","Kindly fill in your Email");
                }else  if (ID.isEmpty()){
                    messageDisplay("ID ERROR","Kindly fill in your ID");
                }else {
                    //Query to insert into the DB
                    db.execSQL("INSERT INTO voterreg VALUES('"+Name+"','"+Email+"','"+ID+"')");
                    messageDisplay("QUERY SUCCESS","Data Saved Successfully");
                    clear();
                }
            }
        });
        mBtnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Querty to view DB records
                Cursor cursor = db.rawQuery("SELECT * FROM voterreg",null);
                //Check if there is any records
                if (cursor.getCount()==0){
                    messageDisplay("NO RECORDS","Sorry no records were found");
                }
                //Use buffer to append the records
                StringBuffer buffer = new StringBuffer();
                while (cursor.moveToNext()){
                    buffer.append("\n"+cursor.getString(0));
                    buffer.append("\t"+cursor.getString(1));
                    buffer.append("\t"+cursor.getString(2));
                    buffer.append("\n");
                }
                messageDisplay("DATABASE RECORDS",buffer.toString());
            }
        });
        mBtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //Check id someone has not entred the ID
                String ID = mId.getText().toString().trim();
                if (ID.isEmpty()){
                    messageDisplay("ID ERROR","KIndly fill in the ID");
                }else {
                    Cursor cursor = db.rawQuery("SELECT * FROM voterreg WHERE IdNo = '"+ID+"'",null);
                    if (cursor.moveToFirst()){
                        db.execSQL("DELETE FROM voterreg WHERE IdNo = '"+ID+"'");
                        messageDisplay("DELETED","Reord deleted successfully");
                        clear();
                    }
                }
            }
        });
    }
    //Message display function

    private  void messageDisplay(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.create().show();
    }
    //Clear the EditText after saving
    public void clear(){
        mName.setText("");
        mEmail.setText("");
        mId.setText("");
    }
}

