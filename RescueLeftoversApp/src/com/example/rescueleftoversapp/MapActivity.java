package com.example.rescueleftoversapp;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        // Get a handle to the Map Fragment
        GoogleMap map = ((MapFragment) getFragmentManager()
                .findFragmentById(R.id.map)).getMap();

        LatLng chase = new LatLng(40.75582, -73.97569);

        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(chase, 15));
        String startTime = "10:30AM";
        String endTime = "11:30AM";
        String date = "October 26, 2014";
        String[] s = new String[]{"Bobby Van's Steakhouse", "Jiannetto's Pizza and Catering", "Chipotle Mexican Grill", "Cosi", "Pret A Manger"};
        double[] d = new double[]{40.754593, -73.975740, 40.755815, -73.976240, 40.757568, -73.974241, 40.754475, -73.977599, 40.756556, -73.976392};
        int j = 0;
        for (int i = 0; i < s.length; i++){
            map.addMarker(new MarkerOptions()
                .title(s[i])
                .snippet(date + " " + startTime + "-" + endTime)
                .position(new LatLng(d[j], d[j+1]))
                );
            j = j+2;
        }
    }
}