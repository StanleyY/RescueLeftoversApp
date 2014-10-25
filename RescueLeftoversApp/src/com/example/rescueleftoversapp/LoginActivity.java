package com.example.rescueleftoversapp;


import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.os.Bundle;


public class LoginActivity extends ActionBarActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		android.app.ActionBar actionBar = getActionBar();
        actionBar.hide();
		setContentView(R.layout.activity_login);
	}
	
	public void goMap (View v) {
		EditText user = (EditText)findViewById(R.id.Username);
		EditText pass = (EditText)findViewById(R.id.Password);
		PasswordUserTuple value = MainActivity.map.get(user.getText().toString());
		if (value == null) {
			user.setText("");
			pass.setText("");
		} else if (value.getFirst().equals(pass.getText().toString())) {
			MainActivity.currentUser = value.getSecond();
			Intent intent = new Intent(this, MapActivity.class);
		    startActivity(intent);
		} else {
			user.setText(value.getFirst());
			pass.setText("");
		}
//		Intent intent = new Intent(this, MapActivity.class);
//	    startActivity(intent);
	}

}