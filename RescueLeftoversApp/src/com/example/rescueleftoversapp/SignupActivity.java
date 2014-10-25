package com.example.rescueleftoversapp;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.os.Bundle;


public class SignupActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		android.app.ActionBar actionBar = getActionBar();
        actionBar.hide();
		setContentView(R.layout.activity_signup);
	}
	
public void createUser (View v) {
		EditText user = (EditText)findViewById(R.id.SignupUsername);
		EditText first = (EditText)findViewById(R.id.FirstName);
		EditText last = (EditText)findViewById(R.id.LastName);
		EditText phoneN = (EditText)findViewById(R.id.Phone);
		EditText email = (EditText)findViewById(R.id.Email);
		EditText pass = (EditText)findViewById(R.id.SignupPassword);
//		EditText wt = (EditText)findViewById(R.id.SignupWeight);
//		int w = (int) (Integer.parseInt(wt.getText().toString()));
//		System.out.print(w);
		String name = first.getText().toString() + last.getText().toString();
		User u = new BasicUser (name, email.getText().toString(), phoneN.getText().toString(), 10);
		PasswordUserTuple x = new PasswordUserTuple(pass.getText().toString(), u);
		MainActivity.map.put(user.getText().toString(), x);
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		finish();
	}
}
