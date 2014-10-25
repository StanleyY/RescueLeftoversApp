package com.example.rescueleftoversapp;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.os.Bundle;


public class SignupActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signup);
	}
	
	public void createUser (View v) {
		EditText user = (EditText)findViewById(R.id.SignupUsername);
		EditText first = (EditText)findViewById(R.id.FirstName);
		EditText last = (EditText)findViewById(R.id.LastName);
		EditText phoneN = (EditText)findViewById(R.id.Phone);
		EditText email = (EditText)findViewById(R.id.Email);
		EditText pass = (EditText)findViewById(R.id.SignupPassword);
		String name = first.getText().toString() + last.getText().toString();
		User u = new BasicUser (name, email.getText().toString(), phoneN.getText().toString(), 10);
		PasswordUserTuple x = new PasswordUserTuple(pass.getText().toString(), u);
		MainActivity.map.put(user.getText().toString(), x);
		user.setText("");
		first.setText("");
		last.setText("");
		phoneN.setText("");
		email.setText("");
		pass.setText("");
	}
}
