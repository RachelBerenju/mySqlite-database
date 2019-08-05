package com.example.mysqlitedatabaseapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText mfname,mlname,mid;
    Button msave,mview,mdelete;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mfname = findViewById(R.id.edtfname);
        mlname = findViewById(R.id.edtlname);
        mid = findViewById(R.id.edtid);
        msave = findViewById(R.id.btnsave);
        mview = findViewById(R.id.btnview);
        mdelete = findViewById(R.id.btndelete);

        //Create database

        db = openOrCreateDatabase("huduma",MODE_PRIVATE,null);

        //Create a table in your database

        db.execSQL("CREATE TABLE IF NOT EXISTS citizens(first_name VARCHAR,last_name VARCHAR,id_number INTEGER)");

            msave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Get the data from the user
                    String firstname = mfname.getText().toString();
                    String lastname = mlname.getText().toString();
                    String idnumber = mid.getText().toString();

                  //Check if the user is attempting to submit empty fields

                  if (firstname.isEmpty()){
                      messages("First name error","Please enter first name");
                  }else if (lastname.isEmpty()){
                      messages("Last name error", "Please enter last name");
                  }else if (idnumber.isEmpty()){
                      messages("ID number error","Please enter ID number");
                  }else {
                      //Proceed to save your received data into your db called huduma
                      //Insert data the db using an Insert Query

                      db.execSQL("INSERT INTO citizens VALUES('"+firstname+"','"+lastname+"','"+idnumber+"')");
                      messages("SUCCESS","User saved successfully");

                      //Clear input fields for the next entry
                      mfname.setText("");
                      mlname.setText("");
                      mid.setText("");
                  }
                }
            });


            mview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Use a cursor to query and select data from your db table
                    Cursor cursor = db.rawQuery("SELECT * FROM citizens",null);

                    //Check if the cursor found any data in the db
                    if (cursor.getCount()== 0){
                        messages("Empty Database","Sorry, no data was found");
                    }else{
                        //Proceed to display the selected data
                        //User the String Buffer to append and display the records

                        StringBuffer buffer = new StringBuffer();

                        //Loop through the selected data that is on your cursor to display
                        while (cursor.moveToNext()){
                            buffer.append(cursor.getString(0)+"\t");//Zero is a column for fname
                            buffer.append(cursor.getString(1)+"\t");//One is a column for lname
                            buffer.append(cursor.getString(2)+"\n");//Two is a column for idno
                        }

                        //Display your data using the string buffer on the sttring dialog
                        messages("DATABASE RECORDS",buffer.toString());
                    }
                }
            });
            mdelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Get the ID to use a unique identifier to delete any row
                    String id = mid.getText().toString().trim();
                    //Check if the user deleting with an empty field
                    if (id.isEmpty()){
                        messages("ID Error","Please enter the ID number");
                    }else {
                        Cursor cursor = db.rawQuery("SELECT * FROM citizens WHERE id_number = '"+id+"'",null);
                        //proceed to delete
                        if (cursor.moveToFirst()){

                            db.execSQL("DELETE FROM citizens WHERE  id_number='"+id+"'");
                            mid.setText("");
                            messages("SUCCESS","User deleted successfully");
                            mid.setText("");

                        }

                    }
                }
            });

    }

    //Message display function

    public void messages(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.create().show();
    }
}
