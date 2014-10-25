package com.example.rescueleftoversapp;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

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

        map.addMarker(new MarkerOptions()
                .title("Sydney")
                .snippet("The most populous city in Australia.")
                .position(chase));
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
	
	public void goMap(View view){
	    Intent intent = new Intent(this, MapActivity.class);
	    startActivity(intent);
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