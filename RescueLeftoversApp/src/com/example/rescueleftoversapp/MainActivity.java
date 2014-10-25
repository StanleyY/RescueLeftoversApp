package com.example.rescueleftoversapp;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {
	public static ArrayList<User> currentUserList;
	public static User currentUser;
	public static HashMap<String, PasswordUserTuple> map;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar actionBar = getActionBar();
        actionBar.hide();
		setContentView(R.layout.activity_main);
		// BasicUser(String n, String em, String pn, int w)
		currentUserList = new ArrayList<User>();
		User userOne = new BasicUser("Bob Joe", "bjoe@yahoo.com", "123-456-7890", 20);
		User userTwo = new BasicUser("Mary Jane", "majne@yahoo.com", "123-456-7890", 15);
		currentUserList.add(userOne);
		currentUserList.add(userTwo);
		if (map == null) {
			map = new HashMap<String, PasswordUserTuple>();
			User u = new BasicUser("Edward Elric", "edward.elric@jpmchase.com", "911", 100);
			map.put("a", new PasswordUserTuple("a", u));
		}
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
	
	
	public void goLogin(View view) {
	    Intent intent = new Intent(this, LoginActivity.class);
	    startActivity(intent);
	}
	
	public void goSignup(View view) {
	    Intent intent = new Intent(this, SignupActivity.class);
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
	public void goMap (View v) {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }
}
