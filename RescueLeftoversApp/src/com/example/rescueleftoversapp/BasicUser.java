package com.example.rescueleftoversapp;

import java.util.ArrayList;

public class BasicUser extends User{
	public BasicUser(String n, String em, String pn, int w) {
		name = n;
		weight = w;
		email = em;
		phoneN = pn;
		setCurrentPickups(new ArrayList<Pickup>());
	}
}

//private int pickupsMade;
//private int pickupsMissed;
//private int points;
//private int weight;
//private String name;
//private String email;
//private String phoneN;
//private ArrayList<Pickup> currentPickups;