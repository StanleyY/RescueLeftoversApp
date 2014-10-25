package com.example.rescueleftoversapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("");
		setContentView(R.layout.activity_profile);
		
		//Get the user in question
		User userProfile = MainActivity.currentUser;
		
		// User Information
		String name = userProfile.getName();
		String email = userProfile.getEmail();
		String phn = userProfile.getPhoneN();
		int w = userProfile.getWeight();
		int p = userProfile.getPoints();
		int pmade = userProfile.getPickupsMade();
		int pmissed = userProfile.getPickupsMissed();
		
		
		//TextField references
		TextView nfield = (TextView)findViewById(R.id.viewFirstName);
		TextView emfield = (TextView)findViewById(R.id.viewEmail);
		TextView phfield = (TextView)findViewById(R.id.viewPhone);
		TextView wfield = (TextView)findViewById(R.id.viewWeight);
		TextView pfield = (TextView)findViewById(R.id.viewPoints);
		TextView pmadefield = (TextView)findViewById(R.id.viewPickupsMade);
		TextView pmissedfield = (TextView)findViewById(R.id.viewPickupsMissed);
		
		// Setting to display
		nfield.setText(name);
		emfield.setText(email);
		phfield.setText(phn);
		wfield.setText("" + w);
		pfield.setText("" + p);
		pmadefield.setText("" + pmade);
		pmissedfield.setText("" + pmissed);
		
	}

}
