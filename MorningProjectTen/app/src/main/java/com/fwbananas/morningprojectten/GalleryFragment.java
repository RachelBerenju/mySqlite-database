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
public class GalleryFragment extends Fragment {

    Button mBtnImg,mBtnVid;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        mBtnImg = root.findViewById(R.id.btnPicha);
        mBtnVid = root.findViewById(R.id.btnVideos);

        mBtnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Images clicked", Toast.LENGTH_SHORT).show();
            }
        });

        mBtnVid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Videos clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }


}
