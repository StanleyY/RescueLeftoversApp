package com.example.rescueleftoversapp;

import android.support.v7.app.ActionBarActivity;
import android.app.ActionBar;
import android.os.Bundle;


public class SignupActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar actionBar = getActionBar();
        actionBar.hide();
		setContentView(R.layout.activity_signup);
	}

}
