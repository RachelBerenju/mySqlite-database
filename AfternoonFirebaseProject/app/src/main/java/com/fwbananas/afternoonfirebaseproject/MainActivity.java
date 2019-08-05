package com.fwbananas.afternoonfirebaseproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText mName, mEmail, mId;
    Button mBtnSave, mBtnView;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mName =findViewById(R.id.edtName);
        mEmail =findViewById(R.id.edtMail);
        mId =findViewById(R.id.edtId);
        mBtnSave =findViewById(R.id.btnSave);
        mBtnView =findViewById(R.id.btnView);

        dialog = new ProgressDialog(this);
        dialog.setTitle("Saving");
        dialog.setMessage("Please wait...");



        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create a table called Users
                long time = System.currentTimeMillis();
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Users/"+time);
                //Check if the user has entered all the details
                String name = mName.getText().toString();
                String email = mEmail.getText().toString();
                String id = mId.getText().toString().trim();
                if (name.isEmpty()||email.isEmpty()||id.isEmpty()){
                    Toast.makeText(MainActivity.this, "Fill in all inputs", Toast.LENGTH_SHORT).show();
                }else {
                    //Code to save into the DB
                    User mtu = new User(name,email,id,String.valueOf(time));
                    dialog.show();
                    ref.setValue(mtu).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            dialog.dismiss();
                            if (task.isSuccessful()){
                                Toast.makeText(MainActivity.this, "Saved Successfully", Toast.LENGTH_SHORT).show();
                                mName.setText("");
                                mEmail.setText("");
                                mId.setText("");
                            }else {
                                Toast.makeText(MainActivity.this, "Saving Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        mBtnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent  = new Intent(getApplicationContext(),UsersActivity.class);
                startActivity(intent);
            }
        });
    }
}
