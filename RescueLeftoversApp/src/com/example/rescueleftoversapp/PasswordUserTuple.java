package com.example.rescueleftoversapp;

public class PasswordUserTuple extends Tuple<String, User>{
	public PasswordUserTuple (String pass, User u) {
		setFirst(pass);
		setSecond(u);
	}
}