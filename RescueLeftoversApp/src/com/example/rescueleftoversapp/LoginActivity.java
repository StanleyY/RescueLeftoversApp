package com.example.rescueleftoversapp;


import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;


public class LoginActivity extends ActionBarActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	}
	
	public void goMap (View v) {
//		EditText user = (EditText)findViewById(R.id.Password);
//		EditText pass = (EditText)findViewById(R.id.Username);
//		PasswordUserTuple value = map.get(user.getText().toString());
//		if (value == null) {
//			user.setText("");
//			pass.setText("");
//		} else if (value.getFirst() == pass.getText().toString()) {
//			MainActivity.currentUser = value.getSecond();
//			Intent intent = new Intent(this, MapActivity.class);
//		    startActivity(intent);
//		} else {
//			user.setText("");
//			pass.setText("");
//		}
		Intent intent = new Intent(this, MapActivity.class);
	    startActivity(intent);
	}

}
