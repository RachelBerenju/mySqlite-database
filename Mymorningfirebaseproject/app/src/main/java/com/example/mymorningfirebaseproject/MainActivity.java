package com.example.mymorningfirebaseproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
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
    EditText medtname,medtmail,medtpass;
    Button mbtnsave,mbtnview;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        medtmail = findViewById(R.id.edtmail);
        medtname = findViewById(R.id.editname);
        medtpass = findViewById(R.id.edtpass);
        mbtnsave = findViewById(R.id.btnsave);
        mbtnview = findViewById(R.id.btnview);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Saving");
        dialog.setMessage("Please wait...");

        mbtnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Start by receiving data from the user
                String jina = medtname.getText().toString();
                String arafa = medtmail.getText().toString();
                String siri = medtpass.getText().toString();
                long time = System.currentTimeMillis();
                String timeyetu = String.valueOf(time);

                //check if the user is submitting empty fields
                if (jina.isEmpty()|| arafa.isEmpty()|| siri.isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter all the fields", Toast.LENGTH_SHORT).show();
                }else{
                    //proceed to save data
                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Users/"+timeyetu);
                    item x = new item(jina,arafa,siri,timeyetu);
                    dialog.show();
                    ref.setValue(x).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                         dialog.dismiss();
                         if (task.isSuccessful()){
                             Toast.makeText(MainActivity.this, "User saved successfully", Toast.LENGTH_SHORT).show();
                         }else{
                             Toast.makeText(MainActivity.this, "Saving failed", Toast.LENGTH_SHORT).show();
                         }
                        }
                    });

                }

            }
        });
        mbtnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent users = new Intent(MainActivity.this,UsersActivity.class);
                startActivity(users);
            }
        });
    }
}
