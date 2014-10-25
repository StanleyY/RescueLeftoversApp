package com.example.rescueleftoversapp;

import java.util.ArrayList;

public class Pickup {
	private String address;
	private String restaurantName;
	private Date date;
	private String StartTime;
	private String EndTime;
	private int totalWeight;
	private int accumulatedWeight;
	private String description;
	private int numVolunteers;
	private ArrayList<UserWeightTuple> attendants;
	private ArrayList<UserWeightTuple> waitlist;
	private boolean visibleToVolunteers; 
	private User leader;
	
	public Pickup (String restaurant, Date d, String start, String end, String addr, int weight, String desc) {
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
	
	public Pickup (String restaurant, Date d, String start, String end, String addr, int weight) {
		address = addr;
		restaurantName = restaurant;
		date = d;
		StartTime = start;
		EndTime = end;
		totalWeight = weight;
		accumulatedWeight = 0;
		description = "";
		numVolunteers = 0;
		attendants = new ArrayList<UserWeightTuple>();
		waitlist = new ArrayList<UserWeightTuple>();
		visibleToVolunteers = false;
		leader = null;
	}
	
	public String getRestaurantName () {
		return restaurantName;
	}
	public void setRestaurantName (String name) {
		restaurantName = name;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String add) {
		address = add;
	}
	
	public Date getDate () {
		return date;
	}
	public void setDate (Date d) {
		date = d;
	}
	
	public String getStart () {
		return StartTime;
	}
	public void setStart (String time) {
		StartTime = time;
	}
	
	public String getEnd () {
		return EndTime;
	}
	public void setEnd (String time) {
		EndTime = time;
	}
	
	public int getTotal () {
		return totalWeight;
	}
	public void setTotal (int t) {
		totalWeight = t;
	}
	
	public int getAccumulated () {
		return accumulatedWeight;
	}
	public void setAccumulated (int weight) {
		accumulatedWeight = weight;
	}
	
	public String getDescription () {
		return description;
	}
	public void setDescription (String desc) {
		description = desc;
	}
	
	public int getNumVolunteers () {
		return numVolunteers;
	}
	public void setNumVolunteers (int n) {
		numVolunteers = n;
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
	
	public User getLeader () {
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
			attendants.add(new UserWeightTuple(person, new Integer(weight)));
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
			}
		}
		return temp;
	}
	
	public void waitlist (User person, int weight) {
		
	}
	
	// Returns true if leader is added. Returns false if leader already exists
	public boolean addLeader (User person, int weight) {
		if (leader == null) {
			visibleToVolunteers = true;
			leader = person;
			addUser(person, weight);
			return true;
		} else {
			return false;
		}
	}
}