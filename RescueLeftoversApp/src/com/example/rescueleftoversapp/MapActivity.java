package com.example.rescueleftoversapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends Activity {
    public final static String EXTRA_MESSAGE = "com.example.rescueleftoversapp.MESSAGE";
    public final static String CURRENT_MARKER = "test";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("");
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
        
        map.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
               Intent intent = new Intent(MapActivity.this,PickupActivity.class);
               String message = marker.getTitle()+marker.getSnippet();
               intent.putExtra(EXTRA_MESSAGE, message);
               intent.putExtra(CURRENT_MARKER, "Test");
               startActivity(intent);
            }
        }); 
    }
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		} else if (id == R.id.profile) {
			goProfile();
			return true;
		} else if (id == R.id.pickups) {
			goPickups();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	public void goPickups() {
		Intent intent = new Intent(this, PickupMenuActivity.class);
		startActivity(intent);
	}
	
	public void goProfile() {
		Intent intent = new Intent(this, ProfileActivity.class);
		startActivity(intent);
	}
}