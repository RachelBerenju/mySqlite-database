package com.example.tabbedapp.ui.main;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tabbedapp.R;

/**
 * A simple {@link Fragment} subclass.

 */
public class Products extends Fragment {
    ImageView mpic;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View z = inflater.inflate(R.layout.fragment_products, container, false);
        z.findViewById(R.id.imgtwo);
        mpic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Products clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return z;
    }


}
