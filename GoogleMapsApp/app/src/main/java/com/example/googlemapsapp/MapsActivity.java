package com.example.googlemapsapp;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        LatLng Nairobi = new LatLng(-1.3031934, 36.5672003);
        mMap.addMarker(new MarkerOptions().position(Nairobi).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Nairobi));

        LatLng Arusha = new LatLng(-3.3979698, 36.6071716);
        mMap.addMarker(new MarkerOptions().position(Arusha).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Arusha));

        LatLng Kampala = new LatLng(0.3133718, 0.3133718);
        mMap.addMarker(new MarkerOptions().position(Kampala).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Kampala));

        LatLng Lagos = new LatLng(6.5486598, 3.0037535);
        mMap.addMarker(new MarkerOptions().position(Lagos).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Lagos));

        LatLng AddisAbaba = new LatLng(8.9634897, 38.6380556);
        mMap.addMarker(new MarkerOptions().position(AddisAbaba).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AddisAbaba));

    }
}
