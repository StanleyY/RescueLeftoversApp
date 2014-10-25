package com.example.rescueleftoversapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
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
