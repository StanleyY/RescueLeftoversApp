package com.example.rescueleftoversapp;

import java.util.ArrayList;

public abstract class User {

	public int pickupsMade;
	public int pickupsMissed;
	public int points;
	public int weight;
	public String name;
	public String email;
	public String phoneN;
	public ArrayList<Pickup> currentPickups;
	
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
	
	public void setPickupsMade(int m) {
		pickupsMade = m;
	}
	public void setPickupsMissed(int m) {
		pickupsMissed = m;
	}
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

/*-----------------------------------INCREMENTER-----------------------------*/
	public void incrementPickupsMade() {
		pickupsMade++;
	}
	public void incrementPickupsMissed() {
		pickupsMissed++;
	}
	public void incrementPoints(int amnt) {
		points += amnt;
	}
/*----------------------------------OTHERS-----------------------------------*/
	public void addCurrentPickups(Pickup p, int w) {
		currentPickups.add(p);
		p.addUser(this, w);
	}

}
