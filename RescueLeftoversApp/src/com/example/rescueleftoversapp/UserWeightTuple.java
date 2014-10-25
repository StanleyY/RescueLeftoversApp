package com.example.rescueleftoversapp;

public class UserWeightTuple extends Tuple<User, Integer> {
	public UserWeightTuple (User u, Integer w) {
		setFirst(u);
		setSecond(w);
	}
}
