package com.fwbananas.morningprojectten;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    Button mBtnReg,mBtnLog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View root = inflater.inflate(R.layout.fragment_home, container, false);
       mBtnReg = root.findViewById(R.id.btnReg);
       mBtnLog = root.findViewById(R.id.btnLog);

       mBtnReg.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(getContext(), "Register clicked", Toast.LENGTH_SHORT).show();
           }
       });

       mBtnLog.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(getContext(), "Login clicked", Toast.LENGTH_SHORT).show();
           }
       });

       return root;
    }


}
