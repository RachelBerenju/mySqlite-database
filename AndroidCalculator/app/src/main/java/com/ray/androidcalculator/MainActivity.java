package com.ray.androidcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mfnum,msnum;
    Button mcalculate;
    TextView manswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mfnum = findViewById(R.id.edtfnuum);
        msnum = findViewById(R.id.edtsnum);
        mcalculate = findViewById(R.id.btncalculate);
        manswer = findViewById(R.id.tvjibu);
        mcalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get the number from the user
                String numberone = mfnum.getText().toString();
                String numbertwo = msnum.getText().toString();
                //Check if the user is submitting empty fields
                if (numberone.isEmpty() || numbertwo.isEmpty()){
                    Toast.makeText(MainActivity.this, "Fill all inputs", Toast.LENGTH_SHORT).show();
                }else {
                    //Convert the received data to a double
                    Double numberoneconv = Double.parseDouble(numberone);
                    Double numbertwoconv = Double.parseDouble(numbertwo);

                    //Finally calculate and give the answer
                    Double answer = numberoneconv+numbertwoconv;

                    //Finally display the answer on your Textview
                    manswer.setText(String.valueOf(answer));
                    mfnum.setText("");
                    msnum.setText("");
                }
            }
        });
    }
}
