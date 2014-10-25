package com.example.rescueleftoversapp;

import java.util.ArrayList;

public class Pickup {
	public String address;
	public String restaurantName;
	public String date;
	public String StartTime;
	public String EndTime;
	public int totalWeight;
	public int accumulatedWeight;
	public String description;
	public int numVolunteers;
	public ArrayList<UserWeightTuple> attendants;
	public ArrayList<UserWeightTuple> waitlist;
	public boolean visibleToVolunteers; 
	public LeaderUser leader;
	
	public Pickup (String restaurant, String d, String start, String end, String addr, int weight, String desc) {
		address = addr;
		restaurantName = restaurant;
		date = d;
		StartTime = start;
		EndTime = end;
		totalWeight = weight;
		accumulatedWeight = 0;
		description = desc;
		numVolunteers = 0;
		attendants = new ArrayList<UserWeightTuple>();
		waitlist = new ArrayList<UserWeightTuple>();
		visibleToVolunteers = false;
		leader = null;
	}
	
	public Pickup (String restaurant, String d, String start, String end, String addr, int weight) {
		address = addr;
		restaurantName = restaurant;
		date = d;
		StartTime = start;
		EndTime = end;
		totalWeight = weight;
		accumulatedWeight = 0;
		description = "No Description Available";
		numVolunteers = 0;
		attendants = new ArrayList<UserWeightTuple>();
		waitlist = new ArrayList<UserWeightTuple>();
		visibleToVolunteers = false;
		leader = null;
	}
	
	public ArrayList<UserWeightTuple> getAttendants () {
		return attendants;
	}

	public ArrayList<UserWeightTuple> getWaitlist () {
		return waitlist;
	}
	
	public boolean getVisibileToVolunteers () {
		return visibleToVolunteers;
	}
	
	public LeaderUser getLeader () {
		return leader;
	}
	
	// Return true if add successful, return false if user already in the list
	public boolean addUser (User person, int weight) {
		boolean temp = true;
		for (UserWeightTuple i : attendants) {
			if (i.getFirst() == person) {
				temp = false;
			}
		}
		if (temp) {
			attendants.add(new UserWeightTuple(person, Integer.valueOf(weight)));
			numVolunteers += 1;
		}
		return temp;
	}
	
	// Returns true if drop successful, return false if user not in the list.
	public boolean dropUser (User person) {
		boolean temp = false;
		for (UserWeightTuple i : attendants) {
			if (i.getFirst() == person) {
				temp = true;
				attendants.remove(i);
				numVolunteers -= 1;
			}
		}
		return temp;
	}
	
	// Returns true of add onto waitlist successful, false if user is already on the list.
	public boolean waitlistAdd (User person, int weight) {
		boolean temp = true;
		for (UserWeightTuple i : waitlist) {
			if (i.getFirst() == person) {
				temp = false;
			}
		}
		if (temp) {
			waitlist.add(new UserWeightTuple(person, Integer.valueOf(weight)));
		}
		return temp;
	}
	
	// Returns true if leader is added. Returns false if leader already exists
	public boolean addLeader (LeaderUser person, int weight) {
		if (leader == null) {
			visibleToVolunteers = true;
			leader = person;
			addUser(person, weight);
			return true;
		} else {
			return false;
		}
	}
	
	public String[] display () {
		String[] x = new String[7];
		x[0] = restaurantName;
		x[1] = address;
		x[2] = "People: " + numVolunteers;
		x[3] = "Weight alotted: " + accumulatedWeight + "/" + totalWeight;
		if (leader == null) {
			x[4] = "No Leader";
		} else {
			x[4] = "Lead Rescuer: " + leader.getName();
		}
		x[5] = "Description: " + description;
		x[6] = "Time: " + StartTime + "-" + EndTime + " on " + date.toString();
		return x;
	}
}
