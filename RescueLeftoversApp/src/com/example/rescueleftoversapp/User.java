package com.example.rescueleftoversapp;

import java.util.ArrayList;

public abstract class User {

	private int pickupsMade;
	private int pickupsMissed;
	private int points;
	private int weight;
	private String name;
	private String email;
	private String phoneN;
	private ArrayList<Pickup> currentPickups;
	
/*-----------------------------------GETTERS---------------------------------*/
	public int getPickupsMade() {
		return pickupsMade;
	}
	public int getPickupsMissed() {
		return pickupsMissed;
	}
	public int getPoints() {
		return points;
	}
	public int getWeight() {
		return weight;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPhoneN() {
		return phoneN;
	}
	public ArrayList<Pickup> getCurrentPickups() {
		return currentPickups;
	}
/*-----------------------------------SETTERS---------------------------------*/
	
	public void setWeight(int w) {
		weight = w;
	}
	public void setName (String n) {
		name = n;
	}
	public void setEmail (String e) {
		email = e;
	}
	public void setPhoneN (String pn) {
		phoneN = pn;
	}
	
	public void setCurrentPickups(ArrayList<Pickup> cp) {
		currentPickups = cp;
	}

/*-----------------------------------INCREMENTER------------------------------*/
	public void incrementPickupsMade() {
		pickupsMade++;
	}
	public void incrementPickupsMissed() {
		pickupsMissed++;
	}
	public void incrementPoints(int amnt) {
		points += amnt;
	}
	/*----------------------------------OTHERS--------------------------------*/
}
